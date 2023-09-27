#!/bin/bash

sbt schemaGen/stage

./schema-gen/target/universal/stage/bin/schema-gen ./joern-generated/src/main/scala/generated/ "cpg"

sbt joernGenerated/scalafmt
