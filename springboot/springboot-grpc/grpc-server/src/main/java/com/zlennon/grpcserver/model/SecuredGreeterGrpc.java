package com.zlennon.grpcserver.model;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@jakarta.annotation.Generated(
    value = "by gRPC proto compiler (version 1.59.0)",
    comments = "Source: greeter.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SecuredGreeterGrpc {

  private SecuredGreeterGrpc() {}

  public static final java.lang.String SERVICE_NAME = "SecuredGreeter";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      GreeterOuterClass.HelloReply> getSayAuthHelloMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SayAuthHello",
      requestType = com.google.protobuf.Empty.class,
      responseType = GreeterOuterClass.HelloReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      GreeterOuterClass.HelloReply> getSayAuthHelloMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, GreeterOuterClass.HelloReply> getSayAuthHelloMethod;
    if ((getSayAuthHelloMethod = SecuredGreeterGrpc.getSayAuthHelloMethod) == null) {
      synchronized (SecuredGreeterGrpc.class) {
        if ((getSayAuthHelloMethod = SecuredGreeterGrpc.getSayAuthHelloMethod) == null) {
          SecuredGreeterGrpc.getSayAuthHelloMethod = getSayAuthHelloMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, GreeterOuterClass.HelloReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SayAuthHello"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GreeterOuterClass.HelloReply.getDefaultInstance()))
              .setSchemaDescriptor(new SecuredGreeterMethodDescriptorSupplier("SayAuthHello"))
              .build();
        }
      }
    }
    return getSayAuthHelloMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      GreeterOuterClass.HelloReply> getSayAuthHello2Method;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SayAuthHello2",
      requestType = com.google.protobuf.Empty.class,
      responseType = GreeterOuterClass.HelloReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      GreeterOuterClass.HelloReply> getSayAuthHello2Method() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, GreeterOuterClass.HelloReply> getSayAuthHello2Method;
    if ((getSayAuthHello2Method = SecuredGreeterGrpc.getSayAuthHello2Method) == null) {
      synchronized (SecuredGreeterGrpc.class) {
        if ((getSayAuthHello2Method = SecuredGreeterGrpc.getSayAuthHello2Method) == null) {
          SecuredGreeterGrpc.getSayAuthHello2Method = getSayAuthHello2Method =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, GreeterOuterClass.HelloReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SayAuthHello2"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GreeterOuterClass.HelloReply.getDefaultInstance()))
              .setSchemaDescriptor(new SecuredGreeterMethodDescriptorSupplier("SayAuthHello2"))
              .build();
        }
      }
    }
    return getSayAuthHello2Method;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.google.protobuf.Empty> getSecuredMethodsWithUnderScoResMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "secured_Methods_With_UnderScoRes",
      requestType = com.google.protobuf.Empty.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.google.protobuf.Empty> getSecuredMethodsWithUnderScoResMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, com.google.protobuf.Empty> getSecuredMethodsWithUnderScoResMethod;
    if ((getSecuredMethodsWithUnderScoResMethod = SecuredGreeterGrpc.getSecuredMethodsWithUnderScoResMethod) == null) {
      synchronized (SecuredGreeterGrpc.class) {
        if ((getSecuredMethodsWithUnderScoResMethod = SecuredGreeterGrpc.getSecuredMethodsWithUnderScoResMethod) == null) {
          SecuredGreeterGrpc.getSecuredMethodsWithUnderScoResMethod = getSecuredMethodsWithUnderScoResMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "secured_Methods_With_UnderScoRes"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new SecuredGreeterMethodDescriptorSupplier("secured_Methods_With_UnderScoRes"))
              .build();
        }
      }
    }
    return getSecuredMethodsWithUnderScoResMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.google.protobuf.Empty> getAnotherSecuredMethodsWithUnderScoResMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AnotherSecured_Methods_With_UnderScoRes",
      requestType = com.google.protobuf.Empty.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.google.protobuf.Empty> getAnotherSecuredMethodsWithUnderScoResMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, com.google.protobuf.Empty> getAnotherSecuredMethodsWithUnderScoResMethod;
    if ((getAnotherSecuredMethodsWithUnderScoResMethod = SecuredGreeterGrpc.getAnotherSecuredMethodsWithUnderScoResMethod) == null) {
      synchronized (SecuredGreeterGrpc.class) {
        if ((getAnotherSecuredMethodsWithUnderScoResMethod = SecuredGreeterGrpc.getAnotherSecuredMethodsWithUnderScoResMethod) == null) {
          SecuredGreeterGrpc.getAnotherSecuredMethodsWithUnderScoResMethod = getAnotherSecuredMethodsWithUnderScoResMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AnotherSecured_Methods_With_UnderScoRes"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new SecuredGreeterMethodDescriptorSupplier("AnotherSecured_Methods_With_UnderScoRes"))
              .build();
        }
      }
    }
    return getAnotherSecuredMethodsWithUnderScoResMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SecuredGreeterStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SecuredGreeterStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SecuredGreeterStub>() {
        @java.lang.Override
        public SecuredGreeterStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SecuredGreeterStub(channel, callOptions);
        }
      };
    return SecuredGreeterStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SecuredGreeterBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SecuredGreeterBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SecuredGreeterBlockingStub>() {
        @java.lang.Override
        public SecuredGreeterBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SecuredGreeterBlockingStub(channel, callOptions);
        }
      };
    return SecuredGreeterBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SecuredGreeterFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SecuredGreeterFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SecuredGreeterFutureStub>() {
        @java.lang.Override
        public SecuredGreeterFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SecuredGreeterFutureStub(channel, callOptions);
        }
      };
    return SecuredGreeterFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void sayAuthHello(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<GreeterOuterClass.HelloReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSayAuthHelloMethod(), responseObserver);
    }

    /**
     */
    default void sayAuthHello2(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<GreeterOuterClass.HelloReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSayAuthHello2Method(), responseObserver);
    }

    /**
     */
    default void securedMethodsWithUnderScoRes(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSecuredMethodsWithUnderScoResMethod(), responseObserver);
    }

    /**
     */
    default void anotherSecuredMethodsWithUnderScoRes(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAnotherSecuredMethodsWithUnderScoResMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service SecuredGreeter.
   */
  public static abstract class SecuredGreeterImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return SecuredGreeterGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service SecuredGreeter.
   */
  public static final class SecuredGreeterStub
      extends io.grpc.stub.AbstractAsyncStub<SecuredGreeterStub> {
    private SecuredGreeterStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SecuredGreeterStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SecuredGreeterStub(channel, callOptions);
    }

    /**
     */
    public void sayAuthHello(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<GreeterOuterClass.HelloReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSayAuthHelloMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sayAuthHello2(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<GreeterOuterClass.HelloReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSayAuthHello2Method(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void securedMethodsWithUnderScoRes(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSecuredMethodsWithUnderScoResMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void anotherSecuredMethodsWithUnderScoRes(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAnotherSecuredMethodsWithUnderScoResMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service SecuredGreeter.
   */
  public static final class SecuredGreeterBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SecuredGreeterBlockingStub> {
    private SecuredGreeterBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SecuredGreeterBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SecuredGreeterBlockingStub(channel, callOptions);
    }

    /**
     */
    public GreeterOuterClass.HelloReply sayAuthHello(com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSayAuthHelloMethod(), getCallOptions(), request);
    }

    /**
     */
    public GreeterOuterClass.HelloReply sayAuthHello2(com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSayAuthHello2Method(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty securedMethodsWithUnderScoRes(com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSecuredMethodsWithUnderScoResMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty anotherSecuredMethodsWithUnderScoRes(com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAnotherSecuredMethodsWithUnderScoResMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service SecuredGreeter.
   */
  public static final class SecuredGreeterFutureStub
      extends io.grpc.stub.AbstractFutureStub<SecuredGreeterFutureStub> {
    private SecuredGreeterFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SecuredGreeterFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SecuredGreeterFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<GreeterOuterClass.HelloReply> sayAuthHello(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSayAuthHelloMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<GreeterOuterClass.HelloReply> sayAuthHello2(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSayAuthHello2Method(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> securedMethodsWithUnderScoRes(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSecuredMethodsWithUnderScoResMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> anotherSecuredMethodsWithUnderScoRes(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAnotherSecuredMethodsWithUnderScoResMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SAY_AUTH_HELLO = 0;
  private static final int METHODID_SAY_AUTH_HELLO2 = 1;
  private static final int METHODID_SECURED_METHODS_WITH_UNDER_SCO_RES = 2;
  private static final int METHODID_ANOTHER_SECURED_METHODS_WITH_UNDER_SCO_RES = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SAY_AUTH_HELLO:
          serviceImpl.sayAuthHello((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<GreeterOuterClass.HelloReply>) responseObserver);
          break;
        case METHODID_SAY_AUTH_HELLO2:
          serviceImpl.sayAuthHello2((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<GreeterOuterClass.HelloReply>) responseObserver);
          break;
        case METHODID_SECURED_METHODS_WITH_UNDER_SCO_RES:
          serviceImpl.securedMethodsWithUnderScoRes((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_ANOTHER_SECURED_METHODS_WITH_UNDER_SCO_RES:
          serviceImpl.anotherSecuredMethodsWithUnderScoRes((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getSayAuthHelloMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.protobuf.Empty,
              GreeterOuterClass.HelloReply>(
                service, METHODID_SAY_AUTH_HELLO)))
        .addMethod(
          getSayAuthHello2Method(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.protobuf.Empty,
              GreeterOuterClass.HelloReply>(
                service, METHODID_SAY_AUTH_HELLO2)))
        .addMethod(
          getSecuredMethodsWithUnderScoResMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.protobuf.Empty,
              com.google.protobuf.Empty>(
                service, METHODID_SECURED_METHODS_WITH_UNDER_SCO_RES)))
        .addMethod(
          getAnotherSecuredMethodsWithUnderScoResMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.protobuf.Empty,
              com.google.protobuf.Empty>(
                service, METHODID_ANOTHER_SECURED_METHODS_WITH_UNDER_SCO_RES)))
        .build();
  }

  private static abstract class SecuredGreeterBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SecuredGreeterBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return GreeterOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SecuredGreeter");
    }
  }

  private static final class SecuredGreeterFileDescriptorSupplier
      extends SecuredGreeterBaseDescriptorSupplier {
    SecuredGreeterFileDescriptorSupplier() {}
  }

  private static final class SecuredGreeterMethodDescriptorSupplier
      extends SecuredGreeterBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    SecuredGreeterMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (SecuredGreeterGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SecuredGreeterFileDescriptorSupplier())
              .addMethod(getSayAuthHelloMethod())
              .addMethod(getSayAuthHello2Method())
              .addMethod(getSecuredMethodsWithUnderScoResMethod())
              .addMethod(getAnotherSecuredMethodsWithUnderScoResMethod())
              .build();
        }
      }
    }
    return result;
  }
}
