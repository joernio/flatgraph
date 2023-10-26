#!/bin/bash

sbt \
    "domainClassesGeneratorCodescience/run codescience-generated/src/main/scala" \
    codescienceGenerated/scalafmt
