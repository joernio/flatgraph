#!/bin/bash

rm ./joernGenerated/src/main/scala/generated/*.scala

sbt schemaGen/compile schemaGen/stage
./schemaGen/target/universal/stage/bin/schemagen ./joernGenerated/src/main/scala/generated/ "cpg"
sbt joernGenerated/scalafmt
