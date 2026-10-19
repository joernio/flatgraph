load("@bazel_tooling//:scala_rule_factory.bzl", "make_scala_rules")

_rules = make_scala_rules(
    scala_version = "3.9.0",
    common_scalacopts = [
        "-java-output-version",
        "17",
        "-no-indent",
        "-old-syntax",
        "-deprecation",
        "-feature",
        "-language:implicitConversions",
        "-Wconf:msg=Implicit parameters should be provided with a `using` clause:s",
    ],
    # Applies to the Java sources of mixed Java/Scala targets which rules_scala
    # compiles in a separate Javac action that does not see the javacopts from
    # bazel/java.bzl. Keep in sync with java_common_opts there.
    common_javacopts = [
        "-g",
        "--release=17",
        "-Xlint:all",
        "-Xlint:-cast",
    ],
    common_scala_binary_runtime_deps = [],
    common_scala_test_runtime_deps = [
        "@maven//:org_slf4j_slf4j_simple",
    ],
)

scala_library = _rules.scala_library
scala_binary = _rules.scala_binary
scala_test = _rules.scala_test
