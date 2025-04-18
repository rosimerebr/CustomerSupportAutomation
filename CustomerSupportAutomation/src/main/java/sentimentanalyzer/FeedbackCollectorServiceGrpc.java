package sentimentanalyzer;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * Service to collect feedback and generate/reset summary
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: feedback_collector.proto")
public final class FeedbackCollectorServiceGrpc {

  private FeedbackCollectorServiceGrpc() {}

  public static final String SERVICE_NAME = "sentimentanalyzer.FeedbackCollectorService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<sentimentanalyzer.FeedbackRequest,
      sentimentanalyzer.FeedbackSummary> getSubmitFeedbacksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SubmitFeedbacks",
      requestType = sentimentanalyzer.FeedbackRequest.class,
      responseType = sentimentanalyzer.FeedbackSummary.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<sentimentanalyzer.FeedbackRequest,
      sentimentanalyzer.FeedbackSummary> getSubmitFeedbacksMethod() {
    io.grpc.MethodDescriptor<sentimentanalyzer.FeedbackRequest, sentimentanalyzer.FeedbackSummary> getSubmitFeedbacksMethod;
    if ((getSubmitFeedbacksMethod = FeedbackCollectorServiceGrpc.getSubmitFeedbacksMethod) == null) {
      synchronized (FeedbackCollectorServiceGrpc.class) {
        if ((getSubmitFeedbacksMethod = FeedbackCollectorServiceGrpc.getSubmitFeedbacksMethod) == null) {
          FeedbackCollectorServiceGrpc.getSubmitFeedbacksMethod = getSubmitFeedbacksMethod = 
              io.grpc.MethodDescriptor.<sentimentanalyzer.FeedbackRequest, sentimentanalyzer.FeedbackSummary>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "sentimentanalyzer.FeedbackCollectorService", "SubmitFeedbacks"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sentimentanalyzer.FeedbackRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sentimentanalyzer.FeedbackSummary.getDefaultInstance()))
                  .setSchemaDescriptor(new FeedbackCollectorServiceMethodDescriptorSupplier("SubmitFeedbacks"))
                  .build();
          }
        }
     }
     return getSubmitFeedbacksMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.google.protobuf.BoolValue> getResetFeedbacksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ResetFeedbacks",
      requestType = com.google.protobuf.Empty.class,
      responseType = com.google.protobuf.BoolValue.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.google.protobuf.BoolValue> getResetFeedbacksMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, com.google.protobuf.BoolValue> getResetFeedbacksMethod;
    if ((getResetFeedbacksMethod = FeedbackCollectorServiceGrpc.getResetFeedbacksMethod) == null) {
      synchronized (FeedbackCollectorServiceGrpc.class) {
        if ((getResetFeedbacksMethod = FeedbackCollectorServiceGrpc.getResetFeedbacksMethod) == null) {
          FeedbackCollectorServiceGrpc.getResetFeedbacksMethod = getResetFeedbacksMethod = 
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, com.google.protobuf.BoolValue>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "sentimentanalyzer.FeedbackCollectorService", "ResetFeedbacks"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.BoolValue.getDefaultInstance()))
                  .setSchemaDescriptor(new FeedbackCollectorServiceMethodDescriptorSupplier("ResetFeedbacks"))
                  .build();
          }
        }
     }
     return getResetFeedbacksMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static FeedbackCollectorServiceStub newStub(io.grpc.Channel channel) {
    return new FeedbackCollectorServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FeedbackCollectorServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new FeedbackCollectorServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static FeedbackCollectorServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new FeedbackCollectorServiceFutureStub(channel);
  }

  /**
   * <pre>
   * ervice to collect feedback and generate/reset summary
   * </pre>
   */
  public static abstract class FeedbackCollectorServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Receives multiple feedbacks via streaming and returns a summary
     * </pre>
     */
    public io.grpc.stub.StreamObserver<sentimentanalyzer.FeedbackRequest> submitFeedbacks(
        io.grpc.stub.StreamObserver<sentimentanalyzer.FeedbackSummary> responseObserver) {
      return asyncUnimplementedStreamingCall(getSubmitFeedbacksMethod(), responseObserver);
    }

    /**
     * <pre>
     * Resets the summary stored on the server
     * </pre>
     */
    public void resetFeedbacks(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      asyncUnimplementedUnaryCall(getResetFeedbacksMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSubmitFeedbacksMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                sentimentanalyzer.FeedbackRequest,
                sentimentanalyzer.FeedbackSummary>(
                  this, METHODID_SUBMIT_FEEDBACKS)))
          .addMethod(
            getResetFeedbacksMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                com.google.protobuf.BoolValue>(
                  this, METHODID_RESET_FEEDBACKS)))
          .build();
    }
  }

  /**
   * <pre>
   * Service to collect feedback and generate/reset summary
   * </pre>
   */
  public static final class FeedbackCollectorServiceStub extends io.grpc.stub.AbstractStub<FeedbackCollectorServiceStub> {
    private FeedbackCollectorServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FeedbackCollectorServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FeedbackCollectorServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FeedbackCollectorServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Receives multiple feedbacks via streaming and returns a summary
     * </pre>
     */
    public io.grpc.stub.StreamObserver<sentimentanalyzer.FeedbackRequest> submitFeedbacks(
        io.grpc.stub.StreamObserver<sentimentanalyzer.FeedbackSummary> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getSubmitFeedbacksMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * Resets the summary stored on the server
     * </pre>
     */
    public void resetFeedbacks(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getResetFeedbacksMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Service to collect feedback and generate/reset summary
   * </pre>
   */
  public static final class FeedbackCollectorServiceBlockingStub extends io.grpc.stub.AbstractStub<FeedbackCollectorServiceBlockingStub> {
    private FeedbackCollectorServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FeedbackCollectorServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FeedbackCollectorServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FeedbackCollectorServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Resets the summary stored on the server
     * </pre>
     */
    public com.google.protobuf.BoolValue resetFeedbacks(com.google.protobuf.Empty request) {
      return blockingUnaryCall(
          getChannel(), getResetFeedbacksMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Service to collect feedback and generate/reset summary
   * </pre>
   */
  public static final class FeedbackCollectorServiceFutureStub extends io.grpc.stub.AbstractStub<FeedbackCollectorServiceFutureStub> {
    private FeedbackCollectorServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FeedbackCollectorServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FeedbackCollectorServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FeedbackCollectorServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Resets the summary stored on the server
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.BoolValue> resetFeedbacks(
        com.google.protobuf.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getResetFeedbacksMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_RESET_FEEDBACKS = 0;
  private static final int METHODID_SUBMIT_FEEDBACKS = 1;

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
        case METHODID_RESET_FEEDBACKS:
          serviceImpl.resetFeedbacks((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue>) responseObserver);
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
        case METHODID_SUBMIT_FEEDBACKS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.submitFeedbacks(
              (io.grpc.stub.StreamObserver<sentimentanalyzer.FeedbackSummary>) responseObserver);
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
      return sentimentanalyzer.FeedbackCollectorProto.getDescriptor();
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
              .addMethod(getResetFeedbacksMethod())
              .build();
        }
      }
    }
    return result;
  }
}
