load("//bazel:scala.bzl", "scala_test")

scala_test(
    name = "tests",
    srcs = glob(["src/test/scala/**/*.scala"]),
    # make resources available as files in the runfiles tree; tests find them via
    # testutils.ProjectRoot (the working directory of a bazel test is the runfiles root)
    data = glob(["src/test/resources/**/*"]),
    deps = [
        "//core",
        "//formats",
        "//help",
        "//test-schemas-domain-classes",
        "@maven//:com_github_pathikrit_better_files_3",
        "@maven//:org_scalamock_scalamock_3",
    ],
)
