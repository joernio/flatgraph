name := "odb-convert"
enablePlugins(JavaAppPackaging)

libraryDependencies ++= Seq(
  "io.shiftleft" % "overflowdb-core" % "1.169",
  "org.slf4j" % "slf4j-simple" % Versions.slf4j % Optional
)
