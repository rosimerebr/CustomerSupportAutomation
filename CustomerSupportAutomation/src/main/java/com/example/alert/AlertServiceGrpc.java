package com.example.alert;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.52.1)",
    comments = "Source: alert_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AlertServiceGrpc {

  private AlertServiceGrpc() {}

  public static final String SERVICE_NAME = "alert.AlertService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.alert.AlertServiceProto.AlertRequest,
      com.example.alert.AlertServiceProto.AlertResponse> getAlertChannelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AlertChannel",
      requestType = com.example.alert.AlertServiceProto.AlertRequest.class,
      responseType = com.example.alert.AlertServiceProto.AlertResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.example.alert.AlertServiceProto.AlertRequest,
      com.example.alert.AlertServiceProto.AlertResponse> getAlertChannelMethod() {
    io.grpc.MethodDescriptor<com.example.alert.AlertServiceProto.AlertRequest, com.example.alert.AlertServiceProto.AlertResponse> getAlertChannelMethod;
    if ((getAlertChannelMethod = AlertServiceGrpc.getAlertChannelMethod) == null) {
      synchronized (AlertServiceGrpc.class) {
        if ((getAlertChannelMethod = AlertServiceGrpc.getAlertChannelMethod) == null) {
          AlertServiceGrpc.getAlertChannelMethod = getAlertChannelMethod =
              io.grpc.MethodDescriptor.<com.example.alert.AlertServiceProto.AlertRequest, com.example.alert.AlertServiceProto.AlertResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AlertChannel"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.alert.AlertServiceProto.AlertRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.alert.AlertServiceProto.AlertResponse.getDefaultInstance()))
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
    io.grpc.stub.AbstractStub.StubFactory<AlertServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AlertServiceStub>() {
        @java.lang.Override
        public AlertServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AlertServiceStub(channel, callOptions);
        }
      };
    return AlertServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AlertServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AlertServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AlertServiceBlockingStub>() {
        @java.lang.Override
        public AlertServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AlertServiceBlockingStub(channel, callOptions);
        }
      };
    return AlertServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AlertServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AlertServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AlertServiceFutureStub>() {
        @java.lang.Override
        public AlertServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AlertServiceFutureStub(channel, callOptions);
        }
      };
    return AlertServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class AlertServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<com.example.alert.AlertServiceProto.AlertRequest> alertChannel(
        io.grpc.stub.StreamObserver<com.example.alert.AlertServiceProto.AlertResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getAlertChannelMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAlertChannelMethod(),
            io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
              new MethodHandlers<
                com.example.alert.AlertServiceProto.AlertRequest,
                com.example.alert.AlertServiceProto.AlertResponse>(
                  this, METHODID_ALERT_CHANNEL)))
          .build();
    }
  }

  /**
   */
  public static final class AlertServiceStub extends io.grpc.stub.AbstractAsyncStub<AlertServiceStub> {
    private AlertServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AlertServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AlertServiceStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.example.alert.AlertServiceProto.AlertRequest> alertChannel(
        io.grpc.stub.StreamObserver<com.example.alert.AlertServiceProto.AlertResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getAlertChannelMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class AlertServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<AlertServiceBlockingStub> {
    private AlertServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AlertServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AlertServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class AlertServiceFutureStub extends io.grpc.stub.AbstractFutureStub<AlertServiceFutureStub> {
    private AlertServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AlertServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
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
              (io.grpc.stub.StreamObserver<com.example.alert.AlertServiceProto.AlertResponse>) responseObserver);
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
      return com.example.alert.AlertServiceProto.getDescriptor();
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
