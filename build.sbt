name := "overflowdbv2"
ThisBuild / organization := "io.joern"
ThisBuild / scalaVersion := "3.3.1"
publish / skip := true

val cpgVersion = "1.4.22"
val joernVersion = "2.0.86"

lazy val core                 = project.in(file("core"))
lazy val schemaGen            = project.in(file("schema-gen")).dependsOn(core)
lazy val odbConvert           = project.in(file("odb-convert")).dependsOn(core)
lazy val joernGenerated       = project.in(file("joern-generated")).dependsOn(core)
lazy val codescienceGenerated = project.in(file("codescience-generated")).dependsOn(core)
lazy val benchmarks           = project.in(file("benchmarks")).dependsOn(core).dependsOn(joernGenerated)

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

ThisBuild / resolvers ++= Seq(
  Resolver.mavenLocal,
  "Sonatype OSS" at "https://oss.sonatype.org/content/repositories/public",
  // TODO take out, we're currently relying on closed source in an open source build (codescience-schema)
  "Artifactory release local" at "https://shiftleft.jfrog.io/shiftleft/libs-release-local",
)

Global / cancelable           := true
Global / onChangedBuildSource := ReloadOnSourceChanges
