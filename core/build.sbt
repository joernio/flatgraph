name := "odb2-core"

libraryDependencies ++= Seq(
  // "org.slf4j" % "slf4j-api" % "1.7.36"
  "com.lihaoyi"     %% "upickle"  % "2.0.0",
  "com.github.luben" % "zstd-jni" % "1.5.0-4"
)

/* it's a java-only build */
//autoScalaLibrary := false
//crossPaths := false
