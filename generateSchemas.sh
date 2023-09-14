#!/bin/bash

rm ./joern-generated/src/main/scala/generated/*.scala
rm ./codescience-generated/src/main/scala/generated/*.scala

sbt schemaGen/compile schemaGen/stage
./schema-gen/target/universal/stage/bin/schema-gen ./joern-generated/src/main/scala/generated/ "cpg"
./schema-gen/target/universal/stage/bin/schema-gen ./codescience-generated/src/main/scala/generated/ "cs"
sbt joernGenerated/scalafmt codescienceGenerated/scalafmt
