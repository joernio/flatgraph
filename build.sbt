name := "flatgraph"
ThisBuild / organization := "io.joern"
ThisBuild / scalaVersion := scala3

val slf4jVersion = "2.0.7"
val scala3 = "3.4.1"
val scala2_12 = "2.12.18"

/** Only the below listed projects are included in things like `sbt compile`.
  * We explicitly want to exclude `benchmarks` which requires qwiet.ai / shiftleft
  * internal repositories. */
lazy val root = (project in file(".")).aggregate(
    core,
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
      "com.lihaoyi"     %% "upickle"  % "3.1.3",
      "com.github.luben" % "zstd-jni" % "1.5.0-4",
      "org.slf4j" % "slf4j-api" % slf4jVersion,

      // for doc/help
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
      "com.github.tototoshi" %% "scala-csv" % "1.3.10",
      "org.scala-lang.modules" %% "scala-xml" % "2.1.0",
      "io.spray" %% "spray-json" % "1.3.6",
      "com.github.scopt" %% "scopt" % "4.1.0",
    )
  )

/** tests that make use of the sample schemas (and the corresponding generated domain classes) */
lazy val tests = project
  .in(file("tests"))
  .dependsOn(formats, testSchemasDomainClasses)
  .settings(
    name := "flatgraph-tests",
    publish / skip := true,
    libraryDependencies += "com.github.pathikrit" %% "better-files" % "3.9.2" % Test
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
      "org.apache.commons" % "commons-text" % "1.10.0",
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
  )

lazy val testSchemasDomainClasses = project
  .in(file("test-schemas-domain-classes"))
  .dependsOn(core)
  .settings(
    name := "test-schemas-domain-classes",
    publish / skip := true
  )

/** temporarily we still want to keep the generated files for the cpg domain in here,
  * in order to be able to quickly see the differences in the generated files if we
  * change the codegen
  * n.b. relies on a manually published version of cpg-schema from https://github.com/ShiftLeftSecurity/codepropertygraph/tree/michael/flatgraph
  */
lazy val domainClassesGeneratorJoern = project
  .in(file("domain-classes-generator-joern"))
  .dependsOn(domainClassesGenerator_3)
  .settings(
    name := "domain-classes-generator-joern",
    scalaVersion := scala3,
    publish / skip := true,
    libraryDependencies += "io.shiftleft" %% "codepropertygraph-schema" % "1.6.6+21-c6774ab5"
  )

lazy val joernGenerated = project
  .in(file("joern-generated"))
  .dependsOn(core)
  .settings(
    name := "joern-generated",
    publish / skip := true
  )

lazy val benchmarks = project
  .in(file("benchmarks"))
  .dependsOn(joernGenerated)
  .enablePlugins(JavaAppPackaging, JmhPlugin)
  .settings(
    name := "benchmarks",
    //Jmh / compile := (Jmh / compile)
    //Jmh / run     := (Jmh / run).dependsOn(Jmh / compile).evaluated
    libraryDependencies ++= Seq(
      "io.joern"       %% "semanticcpg"              % "2.0.157",
      "com.jerolba"     % "jmnemohistosyne"          % "0.2.3",
      "org.openjdk.jol" % "jol-core"                 % "0.17",
      "org.slf4j"       % "slf4j-simple"             % slf4jVersion % Optional,
      "org.openjdk.jmh" % "jmh-generator-annprocess" % "1.36",
      "org.openjdk.jmh" % "jmh-core"                 % "1.36",
    ),
    publish / skip := true
  )

ThisBuild / libraryDependencies ++= Seq(
  "org.slf4j" % "slf4j-simple" % "2.0.7" % Test,
  "org.scalatest" %% "scalatest" % "3.2.17" % Test,
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
sonatypeCredentialHost := "s01.oss.sonatype.org"
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
