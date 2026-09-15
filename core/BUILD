load("//bazel:scala.bzl", "scala_library", "scala_test")

scala_library(
    name = "core",
    srcs = glob([
        "src/main/java/**/*.java",
        "src/main/scala/**/*.java",
        "src/main/scala/**/*.scala",
    ]),
    visibility = ["//visibility:public"],
    deps = [
        "@maven//:com_github_luben_zstd_jni",
        # ujson.Value extends geny.Writable and ujson.AstTransformer extends
        # upickle.core.Transformer - both must be on the compile classpath,
        # otherwise the scala compiler crashes with "trait Value has non-class parent"
        "@maven//:com_lihaoyi_geny_3",
        "@maven//:com_lihaoyi_ujson_3",
        "@maven//:com_lihaoyi_upickle_core_3",
        "@maven//:org_slf4j_slf4j_api",
    ],
)

scala_test(
    name = "tests",
    srcs = glob(["src/test/scala/**/*.scala"]),
    deps = [
        ":core",
    ],
)
