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
    comments = "Source: alert_service.proto")
public final class AlertServiceGrpc {

  private AlertServiceGrpc() {}

  public static final String SERVICE_NAME = "sentimentanalyzer.AlertService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<sentimentanalyzer.AlertServiceProto.AlertRequest,
      sentimentanalyzer.AlertServiceProto.AlertResponse> getAlertChannelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AlertChannel",
      requestType = sentimentanalyzer.AlertServiceProto.AlertRequest.class,
      responseType = sentimentanalyzer.AlertServiceProto.AlertResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<sentimentanalyzer.AlertServiceProto.AlertRequest,
      sentimentanalyzer.AlertServiceProto.AlertResponse> getAlertChannelMethod() {
    io.grpc.MethodDescriptor<sentimentanalyzer.AlertServiceProto.AlertRequest, sentimentanalyzer.AlertServiceProto.AlertResponse> getAlertChannelMethod;
    if ((getAlertChannelMethod = AlertServiceGrpc.getAlertChannelMethod) == null) {
      synchronized (AlertServiceGrpc.class) {
        if ((getAlertChannelMethod = AlertServiceGrpc.getAlertChannelMethod) == null) {
          AlertServiceGrpc.getAlertChannelMethod = getAlertChannelMethod = 
              io.grpc.MethodDescriptor.<sentimentanalyzer.AlertServiceProto.AlertRequest, sentimentanalyzer.AlertServiceProto.AlertResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "sentimentanalyzer.AlertService", "AlertChannel"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sentimentanalyzer.AlertServiceProto.AlertRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sentimentanalyzer.AlertServiceProto.AlertResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new AlertServiceMethodDescriptorSupplier("AlertChannel"))
                  .build();
          }
        }
     }
     return getAlertChannelMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AlertServiceStub newStub(io.grpc.Channel channel) {
    return new AlertServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AlertServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new AlertServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AlertServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new AlertServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class AlertServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<sentimentanalyzer.AlertServiceProto.AlertRequest> alertChannel(
        io.grpc.stub.StreamObserver<sentimentanalyzer.AlertServiceProto.AlertResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getAlertChannelMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAlertChannelMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                sentimentanalyzer.AlertServiceProto.AlertRequest,
                sentimentanalyzer.AlertServiceProto.AlertResponse>(
                  this, METHODID_ALERT_CHANNEL)))
          .build();
    }
  }

  /**
   */
  public static final class AlertServiceStub extends io.grpc.stub.AbstractStub<AlertServiceStub> {
    private AlertServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AlertServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AlertServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AlertServiceStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<sentimentanalyzer.AlertServiceProto.AlertRequest> alertChannel(
        io.grpc.stub.StreamObserver<sentimentanalyzer.AlertServiceProto.AlertResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getAlertChannelMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class AlertServiceBlockingStub extends io.grpc.stub.AbstractStub<AlertServiceBlockingStub> {
    private AlertServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AlertServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AlertServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AlertServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class AlertServiceFutureStub extends io.grpc.stub.AbstractStub<AlertServiceFutureStub> {
    private AlertServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AlertServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AlertServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AlertServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_ALERT_CHANNEL = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AlertServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AlertServiceImplBase serviceImpl, int methodId) {
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
        case METHODID_ALERT_CHANNEL:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.alertChannel(
              (io.grpc.stub.StreamObserver<sentimentanalyzer.AlertServiceProto.AlertResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class AlertServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AlertServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return sentimentanalyzer.AlertServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AlertService");
    }
  }

  private static final class AlertServiceFileDescriptorSupplier
      extends AlertServiceBaseDescriptorSupplier {
    AlertServiceFileDescriptorSupplier() {}
  }

  private static final class AlertServiceMethodDescriptorSupplier
      extends AlertServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AlertServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (AlertServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AlertServiceFileDescriptorSupplier())
              .addMethod(getAlertChannelMethod())
              .build();
        }
      }
    }
    return result;
  }
}
