#!/bin/bash

sbt \
    "domainClassesGeneratorCodescience/run codescience-generated/src/main/scala/generated" \
    codescienceGenerated/scalafmt
