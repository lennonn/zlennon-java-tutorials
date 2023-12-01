package com.zlennon.grpcserver.model;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * The greeter service definition.
 * </pre>
 */
@jakarta.annotation.Generated(
    value = "by gRPC proto compiler (version 1.59.0)",
    comments = "Source: greeter.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class GreeterGrpc {

  private GreeterGrpc() {}

  public static final java.lang.String SERVICE_NAME = "Greeter";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<GreeterOuterClass.HelloRequest,
      GreeterOuterClass.HelloReply> getSayHelloMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SayHello",
      requestType = GreeterOuterClass.HelloRequest.class,
      responseType = GreeterOuterClass.HelloReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<GreeterOuterClass.HelloRequest,
      GreeterOuterClass.HelloReply> getSayHelloMethod() {
    io.grpc.MethodDescriptor<GreeterOuterClass.HelloRequest, GreeterOuterClass.HelloReply> getSayHelloMethod;
    if ((getSayHelloMethod = GreeterGrpc.getSayHelloMethod) == null) {
      synchronized (GreeterGrpc.class) {
        if ((getSayHelloMethod = GreeterGrpc.getSayHelloMethod) == null) {
          GreeterGrpc.getSayHelloMethod = getSayHelloMethod =
              io.grpc.MethodDescriptor.<GreeterOuterClass.HelloRequest, GreeterOuterClass.HelloReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SayHello"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GreeterOuterClass.HelloRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GreeterOuterClass.HelloReply.getDefaultInstance()))
              .setSchemaDescriptor(new GreeterMethodDescriptorSupplier("SayHello"))
              .build();
        }
      }
    }
    return getSayHelloMethod;
  }

  private static volatile io.grpc.MethodDescriptor<GreeterOuterClass.HelloRequest,
      GreeterOuterClass.HelloReply> getSayManyHellosMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SayManyHellos",
      requestType = GreeterOuterClass.HelloRequest.class,
      responseType = GreeterOuterClass.HelloReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<GreeterOuterClass.HelloRequest,
      GreeterOuterClass.HelloReply> getSayManyHellosMethod() {
    io.grpc.MethodDescriptor<GreeterOuterClass.HelloRequest, GreeterOuterClass.HelloReply> getSayManyHellosMethod;
    if ((getSayManyHellosMethod = GreeterGrpc.getSayManyHellosMethod) == null) {
      synchronized (GreeterGrpc.class) {
        if ((getSayManyHellosMethod = GreeterGrpc.getSayManyHellosMethod) == null) {
          GreeterGrpc.getSayManyHellosMethod = getSayManyHellosMethod =
              io.grpc.MethodDescriptor.<GreeterOuterClass.HelloRequest, GreeterOuterClass.HelloReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SayManyHellos"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GreeterOuterClass.HelloRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GreeterOuterClass.HelloReply.getDefaultInstance()))
              .setSchemaDescriptor(new GreeterMethodDescriptorSupplier("SayManyHellos"))
              .build();
        }
      }
    }
    return getSayManyHellosMethod;
  }

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
    if ((getSayAuthHelloMethod = GreeterGrpc.getSayAuthHelloMethod) == null) {
      synchronized (GreeterGrpc.class) {
        if ((getSayAuthHelloMethod = GreeterGrpc.getSayAuthHelloMethod) == null) {
          GreeterGrpc.getSayAuthHelloMethod = getSayAuthHelloMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, GreeterOuterClass.HelloReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SayAuthHello"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GreeterOuterClass.HelloReply.getDefaultInstance()))
              .setSchemaDescriptor(new GreeterMethodDescriptorSupplier("SayAuthHello"))
              .build();
        }
      }
    }
    return getSayAuthHelloMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      GreeterOuterClass.HelloReply> getSayAuthOnlyHelloMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SayAuthOnlyHello",
      requestType = com.google.protobuf.Empty.class,
      responseType = GreeterOuterClass.HelloReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      GreeterOuterClass.HelloReply> getSayAuthOnlyHelloMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, GreeterOuterClass.HelloReply> getSayAuthOnlyHelloMethod;
    if ((getSayAuthOnlyHelloMethod = GreeterGrpc.getSayAuthOnlyHelloMethod) == null) {
      synchronized (GreeterGrpc.class) {
        if ((getSayAuthOnlyHelloMethod = GreeterGrpc.getSayAuthOnlyHelloMethod) == null) {
          GreeterGrpc.getSayAuthOnlyHelloMethod = getSayAuthOnlyHelloMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, GreeterOuterClass.HelloReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SayAuthOnlyHello"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GreeterOuterClass.HelloReply.getDefaultInstance()))
              .setSchemaDescriptor(new GreeterMethodDescriptorSupplier("SayAuthOnlyHello"))
              .build();
        }
      }
    }
    return getSayAuthOnlyHelloMethod;
  }

  private static volatile io.grpc.MethodDescriptor<GreeterOuterClass.Person,
      GreeterOuterClass.Person> getHelloPersonValidResponseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "HelloPersonValidResponse",
      requestType = GreeterOuterClass.Person.class,
      responseType = GreeterOuterClass.Person.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<GreeterOuterClass.Person,
      GreeterOuterClass.Person> getHelloPersonValidResponseMethod() {
    io.grpc.MethodDescriptor<GreeterOuterClass.Person, GreeterOuterClass.Person> getHelloPersonValidResponseMethod;
    if ((getHelloPersonValidResponseMethod = GreeterGrpc.getHelloPersonValidResponseMethod) == null) {
      synchronized (GreeterGrpc.class) {
        if ((getHelloPersonValidResponseMethod = GreeterGrpc.getHelloPersonValidResponseMethod) == null) {
          GreeterGrpc.getHelloPersonValidResponseMethod = getHelloPersonValidResponseMethod =
              io.grpc.MethodDescriptor.<GreeterOuterClass.Person, GreeterOuterClass.Person>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "HelloPersonValidResponse"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GreeterOuterClass.Person.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GreeterOuterClass.Person.getDefaultInstance()))
              .setSchemaDescriptor(new GreeterMethodDescriptorSupplier("HelloPersonValidResponse"))
              .build();
        }
      }
    }
    return getHelloPersonValidResponseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<GreeterOuterClass.Person,
      GreeterOuterClass.Person> getHelloPersonInvalidResponseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "HelloPersonInvalidResponse",
      requestType = GreeterOuterClass.Person.class,
      responseType = GreeterOuterClass.Person.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<GreeterOuterClass.Person,
      GreeterOuterClass.Person> getHelloPersonInvalidResponseMethod() {
    io.grpc.MethodDescriptor<GreeterOuterClass.Person, GreeterOuterClass.Person> getHelloPersonInvalidResponseMethod;
    if ((getHelloPersonInvalidResponseMethod = GreeterGrpc.getHelloPersonInvalidResponseMethod) == null) {
      synchronized (GreeterGrpc.class) {
        if ((getHelloPersonInvalidResponseMethod = GreeterGrpc.getHelloPersonInvalidResponseMethod) == null) {
          GreeterGrpc.getHelloPersonInvalidResponseMethod = getHelloPersonInvalidResponseMethod =
              io.grpc.MethodDescriptor.<GreeterOuterClass.Person, GreeterOuterClass.Person>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "HelloPersonInvalidResponse"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GreeterOuterClass.Person.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GreeterOuterClass.Person.getDefaultInstance()))
              .setSchemaDescriptor(new GreeterMethodDescriptorSupplier("HelloPersonInvalidResponse"))
              .build();
        }
      }
    }
    return getHelloPersonInvalidResponseMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GreeterStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GreeterStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GreeterStub>() {
        @java.lang.Override
        public GreeterStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GreeterStub(channel, callOptions);
        }
      };
    return GreeterStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GreeterBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GreeterBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GreeterBlockingStub>() {
        @java.lang.Override
        public GreeterBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GreeterBlockingStub(channel, callOptions);
        }
      };
    return GreeterBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GreeterFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GreeterFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GreeterFutureStub>() {
        @java.lang.Override
        public GreeterFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GreeterFutureStub(channel, callOptions);
        }
      };
    return GreeterFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * The greeter service definition.
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    default void sayHello(GreeterOuterClass.HelloRequest request,
                          io.grpc.stub.StreamObserver<GreeterOuterClass.HelloReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSayHelloMethod(), responseObserver);
    }

    /**
     */
    default io.grpc.stub.StreamObserver<GreeterOuterClass.HelloRequest> sayManyHellos(
        io.grpc.stub.StreamObserver<GreeterOuterClass.HelloReply> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getSayManyHellosMethod(), responseObserver);
    }

    /**
     */
    default void sayAuthHello(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<GreeterOuterClass.HelloReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSayAuthHelloMethod(), responseObserver);
    }

    /**
     */
    default void sayAuthOnlyHello(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<GreeterOuterClass.HelloReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSayAuthOnlyHelloMethod(), responseObserver);
    }

    /**
     */
    default void helloPersonValidResponse(GreeterOuterClass.Person request,
                                          io.grpc.stub.StreamObserver<GreeterOuterClass.Person> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getHelloPersonValidResponseMethod(), responseObserver);
    }

    /**
     */
    default void helloPersonInvalidResponse(GreeterOuterClass.Person request,
                                            io.grpc.stub.StreamObserver<GreeterOuterClass.Person> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getHelloPersonInvalidResponseMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Greeter.
   * <pre>
   * The greeter service definition.
   * </pre>
   */
  public static abstract class GreeterImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return GreeterGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Greeter.
   * <pre>
   * The greeter service definition.
   * </pre>
   */
  public static final class GreeterStub
      extends io.grpc.stub.AbstractAsyncStub<GreeterStub> {
    private GreeterStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GreeterStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GreeterStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public void sayHello(GreeterOuterClass.HelloRequest request,
                         io.grpc.stub.StreamObserver<GreeterOuterClass.HelloReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSayHelloMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<GreeterOuterClass.HelloRequest> sayManyHellos(
        io.grpc.stub.StreamObserver<GreeterOuterClass.HelloReply> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getSayManyHellosMethod(), getCallOptions()), responseObserver);
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
    public void sayAuthOnlyHello(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<GreeterOuterClass.HelloReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSayAuthOnlyHelloMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void helloPersonValidResponse(GreeterOuterClass.Person request,
                                         io.grpc.stub.StreamObserver<GreeterOuterClass.Person> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getHelloPersonValidResponseMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void helloPersonInvalidResponse(GreeterOuterClass.Person request,
                                           io.grpc.stub.StreamObserver<GreeterOuterClass.Person> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getHelloPersonInvalidResponseMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Greeter.
   * <pre>
   * The greeter service definition.
   * </pre>
   */
  public static final class GreeterBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<GreeterBlockingStub> {
    private GreeterBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GreeterBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GreeterBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public GreeterOuterClass.HelloReply sayHello(GreeterOuterClass.HelloRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSayHelloMethod(), getCallOptions(), request);
    }

    /**
     */
    public GreeterOuterClass.HelloReply sayAuthHello(com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSayAuthHelloMethod(), getCallOptions(), request);
    }

    /**
     */
    public GreeterOuterClass.HelloReply sayAuthOnlyHello(com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSayAuthOnlyHelloMethod(), getCallOptions(), request);
    }

    /**
     */
    public GreeterOuterClass.Person helloPersonValidResponse(GreeterOuterClass.Person request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getHelloPersonValidResponseMethod(), getCallOptions(), request);
    }

    /**
     */
    public GreeterOuterClass.Person helloPersonInvalidResponse(GreeterOuterClass.Person request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getHelloPersonInvalidResponseMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Greeter.
   * <pre>
   * The greeter service definition.
   * </pre>
   */
  public static final class GreeterFutureStub
      extends io.grpc.stub.AbstractFutureStub<GreeterFutureStub> {
    private GreeterFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GreeterFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GreeterFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<GreeterOuterClass.HelloReply> sayHello(
        GreeterOuterClass.HelloRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSayHelloMethod(), getCallOptions()), request);
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
    public com.google.common.util.concurrent.ListenableFuture<GreeterOuterClass.HelloReply> sayAuthOnlyHello(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSayAuthOnlyHelloMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<GreeterOuterClass.Person> helloPersonValidResponse(
        GreeterOuterClass.Person request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getHelloPersonValidResponseMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<GreeterOuterClass.Person> helloPersonInvalidResponse(
        GreeterOuterClass.Person request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getHelloPersonInvalidResponseMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SAY_HELLO = 0;
  private static final int METHODID_SAY_AUTH_HELLO = 1;
  private static final int METHODID_SAY_AUTH_ONLY_HELLO = 2;
  private static final int METHODID_HELLO_PERSON_VALID_RESPONSE = 3;
  private static final int METHODID_HELLO_PERSON_INVALID_RESPONSE = 4;
  private static final int METHODID_SAY_MANY_HELLOS = 5;

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
        case METHODID_SAY_HELLO:
          serviceImpl.sayHello((GreeterOuterClass.HelloRequest) request,
              (io.grpc.stub.StreamObserver<GreeterOuterClass.HelloReply>) responseObserver);
          break;
        case METHODID_SAY_AUTH_HELLO:
          serviceImpl.sayAuthHello((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<GreeterOuterClass.HelloReply>) responseObserver);
          break;
        case METHODID_SAY_AUTH_ONLY_HELLO:
          serviceImpl.sayAuthOnlyHello((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<GreeterOuterClass.HelloReply>) responseObserver);
          break;
        case METHODID_HELLO_PERSON_VALID_RESPONSE:
          serviceImpl.helloPersonValidResponse((GreeterOuterClass.Person) request,
              (io.grpc.stub.StreamObserver<GreeterOuterClass.Person>) responseObserver);
          break;
        case METHODID_HELLO_PERSON_INVALID_RESPONSE:
          serviceImpl.helloPersonInvalidResponse((GreeterOuterClass.Person) request,
              (io.grpc.stub.StreamObserver<GreeterOuterClass.Person>) responseObserver);
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
        case METHODID_SAY_MANY_HELLOS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.sayManyHellos(
              (io.grpc.stub.StreamObserver<GreeterOuterClass.HelloReply>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getSayHelloMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              GreeterOuterClass.HelloRequest,
              GreeterOuterClass.HelloReply>(
                service, METHODID_SAY_HELLO)))
        .addMethod(
          getSayManyHellosMethod(),
          io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
            new MethodHandlers<
              GreeterOuterClass.HelloRequest,
              GreeterOuterClass.HelloReply>(
                service, METHODID_SAY_MANY_HELLOS)))
        .addMethod(
          getSayAuthHelloMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.protobuf.Empty,
              GreeterOuterClass.HelloReply>(
                service, METHODID_SAY_AUTH_HELLO)))
        .addMethod(
          getSayAuthOnlyHelloMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.protobuf.Empty,
              GreeterOuterClass.HelloReply>(
                service, METHODID_SAY_AUTH_ONLY_HELLO)))
        .addMethod(
          getHelloPersonValidResponseMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              GreeterOuterClass.Person,
              GreeterOuterClass.Person>(
                service, METHODID_HELLO_PERSON_VALID_RESPONSE)))
        .addMethod(
          getHelloPersonInvalidResponseMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              GreeterOuterClass.Person,
              GreeterOuterClass.Person>(
                service, METHODID_HELLO_PERSON_INVALID_RESPONSE)))
        .build();
  }

  private static abstract class GreeterBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GreeterBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return GreeterOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Greeter");
    }
  }

  private static final class GreeterFileDescriptorSupplier
      extends GreeterBaseDescriptorSupplier {
    GreeterFileDescriptorSupplier() {}
  }

  private static final class GreeterMethodDescriptorSupplier
      extends GreeterBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    GreeterMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (GreeterGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GreeterFileDescriptorSupplier())
              .addMethod(getSayHelloMethod())
              .addMethod(getSayManyHellosMethod())
              .addMethod(getSayAuthHelloMethod())
              .addMethod(getSayAuthOnlyHelloMethod())
              .addMethod(getHelloPersonValidResponseMethod())
              .addMethod(getHelloPersonInvalidResponseMethod())
              .build();
        }
      }
    }
    return result;
  }
}
