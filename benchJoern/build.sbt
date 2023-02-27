name := "bench-joern"
enablePlugins(JavaAppPackaging)

libraryDependencies ++= Seq(
  "io.joern"       %% "semanticcpg"     % "1.1.1483",
  "com.jerolba"     % "jmnemohistosyne" % "0.2.3",
  "org.openjdk.jol" % "jol-core"        % "0.17",
  "org.slf4j"       % "slf4j-simple"    % "2.0.6" % Optional
)
