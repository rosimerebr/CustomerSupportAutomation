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
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: sentiment_analyzer.proto")
public final class SentimentAnalyzerServiceGrpc {

  private SentimentAnalyzerServiceGrpc() {}

  public static final String SERVICE_NAME = "sentimentanalyzer.SentimentAnalyzerService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<sentimentanalyzer.TextRequest,
      sentimentanalyzer.SentimentResponse> getAnalyzeTextMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AnalyzeText",
      requestType = sentimentanalyzer.TextRequest.class,
      responseType = sentimentanalyzer.SentimentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<sentimentanalyzer.TextRequest,
      sentimentanalyzer.SentimentResponse> getAnalyzeTextMethod() {
    io.grpc.MethodDescriptor<sentimentanalyzer.TextRequest, sentimentanalyzer.SentimentResponse> getAnalyzeTextMethod;
    if ((getAnalyzeTextMethod = SentimentAnalyzerServiceGrpc.getAnalyzeTextMethod) == null) {
      synchronized (SentimentAnalyzerServiceGrpc.class) {
        if ((getAnalyzeTextMethod = SentimentAnalyzerServiceGrpc.getAnalyzeTextMethod) == null) {
          SentimentAnalyzerServiceGrpc.getAnalyzeTextMethod = getAnalyzeTextMethod = 
              io.grpc.MethodDescriptor.<sentimentanalyzer.TextRequest, sentimentanalyzer.SentimentResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "sentimentanalyzer.SentimentAnalyzerService", "AnalyzeText"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sentimentanalyzer.TextRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sentimentanalyzer.SentimentResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SentimentAnalyzerServiceMethodDescriptorSupplier("AnalyzeText"))
                  .build();
          }
        }
     }
     return getAnalyzeTextMethod;
  }

  private static volatile io.grpc.MethodDescriptor<sentimentanalyzer.TextRequest,
      sentimentanalyzer.SentimentResponse> getStreamLiveSentimentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamLiveSentiment",
      requestType = sentimentanalyzer.TextRequest.class,
      responseType = sentimentanalyzer.SentimentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<sentimentanalyzer.TextRequest,
      sentimentanalyzer.SentimentResponse> getStreamLiveSentimentMethod() {
    io.grpc.MethodDescriptor<sentimentanalyzer.TextRequest, sentimentanalyzer.SentimentResponse> getStreamLiveSentimentMethod;
    if ((getStreamLiveSentimentMethod = SentimentAnalyzerServiceGrpc.getStreamLiveSentimentMethod) == null) {
      synchronized (SentimentAnalyzerServiceGrpc.class) {
        if ((getStreamLiveSentimentMethod = SentimentAnalyzerServiceGrpc.getStreamLiveSentimentMethod) == null) {
          SentimentAnalyzerServiceGrpc.getStreamLiveSentimentMethod = getStreamLiveSentimentMethod = 
              io.grpc.MethodDescriptor.<sentimentanalyzer.TextRequest, sentimentanalyzer.SentimentResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "sentimentanalyzer.SentimentAnalyzerService", "StreamLiveSentiment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sentimentanalyzer.TextRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sentimentanalyzer.SentimentResponse.getDefaultInstance()))
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
    return new SentimentAnalyzerServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SentimentAnalyzerServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new SentimentAnalyzerServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SentimentAnalyzerServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new SentimentAnalyzerServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class SentimentAnalyzerServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void analyzeText(sentimentanalyzer.TextRequest request,
        io.grpc.stub.StreamObserver<sentimentanalyzer.SentimentResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getAnalyzeTextMethod(), responseObserver);
    }

    /**
     */
    public void streamLiveSentiment(sentimentanalyzer.TextRequest request,
        io.grpc.stub.StreamObserver<sentimentanalyzer.SentimentResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getStreamLiveSentimentMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAnalyzeTextMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                sentimentanalyzer.TextRequest,
                sentimentanalyzer.SentimentResponse>(
                  this, METHODID_ANALYZE_TEXT)))
          .addMethod(
            getStreamLiveSentimentMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                sentimentanalyzer.TextRequest,
                sentimentanalyzer.SentimentResponse>(
                  this, METHODID_STREAM_LIVE_SENTIMENT)))
          .build();
    }
  }

  /**
   */
  public static final class SentimentAnalyzerServiceStub extends io.grpc.stub.AbstractStub<SentimentAnalyzerServiceStub> {
    private SentimentAnalyzerServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SentimentAnalyzerServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SentimentAnalyzerServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SentimentAnalyzerServiceStub(channel, callOptions);
    }

    /**
     */
    public void analyzeText(sentimentanalyzer.TextRequest request,
        io.grpc.stub.StreamObserver<sentimentanalyzer.SentimentResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAnalyzeTextMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void streamLiveSentiment(sentimentanalyzer.TextRequest request,
        io.grpc.stub.StreamObserver<sentimentanalyzer.SentimentResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getStreamLiveSentimentMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class SentimentAnalyzerServiceBlockingStub extends io.grpc.stub.AbstractStub<SentimentAnalyzerServiceBlockingStub> {
    private SentimentAnalyzerServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SentimentAnalyzerServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SentimentAnalyzerServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SentimentAnalyzerServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public sentimentanalyzer.SentimentResponse analyzeText(sentimentanalyzer.TextRequest request) {
      return blockingUnaryCall(
          getChannel(), getAnalyzeTextMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<sentimentanalyzer.SentimentResponse> streamLiveSentiment(
        sentimentanalyzer.TextRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getStreamLiveSentimentMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class SentimentAnalyzerServiceFutureStub extends io.grpc.stub.AbstractStub<SentimentAnalyzerServiceFutureStub> {
    private SentimentAnalyzerServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SentimentAnalyzerServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SentimentAnalyzerServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SentimentAnalyzerServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<sentimentanalyzer.SentimentResponse> analyzeText(
        sentimentanalyzer.TextRequest request) {
      return futureUnaryCall(
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
          serviceImpl.analyzeText((sentimentanalyzer.TextRequest) request,
              (io.grpc.stub.StreamObserver<sentimentanalyzer.SentimentResponse>) responseObserver);
          break;
        case METHODID_STREAM_LIVE_SENTIMENT:
          serviceImpl.streamLiveSentiment((sentimentanalyzer.TextRequest) request,
              (io.grpc.stub.StreamObserver<sentimentanalyzer.SentimentResponse>) responseObserver);
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
      return sentimentanalyzer.SentimentAnalyzerProto.getDescriptor();
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
