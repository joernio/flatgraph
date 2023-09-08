name := "odb-convert"
enablePlugins(JavaAppPackaging)

libraryDependencies ++= Seq("io.shiftleft" % "overflowdb-core" % "1.169", "org.slf4j" % "slf4j-simple" % "2.0.6" % Optional)
