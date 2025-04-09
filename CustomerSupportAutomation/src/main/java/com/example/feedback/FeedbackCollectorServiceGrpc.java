package com.example.feedback;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.52.1)",
    comments = "Source: feedback_collector.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class FeedbackCollectorServiceGrpc {

  private FeedbackCollectorServiceGrpc() {}

  public static final String SERVICE_NAME = "feedback.FeedbackCollectorService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.feedback.FeedbackCollectorProto.FeedbackRequest,
      com.example.feedback.FeedbackCollectorProto.FeedbackSummary> getSubmitFeedbacksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SubmitFeedbacks",
      requestType = com.example.feedback.FeedbackCollectorProto.FeedbackRequest.class,
      responseType = com.example.feedback.FeedbackCollectorProto.FeedbackSummary.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.example.feedback.FeedbackCollectorProto.FeedbackRequest,
      com.example.feedback.FeedbackCollectorProto.FeedbackSummary> getSubmitFeedbacksMethod() {
    io.grpc.MethodDescriptor<com.example.feedback.FeedbackCollectorProto.FeedbackRequest, com.example.feedback.FeedbackCollectorProto.FeedbackSummary> getSubmitFeedbacksMethod;
    if ((getSubmitFeedbacksMethod = FeedbackCollectorServiceGrpc.getSubmitFeedbacksMethod) == null) {
      synchronized (FeedbackCollectorServiceGrpc.class) {
        if ((getSubmitFeedbacksMethod = FeedbackCollectorServiceGrpc.getSubmitFeedbacksMethod) == null) {
          FeedbackCollectorServiceGrpc.getSubmitFeedbacksMethod = getSubmitFeedbacksMethod =
              io.grpc.MethodDescriptor.<com.example.feedback.FeedbackCollectorProto.FeedbackRequest, com.example.feedback.FeedbackCollectorProto.FeedbackSummary>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SubmitFeedbacks"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.feedback.FeedbackCollectorProto.FeedbackRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.feedback.FeedbackCollectorProto.FeedbackSummary.getDefaultInstance()))
              .setSchemaDescriptor(new FeedbackCollectorServiceMethodDescriptorSupplier("SubmitFeedbacks"))
              .build();
        }
      }
    }
    return getSubmitFeedbacksMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static FeedbackCollectorServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FeedbackCollectorServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FeedbackCollectorServiceStub>() {
        @java.lang.Override
        public FeedbackCollectorServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FeedbackCollectorServiceStub(channel, callOptions);
        }
      };
    return FeedbackCollectorServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FeedbackCollectorServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FeedbackCollectorServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FeedbackCollectorServiceBlockingStub>() {
        @java.lang.Override
        public FeedbackCollectorServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FeedbackCollectorServiceBlockingStub(channel, callOptions);
        }
      };
    return FeedbackCollectorServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static FeedbackCollectorServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FeedbackCollectorServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FeedbackCollectorServiceFutureStub>() {
        @java.lang.Override
        public FeedbackCollectorServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FeedbackCollectorServiceFutureStub(channel, callOptions);
        }
      };
    return FeedbackCollectorServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class FeedbackCollectorServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<com.example.feedback.FeedbackCollectorProto.FeedbackRequest> submitFeedbacks(
        io.grpc.stub.StreamObserver<com.example.feedback.FeedbackCollectorProto.FeedbackSummary> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getSubmitFeedbacksMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSubmitFeedbacksMethod(),
            io.grpc.stub.ServerCalls.asyncClientStreamingCall(
              new MethodHandlers<
                com.example.feedback.FeedbackCollectorProto.FeedbackRequest,
                com.example.feedback.FeedbackCollectorProto.FeedbackSummary>(
                  this, METHODID_SUBMIT_FEEDBACKS)))
          .build();
    }
  }

  /**
   */
  public static final class FeedbackCollectorServiceStub extends io.grpc.stub.AbstractAsyncStub<FeedbackCollectorServiceStub> {
    private FeedbackCollectorServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FeedbackCollectorServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FeedbackCollectorServiceStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.example.feedback.FeedbackCollectorProto.FeedbackRequest> submitFeedbacks(
        io.grpc.stub.StreamObserver<com.example.feedback.FeedbackCollectorProto.FeedbackSummary> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getSubmitFeedbacksMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class FeedbackCollectorServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<FeedbackCollectorServiceBlockingStub> {
    private FeedbackCollectorServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FeedbackCollectorServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FeedbackCollectorServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class FeedbackCollectorServiceFutureStub extends io.grpc.stub.AbstractFutureStub<FeedbackCollectorServiceFutureStub> {
    private FeedbackCollectorServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FeedbackCollectorServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FeedbackCollectorServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_SUBMIT_FEEDBACKS = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final FeedbackCollectorServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(FeedbackCollectorServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SUBMIT_FEEDBACKS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.submitFeedbacks(
              (io.grpc.stub.StreamObserver<com.example.feedback.FeedbackCollectorProto.FeedbackSummary>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class FeedbackCollectorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FeedbackCollectorServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.feedback.FeedbackCollectorProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("FeedbackCollectorService");
    }
  }

  private static final class FeedbackCollectorServiceFileDescriptorSupplier
      extends FeedbackCollectorServiceBaseDescriptorSupplier {
    FeedbackCollectorServiceFileDescriptorSupplier() {}
  }

  private static final class FeedbackCollectorServiceMethodDescriptorSupplier
      extends FeedbackCollectorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    FeedbackCollectorServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (FeedbackCollectorServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new FeedbackCollectorServiceFileDescriptorSupplier())
              .addMethod(getSubmitFeedbacksMethod())
              .build();
        }
      }
    }
    return result;
  }
}
