name := "flatgraph"
ThisBuild / organization := "io.joern.flatgraph"
ThisBuild / scalaVersion := scala3
publish / skip := true

val slf4jVersion = "2.0.7"
val scala3 = "3.3.1"
val scala2_12 = "2.12.18"

/** Only the below listed projects are included in things like `sbt compile`.
  * We explicitly want to exclude `benchmarks` which requires qwiet.ai / shiftleft
  * internal repositories. */
lazy val root = (project in file("."))
  .aggregate(core, schema_3, schema_2_12, formats, domainClassesGenerator, sbtPlugin, odbConvert)

lazy val core = project
  .in(file("core"))
  .settings(
    name := "core",
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
    name := "formats",
    libraryDependencies ++= Seq(
      "com.github.tototoshi" %% "scala-csv" % "1.3.10",
      "org.scala-lang.modules" %% "scala-xml" % "2.1.0",
      "io.spray" %% "spray-json" % "1.3.6",
      "com.github.scopt" %% "scopt" % "4.1.0",
      "com.github.pathikrit" %% "better-files" % "3.9.2" % Test,
    )
  )

lazy val schema_3 = project
  .settings(
    name := "schema",
    scalaVersion := scala3,
    sourceDirectory := baseDirectory.value / "../schema/src",
    libraryDependencies += "com.lihaoyi" %% "os-lib" % "0.9.1",
  )

lazy val schema_2_12 = project
  .settings(
    name := "schema",
    scalaVersion := scala2_12,
    scalacOptions := scalacOptionsFor2_12,
    sourceDirectory := baseDirectory.value / "../schema/src",
    libraryDependencies += "com.lihaoyi" %% "os-lib" % "0.9.1",
  )

lazy val domainClassesGenerator = project
  .in(file("domain-classes-generator"))
  .dependsOn(schema_2_12)
  .settings(
    name := "domain-classes-generator",
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
    name := "domain-classes-generator",
    sourceDirectory := baseDirectory.value / "../domain-classes-generator/src",
    scalaVersion := scala2_12,
    scalacOptions := scalacOptionsFor2_12,
    libraryDependencies ++= Seq(
      "org.slf4j"% "slf4j-simple" % slf4jVersion % Optional,
      "com.lihaoyi" %% "os-lib" % "0.9.1",
      "org.apache.commons" % "commons-text" % "1.10.0",
      "com.github.scopt"  %% "scopt"        % "4.1.0",
      ("org.scalameta" %% "scalafmt-dynamic" % "3.7.17").cross(CrossVersion.for3Use2_13),
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
    name := "odb-convert",
    libraryDependencies ++= Seq(
      "io.shiftleft" %% "overflowdb-core" % "1.181",
      "org.slf4j" % "slf4j-simple" % slf4jVersion % Optional
    )
  )


/** temporarily we still want to keep the generated files for the cpg domain in here,
  * in order to be able to quickly see the differences in the generated files if we
  * change the codegen
  * n.b. relies on a manually published version of cpg-schema based on the `michael/flatgraph` branch
  *
  * https://github.com/ShiftLeftSecurity/overflowdbv2/pull/137#pullrequestreview-1761992014
  */
lazy val domainClassesGeneratorJoern = project
  .in(file("domain-classes-generator-joern"))
  .dependsOn(domainClassesGenerator_2_12)
  .settings(
    name := "domain-classes-generator-joern",
    scalaVersion := scala2_12,
    scalacOptions := scalacOptionsFor2_12,
    publish / skip := true,
    libraryDependencies += "com.michaelpollmeier" %% "codepropertygraph-schema" % "1.4.32+25-1e56e611"
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
