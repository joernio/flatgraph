load("//bazel:scala.bzl", "scala_library", "scala_test")

scala_library(
    name = "help",
    srcs = glob(["src/main/scala/**/*.scala"]),
    visibility = ["//visibility:public"],
    deps = [
        "//core",
        "@maven//:net_oneandone_reflections8_reflections8",
    ],
)

scala_test(
    name = "tests",
    srcs = glob(["src/test/scala/**/*.scala"]),
    deps = [
        ":help",
    ],
)
