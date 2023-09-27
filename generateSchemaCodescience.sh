#!/bin/bash

sbt schemaGen/stage

./schema-gen/target/universal/stage/bin/schema-gen ./codescience-generated/src/main/scala/generated/ "cs"

sbt codescienceGenerated/scalafmt
