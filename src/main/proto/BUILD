load("//third_party/bazel:genproto.bzl", "proto_java_library")
load("@org_pubref_rules_protobuf//java:rules.bzl", "java_proto_library")


package(default_visibility = ["//visibility:public"])

java_proto_library(
  name = "config_proto",
  protos = [
    "config.proto",
  ]
)

proto_java_library(
  name = "hello_proto_grpc",
  src = "hello.proto",
  gen_grpc = True,
)

proto_java_library(
  name = "hello_proto",
  src = "hello.proto",
  gen_grpc = False,
)