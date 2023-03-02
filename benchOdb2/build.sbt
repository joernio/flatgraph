name := "bench-odb2"
enablePlugins(JavaAppPackaging)

libraryDependencies ++= Seq(
  "com.jerolba"     % "jmnemohistosyne" % "0.2.3",
  "org.openjdk.jol" % "jol-core"        % "0.16",
  "org.slf4j"       % "slf4j-simple"    % "2.0.6" % Optional
)
