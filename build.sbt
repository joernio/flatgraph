name                           := "overflowdbv2"
ThisBuild / organization       := "io.joern"
ThisBuild / scalaVersion       := "2.13.8"
ThisBuild / crossScalaVersions := Seq("2.13.8", "3.1.2")
publish / skip                 := true

lazy val core                 = project.in(file("core"))
lazy val schemaGen            = project.in(file("schemaGen")).dependsOn(core)
lazy val odbConvert           = project.in(file("odbConvert")).dependsOn(core)
lazy val joernGenerated       = project.in(file("joernGenerated")).dependsOn(core)
lazy val codescienceGenerated = project.in(file("codescienceGenerated")).dependsOn(core)
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

ThisBuild / resolvers ++= Seq(
  Resolver.mavenLocal,
  "Sonatype OSS" at "https://oss.sonatype.org/content/repositories/public",
  // TODO take out, we're currently relying on closed source in an open source build (codescience-schema)
  "Artifactory release local" at "https://shiftleft.jfrog.io/shiftleft/libs-release-local",
)

Global / cancelable           := true
Global / onChangedBuildSource := ReloadOnSourceChanges
