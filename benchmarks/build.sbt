name := "benchStuff"
enablePlugins(JavaAppPackaging)
enablePlugins(JmhPlugin)

//Jmh / compile := (Jmh / compile)
//Jmh / run     := (Jmh / run).dependsOn(Jmh / compile).evaluated
libraryDependencies ++= Seq(
  "io.joern"       %% "semanticcpg"              % "1.1.1483",
  "com.jerolba"     % "jmnemohistosyne"          % "0.2.3",
  "org.openjdk.jol" % "jol-core"                 % "0.17",
  "org.slf4j"       % "slf4j-simple"             % "2.0.6" % Optional,
  "org.openjdk.jmh" % "jmh-generator-annprocess" % "1.36",
  "org.openjdk.jmh" % "jmh-core"                 % "1.36"
)
