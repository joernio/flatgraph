load("//bazel:scala.bzl", "scala_binary", "scala_library")

scala_library(
    name = "domain-classes-generator",
    srcs = glob(["src/main/scala/**/*.scala"]),
    visibility = ["//visibility:public"],
    deps = [
        "@maven//:com_github_scopt_scopt_3",
        "@maven//:com_lihaoyi_os_lib_3",
        "@maven//:org_apache_commons_commons_text",
        "@maven//:org_scalameta_scalafmt_dynamic_2_13",
        "@maven//:org_slf4j_slf4j_api",
    ],
)

# Entry point for generating domain classes from a schema definition,
# e.g. `bazel run //domain-classes-generator:codegen -- -c 'some.schema.Class$' -f instance -o out/dir`
scala_binary(
    name = "codegen",
    main_class = "flatgraph.codegen.Main",
    runtime_deps = [
        ":domain-classes-generator",
    ],
)
