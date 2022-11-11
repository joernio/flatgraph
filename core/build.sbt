name := "odb2-core"

libraryDependencies ++= Seq(
  // "org.slf4j" % "slf4j-api" % "1.7.36"
  "com.fasterxml.jackson.core"    % "jackson-databind"     % "2.13.4",
  "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.13.4"
)

/* it's a java-only build */
//autoScalaLibrary := false
//crossPaths := false
