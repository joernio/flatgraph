load("//bazel:scala.bzl", "scala_library")

# Domain classes generated from //test-schemas with scala 3 features enabled
# (DomainClassesGenerator.withScala3Features), checked into the source tree.
# Regenerate with `bazel run //test-schemas:generate-domain-classes-scala3`.
scala_library(
    name = "test-schemas-domain-classes-scala3",
    srcs = glob([
        "src/main/scala/**/*.java",
        "src/main/scala/**/*.scala",
    ]),
    javacopts = [
        # the generated java sources use patterns (e.g. double brace initialization)
        # that errorprone complains about
        "-XepDisableAllChecks",
    ],
    visibility = ["//visibility:public"],
    deps = [
        "//core",
        "//help",
    ],
)
