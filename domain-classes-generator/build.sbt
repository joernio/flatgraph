name := "domain-classes-generator"
enablePlugins(JavaAppPackaging)

libraryDependencies ++= Seq(
  "io.shiftleft"      %% "codepropertygraph-schema" % Versions.cpg,
  "org.slf4j"          % "slf4j-simple"             % Versions.slf4j % Optional,
  "org.apache.commons" % "commons-text"             % "1.10.0",
  "com.lihaoyi"       %% "os-lib"                   % "0.9.1",
)
