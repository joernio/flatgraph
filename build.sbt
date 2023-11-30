name := "flatgraph"
ThisBuild / organization := "io.joern.flatgraph"
ThisBuild / scalaVersion := "3.3.1"
publish / skip := true

val slf4jVersion = "2.0.7"

/** Only the below listed projects are included in things like `sbt compile`.
  * We explicitly want to exclude `benchmarks` which requires qwiet.ai / shiftleft
  * internal repositories. */
lazy val root = (project in file(".")).aggregate(core, domainClassesGenerator, odbConvert)

lazy val core = project
  .in(file("core"))
  .settings(
    name := "core",
    libraryDependencies ++= Seq(
      "com.lihaoyi"     %% "upickle"  % "3.1.3",
      "com.github.luben" % "zstd-jni" % "1.5.0-4",
      "org.slf4j" % "slf4j-api" % slf4jVersion,
      // for @help and @Doc etc.
      "net.oneandone.reflections8" % "reflections8" % "0.11.7", // go back to reflections once 0.9.13 is released
    )
  )

lazy val domainClassesGenerator = project
  .in(file("domain-classes-generator"))
  .dependsOn(core)
  .settings(
    name := "domain-classes-generator",
    libraryDependencies ++= Seq(
      // TODO take out 'overflowdb-codegen' dependency and make the schema (and reused functionality from the codegen) part of this build
      "io.shiftleft"      %% "overflowdb-codegen" % "2.105",
      "org.slf4j"          % "slf4j-simple"       % slf4jVersion % Optional,
      "org.apache.commons" % "commons-text"       % "1.10.0",
      "com.lihaoyi"       %% "os-lib"             % "0.9.1",
    )
  )

lazy val odbConvert = project
  .in(file("odb-convert"))
  .dependsOn(core)
  .enablePlugins(JavaAppPackaging)
  .settings(
    name := "odb-convert",
    libraryDependencies ++= Seq(
      "io.shiftleft" % "overflowdb-core" % "1.169",
      "org.slf4j" % "slf4j-simple" % slf4jVersion % Optional
    )
  )

// TODO bring back as a separate subproject which isn't included in project list by default
// lazy val benchmarks = project
//   .in(file("benchmarks"))
//   .dependsOn(joernGenerated)
//   .enablePlugins(JavaAppPackaging, JmhPlugin)
//   .settings(
//     name := "benchmarks",
//     //Jmh / compile := (Jmh / compile)
//     //Jmh / run     := (Jmh / run).dependsOn(Jmh / compile).evaluated
//     libraryDependencies ++= Seq(
//       "io.joern"       %% "semanticcpg"              % "2.0.157",
//       "com.jerolba"     % "jmnemohistosyne"          % "0.2.3",
//       "org.openjdk.jol" % "jol-core"                 % "0.17",
//       "org.slf4j"       % "slf4j-simple"             % slf4jVersion % Optional,
//       "org.openjdk.jmh" % "jmh-generator-annprocess" % "1.36",
//       "org.openjdk.jmh" % "jmh-core"                 % "1.36",
//     )
//   )

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

ThisBuild / compile / javacOptions ++= Seq(
  "-g", // debug symbols
  "--release=8"
)

Global / cancelable           := true
Global / onChangedBuildSource := ReloadOnSourceChanges
