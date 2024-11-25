name := "flatgraph"
ThisBuild / organization := "io.joern"
ThisBuild / scalaVersion := scala3

val slf4jVersion = "2.0.7"
val scala3 = "3.4.3"
val scala2_12 = "2.12.20"

/** Only the below listed projects are included in things like `sbt compile`.
  * We explicitly want to exclude `benchmarks` which requires qwiet.ai / shiftleft
  * internal repositories. */
lazy val root = (project in file(".")).aggregate(
  core,
  help,
  formats,
  domainClassesGenerator_3,
  domainClassesGenerator_2_12,
  sbtPlugin,
  odbConvert,
  testSchemas,
  testSchemasDomainClasses,
  tests,
)

lazy val core = project
  .in(file("core"))
  .settings(
    name := "flatgraph-core",
    libraryDependencies ++= Seq(
      "com.lihaoyi"     %% "ujson"  % "3.3.1",
      "com.github.luben" % "zstd-jni" % "1.5.6-8",
      "org.slf4j" % "slf4j-api" % slf4jVersion,
    )
  )

lazy val help = project
  .in(file("help"))
  .dependsOn(core)
  .settings(
    name := "flatgraph-help",
    libraryDependencies ++= Seq(
      "de.vandermeer" % "asciitable" % "0.3.2",
      "net.oneandone.reflections8" % "reflections8" % "0.11.7",
    )
  )

lazy val formats = project
  .in(file("formats"))
  .dependsOn(core)
  .settings(
    name := "flatgraph-formats",
    libraryDependencies ++= Seq(
      "com.github.tototoshi" %% "scala-csv" % "1.4.1",
      "org.scala-lang.modules" %% "scala-xml" % "2.3.0",
      "io.spray" %% "spray-json" % "1.3.6",
      "com.github.scopt" %% "scopt" % "4.1.0",
    )
  )

lazy val generateDomainClassesForTestSchemas = taskKey[Unit]("generate domain classes for test schemas")

/** tests that make use of the sample schemas (and the corresponding generated domain classes) */
lazy val tests = project
  .in(file("tests"))
  .dependsOn(core, formats, help, testSchemasDomainClasses)
  .settings(
    name := "flatgraph-tests",
    publish / skip := true,
    libraryDependencies ++= Seq(
      "com.github.pathikrit" %% "better-files" % "3.9.2" % Test,
      "org.scalamock" %% "scalamock" % "6.0.0" % Test
    ),
  )


lazy val domainClassesGenerator_3 = project
  .in(file("domain-classes-generator_3"))
  .settings(
    name := "flatgraph-domain-classes-generator",
    sourceDirectory := baseDirectory.value / "../domain-classes-generator/src",
    libraryDependencies ++= Seq(
      "org.slf4j" % "slf4j-simple" % slf4jVersion % Optional,
      "com.lihaoyi" %% "os-lib" % "0.9.1",
      "org.apache.commons" % "commons-text" % "1.10.0",
      "com.github.scopt" %% "scopt" % "4.1.0",
      ("org.scalameta" %% "scalafmt-dynamic" % "3.7.17").cross(CrossVersion.for3Use2_13),
    ),
  )

lazy val domainClassesGenerator_2_12 = project
  .in(file("domain-classes-generator_2.12"))
  .settings(
    name := "flatgraph-domain-classes-generator",
    sourceDirectory := baseDirectory.value / "../domain-classes-generator/src",
    scalaVersion := scala2_12,
    scalacOptions := scalacOptionsFor2_12,
    libraryDependencies ++= Seq(
      "org.slf4j"% "slf4j-simple" % slf4jVersion % Optional,
      "com.lihaoyi" %% "os-lib" % "0.9.1",
      "org.apache.commons" % "commons-text" % "1.12.0",
      "com.github.scopt" %% "scopt" % "4.1.0",
      "org.scalameta" %% "scalafmt-dynamic" % "3.7.17",
    ),
  )

lazy val sbtPlugin = project
  .in(file("sbt-flatgraph"))
  .dependsOn(domainClassesGenerator_2_12)
  .enablePlugins(SbtPlugin)
  .settings(
    name := "sbt-flatgraph",
    scalaVersion := scala2_12,
    scalacOptions := scalacOptionsFor2_12,
    addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.5.2"),
    // the default sbt naming convention for plugins does not conform to the
    // maven specification - see https://github.com/sbt/sbt/issues/3410
    sbtPluginPublishLegacyMavenStyle := false,
  )

lazy val odbConvert = project
  .in(file("odb-convert"))
  .dependsOn(core)
  .enablePlugins(JavaAppPackaging)
  .settings(
    name := "flatgraph-odb-convert",
    libraryDependencies ++= Seq(
      "io.shiftleft" %% "overflowdb-core" % "1.181",
      "org.slf4j" % "slf4j-simple" % slf4jVersion % Optional
    )
  )

lazy val testSchemas = project
  .in(file("test-schemas"))
  .dependsOn(domainClassesGenerator_3)
  .settings(
    name := "test-schemas",
    scalaVersion := scala3,
    publish / skip := true,
    generateDomainClassesForTestSchemas := Def.taskDyn {
      /** invoking the codegen and scalafmt is expensive, so we only want to do so if the hashsum of the
       *  inputs (codegen implementation, build setup, test schemas, scalafmt config) is unknown or different to the
       *  last known one. We persist the hashsum to preserve it between sbt sessions.
       */
      val lastKnownHashsumFile = target.value / "codegen-inputs-hash.md5"
      def lastKnownHashsum: Option[String] = scala.util.Try(IO.read(lastKnownHashsumFile)).toOption
      val inputsHashsum = FileUtils.md5(
        sourceDirectory.value,
        file("build.sbt"),
        (ThisBuild / baseDirectory).value / "domain-classes-generator/src",
      )

      if (lastKnownHashsum == Some(inputsHashsum)) {
        Def.task {
          streams.value.log.info("no need to regenerate domain classes for test schemas")
        }
      } else {
        Def.task {
          (Compile/runMain).toTask(s" flatgraph.testdomains.GenerateDomainClasses").value
          IO.write(lastKnownHashsumFile, inputsHashsum)
        }
      }
    }.value,
  )

lazy val testSchemasDomainClasses = project
  .in(file("test-schemas-domain-classes"))
  .dependsOn(core, help)
  .settings(
    name := "test-schemas-domain-classes",
    Compile/compile := (Compile/compile).dependsOn(testSchemas/generateDomainClassesForTestSchemas).value,
    publish / skip := true,
  )

// currently relies on a self-published version of codepropertygraph and joern based on the respective `michael/flatgraph` branches
/*
lazy val benchmarks = project
  .in(file("benchmarks"))
  .enablePlugins(JavaAppPackaging, JmhPlugin)
  .settings(
    name := "benchmarks",
    //Jmh / compile := (Jmh / compile)
    //Jmh / run     := (Jmh / run).dependsOn(Jmh / compile).evaluated
    libraryDependencies ++= Seq(
      // TODO upgrade to released version
      "io.joern"       %% "semanticcpg"              % "2.0.350+18-f76162b1",
      "com.jerolba"     % "jmnemohistosyne"          % "0.2.3",
      "org.openjdk.jol" % "jol-core"                 % "0.17",
      "org.slf4j"       % "slf4j-simple"             % slf4jVersion % Optional,
      "org.openjdk.jmh" % "jmh-generator-annprocess" % "1.36",
      "org.openjdk.jmh" % "jmh-core"                 % "1.36",
    ),
    publish / skip := true
  )
*/


ThisBuild / libraryDependencies ++= Seq(
  "org.slf4j" % "slf4j-simple" % slf4jVersion % Test,
  "org.scalatest" %% "scalatest" % "3.2.19" % Test,
)

ThisBuild / scalacOptions ++= Seq(
  "-deprecation",
  "-feature",
  "--release", "8",
  "-language:implicitConversions"
)

val scalacOptionsFor2_12 = Seq(
  "-deprecation",
  "-feature",
  "-language:implicitConversions"
)

ThisBuild / compile / javacOptions ++= Seq(
  "-g", // debug symbols
  "--release=8"
)

Global / cancelable           := true
Global / onChangedBuildSource := ReloadOnSourceChanges

ThisBuild / publishTo := sonatypePublishToBundle.value
ThisBuild / sonatypeCredentialHost := xerial.sbt.Sonatype.sonatypeCentralHost
ThisBuild / scmInfo := Some(
  ScmInfo(url("https://github.com/joernio/flatgraph"), "scm:git@github.com:joernio/flatgraph.git")
)
ThisBuild / homepage := Some(url("https://github.com/joernio/flatgraph/"))

ThisBuild / licenses := List("Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0"))
ThisBuild / developers := List(
  Developer("bbrehm", "Bernhard Brehm", "bernhard@shiftleft.io", url("https://github.com/bbrehm")),
  Developer("mpollmeier", "Michael Pollmeier", "michael@michaelpollmeier.com", url("http://www.michaelpollmeier.com"))
)

publish / skip := true // don't publish the root project
