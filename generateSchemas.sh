#!/bin/bash

rm ./joernGenerated/src/main/scala/generated/*.scala
rm ./codescienceGenerated/src/main/scala/generated/*.scala

sbt schemaGen/compile schemaGen/stage
./schemaGen/target/universal/stage/bin/schemagen ./joernGenerated/src/main/scala/generated/ "cpg"
./schemaGen/target/universal/stage/bin/schemagen ./codescienceGenerated/src/main/scala/generated/ "cs"
sbt joernGenerated/scalafmt codescienceGenerated/scalafmt
