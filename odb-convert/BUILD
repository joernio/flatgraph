load("//bazel:scala.bzl", "scala_binary", "scala_library")

scala_library(
    name = "odb-convert",
    srcs = glob(["src/main/scala/**/*.scala"]),
    visibility = ["//visibility:public"],
    deps = [
        "//core",
        "@maven//:io_shiftleft_overflowdb_core_3",
        "@maven//:org_slf4j_slf4j_api",
    ],
)

scala_binary(
    name = "convert",
    main_class = "flatgraph.convert.Convert",
    runtime_deps = [
        ":odb-convert",
    ],
)
