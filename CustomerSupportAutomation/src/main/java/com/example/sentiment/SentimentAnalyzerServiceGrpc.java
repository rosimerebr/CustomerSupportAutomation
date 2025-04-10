package com.example.sentiment;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.52.1)",
    comments = "Source: sentiment_analyzer.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SentimentAnalyzerServiceGrpc {

  private SentimentAnalyzerServiceGrpc() {}

  public static final String SERVICE_NAME = "sentiment.SentimentAnalyzerService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.sentiment.SentimentAnalyzerProto.TextRequest,
      com.example.sentiment.SentimentAnalyzerProto.SentimentResponse> getAnalyzeTextMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AnalyzeText",
      requestType = com.example.sentiment.SentimentAnalyzerProto.TextRequest.class,
      responseType = com.example.sentiment.SentimentAnalyzerProto.SentimentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.sentiment.SentimentAnalyzerProto.TextRequest,
      com.example.sentiment.SentimentAnalyzerProto.SentimentResponse> getAnalyzeTextMethod() {
    io.grpc.MethodDescriptor<com.example.sentiment.SentimentAnalyzerProto.TextRequest, com.example.sentiment.SentimentAnalyzerProto.SentimentResponse> getAnalyzeTextMethod;
    if ((getAnalyzeTextMethod = SentimentAnalyzerServiceGrpc.getAnalyzeTextMethod) == null) {
      synchronized (SentimentAnalyzerServiceGrpc.class) {
        if ((getAnalyzeTextMethod = SentimentAnalyzerServiceGrpc.getAnalyzeTextMethod) == null) {
          SentimentAnalyzerServiceGrpc.getAnalyzeTextMethod = getAnalyzeTextMethod =
              io.grpc.MethodDescriptor.<com.example.sentiment.SentimentAnalyzerProto.TextRequest, com.example.sentiment.SentimentAnalyzerProto.SentimentResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AnalyzeText"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.sentiment.SentimentAnalyzerProto.TextRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.sentiment.SentimentAnalyzerProto.SentimentResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SentimentAnalyzerServiceMethodDescriptorSupplier("AnalyzeText"))
              .build();
        }
      }
    }
    return getAnalyzeTextMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.sentiment.SentimentAnalyzerProto.TextRequest,
      com.example.sentiment.SentimentAnalyzerProto.SentimentResponse> getStreamLiveSentimentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamLiveSentiment",
      requestType = com.example.sentiment.SentimentAnalyzerProto.TextRequest.class,
      responseType = com.example.sentiment.SentimentAnalyzerProto.SentimentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.example.sentiment.SentimentAnalyzerProto.TextRequest,
      com.example.sentiment.SentimentAnalyzerProto.SentimentResponse> getStreamLiveSentimentMethod() {
    io.grpc.MethodDescriptor<com.example.sentiment.SentimentAnalyzerProto.TextRequest, com.example.sentiment.SentimentAnalyzerProto.SentimentResponse> getStreamLiveSentimentMethod;
    if ((getStreamLiveSentimentMethod = SentimentAnalyzerServiceGrpc.getStreamLiveSentimentMethod) == null) {
      synchronized (SentimentAnalyzerServiceGrpc.class) {
        if ((getStreamLiveSentimentMethod = SentimentAnalyzerServiceGrpc.getStreamLiveSentimentMethod) == null) {
          SentimentAnalyzerServiceGrpc.getStreamLiveSentimentMethod = getStreamLiveSentimentMethod =
              io.grpc.MethodDescriptor.<com.example.sentiment.SentimentAnalyzerProto.TextRequest, com.example.sentiment.SentimentAnalyzerProto.SentimentResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StreamLiveSentiment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.sentiment.SentimentAnalyzerProto.TextRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.sentiment.SentimentAnalyzerProto.SentimentResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SentimentAnalyzerServiceMethodDescriptorSupplier("StreamLiveSentiment"))
              .build();
        }
      }
    }
    return getStreamLiveSentimentMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SentimentAnalyzerServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SentimentAnalyzerServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SentimentAnalyzerServiceStub>() {
        @java.lang.Override
        public SentimentAnalyzerServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SentimentAnalyzerServiceStub(channel, callOptions);
        }
      };
    return SentimentAnalyzerServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SentimentAnalyzerServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SentimentAnalyzerServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SentimentAnalyzerServiceBlockingStub>() {
        @java.lang.Override
        public SentimentAnalyzerServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SentimentAnalyzerServiceBlockingStub(channel, callOptions);
        }
      };
    return SentimentAnalyzerServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SentimentAnalyzerServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SentimentAnalyzerServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SentimentAnalyzerServiceFutureStub>() {
        @java.lang.Override
        public SentimentAnalyzerServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SentimentAnalyzerServiceFutureStub(channel, callOptions);
        }
      };
    return SentimentAnalyzerServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class SentimentAnalyzerServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void analyzeText(com.example.sentiment.SentimentAnalyzerProto.TextRequest request,
        io.grpc.stub.StreamObserver<com.example.sentiment.SentimentAnalyzerProto.SentimentResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAnalyzeTextMethod(), responseObserver);
    }

    /**
     */
    public void streamLiveSentiment(com.example.sentiment.SentimentAnalyzerProto.TextRequest request,
        io.grpc.stub.StreamObserver<com.example.sentiment.SentimentAnalyzerProto.SentimentResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStreamLiveSentimentMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAnalyzeTextMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.example.sentiment.SentimentAnalyzerProto.TextRequest,
                com.example.sentiment.SentimentAnalyzerProto.SentimentResponse>(
                  this, METHODID_ANALYZE_TEXT)))
          .addMethod(
            getStreamLiveSentimentMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                com.example.sentiment.SentimentAnalyzerProto.TextRequest,
                com.example.sentiment.SentimentAnalyzerProto.SentimentResponse>(
                  this, METHODID_STREAM_LIVE_SENTIMENT)))
          .build();
    }
  }

  /**
   */
  public static final class SentimentAnalyzerServiceStub extends io.grpc.stub.AbstractAsyncStub<SentimentAnalyzerServiceStub> {
    private SentimentAnalyzerServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SentimentAnalyzerServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SentimentAnalyzerServiceStub(channel, callOptions);
    }

    /**
     */
    public void analyzeText(com.example.sentiment.SentimentAnalyzerProto.TextRequest request,
        io.grpc.stub.StreamObserver<com.example.sentiment.SentimentAnalyzerProto.SentimentResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAnalyzeTextMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void streamLiveSentiment(com.example.sentiment.SentimentAnalyzerProto.TextRequest request,
        io.grpc.stub.StreamObserver<com.example.sentiment.SentimentAnalyzerProto.SentimentResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getStreamLiveSentimentMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class SentimentAnalyzerServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<SentimentAnalyzerServiceBlockingStub> {
    private SentimentAnalyzerServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SentimentAnalyzerServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SentimentAnalyzerServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.sentiment.SentimentAnalyzerProto.SentimentResponse analyzeText(com.example.sentiment.SentimentAnalyzerProto.TextRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAnalyzeTextMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.example.sentiment.SentimentAnalyzerProto.SentimentResponse> streamLiveSentiment(
        com.example.sentiment.SentimentAnalyzerProto.TextRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getStreamLiveSentimentMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class SentimentAnalyzerServiceFutureStub extends io.grpc.stub.AbstractFutureStub<SentimentAnalyzerServiceFutureStub> {
    private SentimentAnalyzerServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SentimentAnalyzerServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SentimentAnalyzerServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.sentiment.SentimentAnalyzerProto.SentimentResponse> analyzeText(
        com.example.sentiment.SentimentAnalyzerProto.TextRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAnalyzeTextMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ANALYZE_TEXT = 0;
  private static final int METHODID_STREAM_LIVE_SENTIMENT = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SentimentAnalyzerServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SentimentAnalyzerServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ANALYZE_TEXT:
          serviceImpl.analyzeText((com.example.sentiment.SentimentAnalyzerProto.TextRequest) request,
              (io.grpc.stub.StreamObserver<com.example.sentiment.SentimentAnalyzerProto.SentimentResponse>) responseObserver);
          break;
        case METHODID_STREAM_LIVE_SENTIMENT:
          serviceImpl.streamLiveSentiment((com.example.sentiment.SentimentAnalyzerProto.TextRequest) request,
              (io.grpc.stub.StreamObserver<com.example.sentiment.SentimentAnalyzerProto.SentimentResponse>) responseObserver);
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

  private static abstract class SentimentAnalyzerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SentimentAnalyzerServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.sentiment.SentimentAnalyzerProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SentimentAnalyzerService");
    }
  }

  private static final class SentimentAnalyzerServiceFileDescriptorSupplier
      extends SentimentAnalyzerServiceBaseDescriptorSupplier {
    SentimentAnalyzerServiceFileDescriptorSupplier() {}
  }

  private static final class SentimentAnalyzerServiceMethodDescriptorSupplier
      extends SentimentAnalyzerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SentimentAnalyzerServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (SentimentAnalyzerServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SentimentAnalyzerServiceFileDescriptorSupplier())
              .addMethod(getAnalyzeTextMethod())
              .addMethod(getStreamLiveSentimentMethod())
              .build();
        }
      }
    }
    return result;
  }
}
