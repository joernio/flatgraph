name := "schemaGen"
enablePlugins(JavaAppPackaging)

libraryDependencies ++= Seq(
  "io.joern"          %% "semanticcpg"              % "1.1.1455",
  "org.slf4j"          % "slf4j-simple"             % "2.0.6" % Optional,
  "io.shiftleft"      %% "codepropertygraph-schema" % "1.3.596",
  "io.shiftleft"      %% "codescience-schema"       % "1.5.78",
  "org.apache.commons" % "commons-text"             % "1.10.0"
)
