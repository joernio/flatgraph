name := "bench-joern"
enablePlugins(JavaAppPackaging)

libraryDependencies ++= Seq("io.joern" %% "semanticcpg" % "1.1.1455", "com.jerolba" % "jmnemohistosyne" % "0.2.3")

/* it's a java-only build */
//autoScalaLibrary := false
//crossPaths := false
