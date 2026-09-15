load("//bazel:scala.bzl", "scala_library")

scala_library(
    name = "formats",
    srcs = glob(["src/main/scala/**/*.scala"]),
    visibility = ["//visibility:public"],
    deps = [
        "//core",
        "@maven//:com_fasterxml_jackson_core_jackson_core",
        "@maven//:com_github_scopt_scopt_3",
        "@maven//:com_github_tototoshi_scala_csv_3",
        "@maven//:io_spray_spray_json_3",
        "@maven//:org_apache_commons_commons_text",
        "@maven//:org_scala_lang_modules_scala_xml_3",
    ],
)
