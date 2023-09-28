#!/bin/bash

sbt \
    "schemaGenCodescience/run codescience-generated/src/main/scala/generated" \
    codescienceGenerated/scalafmt
