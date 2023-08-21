name                           := "overflowdbv2"
ThisBuild / organization       := "io.joern"
ThisBuild / scalaVersion       := "3.3.0"
publish / skip                 := true

lazy val core                 = project.in(file("core"))
lazy val schemaGen            = project.in(file("schemaGen")).dependsOn(core)
lazy val odbConvert           = project.in(file("odbConvert")).dependsOn(core)
lazy val joernGenerated       = project.in(file("joernGenerated")).dependsOn(core)
lazy val benchStuff           = project.in(file("benchStuff")).dependsOn(core).dependsOn(joernGenerated)

ThisBuild / libraryDependencies ++= Seq(
  "org.slf4j" % "slf4j-simple" % "2.0.7" % Test,
  "org.scalatest" %% "scalatest" % "3.2.15" % Test
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
