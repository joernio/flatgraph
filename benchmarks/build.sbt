name := "benchmarks"
enablePlugins(JavaAppPackaging)
enablePlugins(JmhPlugin)

//Jmh / compile := (Jmh / compile)
//Jmh / run     := (Jmh / run).dependsOn(Jmh / compile).evaluated
libraryDependencies ++= Seq(
  "io.joern"       %% "semanticcpg"              % Versions.joern,
  "com.jerolba"     % "jmnemohistosyne"          % "0.2.3",
  "org.openjdk.jol" % "jol-core"                 % "0.17",
  "org.slf4j"       % "slf4j-simple"             % Versions.slf4j % Optional,
  "org.openjdk.jmh" % "jmh-generator-annprocess" % "1.36",
  "org.openjdk.jmh" % "jmh-core"                 % "1.36"
)
