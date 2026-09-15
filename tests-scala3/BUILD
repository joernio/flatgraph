load("//bazel:scala.bzl", "scala_test")

scala_test(
    name = "tests",
    srcs = glob(["src/test/scala/**/*.scala"]),
    deps = [
        "//core",
        "//test-schemas-domain-classes-scala3",
    ],
)
