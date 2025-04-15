/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.example.alert;

import io.grpc.Status;
import io.grpc.stub.StreamObserver;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * Classe gerada pelo compilador do gRPC.
 * Aqui definimos os serviços e a lógica de erro.
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
   * Cria um novo stub assíncrono que suporta todos os tipos de chamada para o serviço.
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
   * Cria um novo stub de bloqueio que suporta chamadas unárias e streaming.
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
   * Cria um novo stub baseado em ListenableFuture que suporta chamadas unárias.
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
   * Implementação do serviço AlertService.
   * Define o método alertChannel com tratamento de erros.
   */
  public static abstract class AlertServiceImplBase implements io.grpc.BindableService {

    /**
     * Implementação do método alertChannel com o tratamento de erros.
     */
    public io.grpc.stub.StreamObserver<com.example.alert.AlertServiceProto.AlertRequest> alertChannel(
        io.grpc.stub.StreamObserver<com.example.alert.AlertServiceProto.AlertResponse> responseObserver) {

      return new io.grpc.stub.StreamObserver<com.example.alert.AlertServiceProto.AlertRequest>() {

          @Override
          public void onNext(com.example.alert.AlertServiceProto.AlertRequest request) {
              try {
                  // Validar a mensagem de alerta
                  if (request.getAlertMessage() == null || request.getAlertMessage().isEmpty()) {
                      throw new IllegalArgumentException("Alert message cannot be empty");
                  }

                  // Processar o alerta e enviar a resposta
                  com.example.alert.AlertServiceProto.AlertResponse response = 
                      com.example.alert.AlertServiceProto.AlertResponse.newBuilder()
                      .setAlertMessage("Alert processed successfully")
                      .build();
                  responseObserver.onNext(response);  // Envia a resposta para o cliente

              } catch (IllegalArgumentException e) {
                  // Envia erro 400 (Argumento inválido) se a mensagem de alerta for inválida
                  responseObserver.onError(Status.INVALID_ARGUMENT.withDescription("Invalid alert message: " + e.getMessage()).asRuntimeException());
              } catch (Exception e) {
                  // Envia erro 500 (Erro interno) para problemas internos
                  responseObserver.onError(Status.INTERNAL.withDescription("Internal error while processing alert: " + e.getMessage()).asRuntimeException());
              }
          }

          @Override
          public void onError(Throwable t) {
              // Envia erro 500 (Erro interno) caso haja falha na comunicação
              responseObserver.onError(Status.INTERNAL.withDescription("Error in alert communication: " + t.getMessage()).asRuntimeException());
          }

          @Override
          public void onCompleted() {
              // Marca o fluxo como concluído
              responseObserver.onCompleted();
          }
      };
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

    private static class AlertServiceStub {

        public AlertServiceStub() {
        }
    }
}
