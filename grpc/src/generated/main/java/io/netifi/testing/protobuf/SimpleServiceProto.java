// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: io/netifi/thunderdome/grpc/nonblocking/stock/simpleservice.proto

package io.netifi.testing.protobuf;

public final class SimpleServiceProto {
  private SimpleServiceProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_io_netifi_testing_SimpleRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_io_netifi_testing_SimpleRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_io_netifi_testing_SimpleResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_io_netifi_testing_SimpleResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n@io/netifi/thunderdome/grpc/nonblocking" +
      "/stock/simpleservice.proto\022\021io.netifi.te" +
      "sting\032\033google/protobuf/empty.proto\"\'\n\rSi" +
      "mpleRequest\022\026\n\016requestMessage\030\001 \001(\t\")\n\016S" +
      "impleResponse\022\027\n\017responseMessage\030\001 \001(\t2\342" +
      "\003\n\rSimpleService\022U\n\014RequestReply\022 .io.ne" +
      "tifi.testing.SimpleRequest\032!.io.netifi.t" +
      "esting.SimpleResponse\"\000\022K\n\rFireAndForget" +
      "\022 .io.netifi.testing.SimpleRequest\032\026.goo" +
      "gle.protobuf.Empty\"\000\022X\n\rRequestStream\022 ." +
      "io.netifi.testing.SimpleRequest\032!.io.net" +
      "ifi.testing.SimpleResponse\"\0000\001\022i\n\036Stream" +
      "ingRequestSingleResponse\022 .io.netifi.tes" +
      "ting.SimpleRequest\032!.io.netifi.testing.S" +
      "impleResponse\"\000(\001\022h\n\033StreamingRequestAnd" +
      "Response\022 .io.netifi.testing.SimpleReque" +
      "st\032!.io.netifi.testing.SimpleResponse\"\000(" +
      "\0010\001B2\n\032io.netifi.testing.protobufB\022Simpl" +
      "eServiceProtoP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf.EmptyProto.getDescriptor(),
        }, assigner);
    internal_static_io_netifi_testing_SimpleRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_io_netifi_testing_SimpleRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_io_netifi_testing_SimpleRequest_descriptor,
        new java.lang.String[] { "RequestMessage", });
    internal_static_io_netifi_testing_SimpleResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_io_netifi_testing_SimpleResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_io_netifi_testing_SimpleResponse_descriptor,
        new java.lang.String[] { "ResponseMessage", });
    com.google.protobuf.EmptyProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
