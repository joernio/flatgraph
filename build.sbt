name := "overflowdbv2"
ThisBuild / organization := "io.joern"
ThisBuild / scalaVersion := "2.13.8"
ThisBuild / crossScalaVersions := Seq("2.13.8", "3.1.2")
publish / skip := true

lazy val core = project.in(file("core"))
lazy val benchJoern = project.in(file("benchJoern"))

ThisBuild / libraryDependencies ++= Seq(
  "org.slf4j" % "slf4j-simple" % "2.0.6" % Test,
  "org.scalatest" %% "scalatest" % "3.2.12" % Test,
)

ThisBuild / scalacOptions ++= Seq("-deprecation", "-feature") ++ (
  CrossVersion.partialVersion(scalaVersion.value) match {
    case Some((3, _)) =>
      Seq(
//        "-Xtarget:8"
      )
    case _ =>
      Seq(
//        "-target:jvm-1.8"
      )
  }
)

ThisBuild / compile / javacOptions ++= Seq(
  "-g", //debug symbols
//  "--release=8"
)
ThisBuild / scalacOptions ++= Seq("-target:jvm-1.8",// "--release", "8"
  )

ThisBuild / resolvers ++= Seq(Resolver.mavenLocal,
                              "Sonatype OSS" at "https://oss.sonatype.org/content/repositories/public")

ThisBuild / Compile / scalacOptions ++= Seq(
//  "-Xfatal-warnings",
  "-language:implicitConversions",
  // "-language:existentials",
)

Global / cancelable := true
Global / onChangedBuildSource := ReloadOnSourceChanges
