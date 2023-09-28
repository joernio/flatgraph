#!/bin/bash

sbt \
    "domainClassesGenerator/run joern-generated/src/main/scala/generated" \
    joernGenerated/scalafmt
