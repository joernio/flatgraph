name := "flatgraph"
ThisBuild / organization := "io.joern"
ThisBuild / scalaVersion := "3.3.1"
publish / skip := true

val cpgVersion = "1.4.29"
val joernVersion = "2.0.157"
val slf4jVersion = "2.0.7"

/** Only the below listed projects are included in things like `sbt compile`.
  * We explicitly want to exclude domainClassesGeneratorCodescience and codescienceGenerated here, in order to be able
  * to build outside of a qwiet.ai / shiftleft environment - specifically on CI
  */
lazy val root = (project in file(".")).aggregate(core, domainClassesGenerator, odbConvert, joernGenerated, benchmarks)

lazy val core = project
  .in(file("core"))
  .settings(
    name := "flatgraph-core",
    libraryDependencies ++= Seq(
      "com.lihaoyi"     %% "upickle"  % "3.1.3",
      "com.github.luben" % "zstd-jni" % "1.5.0-4"
    )
  )

lazy val domainClassesGenerator = project
  .in(file("domain-classes-generator"))
  .dependsOn(core)
  .settings(
    name := "domain-classes-generator",
    libraryDependencies ++= Seq(
      "io.shiftleft"      %% "codepropertygraph-schema" % cpgVersion,
      "org.slf4j"          % "slf4j-simple"             % slf4jVersion % Optional,
      "org.apache.commons" % "commons-text"             % "1.10.0",
      "com.lihaoyi"       %% "os-lib"                   % "0.9.1",
    )
  )

lazy val joernGenerated = project
  .in(file("joern-generated"))
  .dependsOn(core)
  .settings(name := "joern-generated")

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

lazy val benchmarks = project
  .in(file("benchmarks"))
  .dependsOn(joernGenerated)
  .enablePlugins(JavaAppPackaging, JmhPlugin)
  .settings(
    name := "benchmarks",
    //Jmh / compile := (Jmh / compile)
    //Jmh / run     := (Jmh / run).dependsOn(Jmh / compile).evaluated
    libraryDependencies ++= Seq(
      "io.joern"       %% "semanticcpg"              % joernVersion,
      "com.jerolba"     % "jmnemohistosyne"          % "0.2.3",
      "org.openjdk.jol" % "jol-core"                 % "0.17",
      "org.slf4j"       % "slf4j-simple"             % slf4jVersion % Optional,
      "org.openjdk.jmh" % "jmh-generator-annprocess" % "1.36",
      "org.openjdk.jmh" % "jmh-core"                 % "1.36",
    )
  )

lazy val domainClassesGeneratorCodescience = project
  .in(file("domain-classes-generator-codescience"))
  .dependsOn(core, domainClassesGenerator)
  .enablePlugins(JavaAppPackaging)
  .settings(
    name := "domain-classes-generator-codescience",
    libraryDependencies += "io.shiftleft" %% "codescience-schema" % "1.5.78"
  )

lazy val codescienceGenerated = project
  .in(file("codescience-generated"))
  .dependsOn(core)
  .settings(name := "codescience-generated")

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
  // only relevant for `codescienceGenerated` which is not part of the `aggregatedProjects`
  "Artifactory release local" at "https://shiftleft.jfrog.io/shiftleft/libs-release-local",
)

Global / cancelable           := true
Global / onChangedBuildSource := ReloadOnSourceChanges
