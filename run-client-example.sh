echo 'recipient: "Polyglot"' | ./bazel-bin/src/main/java/polyglot/polyglot \
  --full_method=polyglot.HelloService/SayHello \
  --endpoint=localhost:12345 \
  --proto_root=./src/main/proto