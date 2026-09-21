load("//bazel:scala.bzl", "scala_binary", "scala_library")

# Schema definitions for the test domains. The corresponding generated domain
# classes are checked in under //test-schemas-domain-classes.
scala_library(
    name = "test-schemas",
    srcs = glob(["src/main/scala/**/*.scala"]),
    deps = [
        "//domain-classes-generator",
    ],
)

# Regenerates the checked-in domain classes in //test-schemas-domain-classes
# (writes into the source tree, like the sbt task `generateDomainClassesForTestSchemas`).
# Run via `bazel run //test-schemas:generate-domain-classes`.
scala_binary(
    name = "generate-domain-classes",
    main_class = "flatgraph.testdomains.GenerateDomainClasses",
    runtime_deps = [
        ":test-schemas",
    ],
)

# Same for the scala 3 feature variant in //test-schemas-domain-classes-scala3
# (sbt task `generateDomainClassesForTestSchemasScala3`).
# Run via `bazel run //test-schemas:generate-domain-classes-scala3`.
scala_binary(
    name = "generate-domain-classes-scala3",
    main_class = "flatgraph.testdomains.GenerateDomainClassesScala3",
    runtime_deps = [
        ":test-schemas",
    ],
)
