#!/bin/bash

sbt \
    "schemaGen/run joern-generated/src/main/scala/generated" \
    joernGenerated/scalafmt
