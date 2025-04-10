/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.feedback;

import io.grpc.stub.StreamObserver;
import com.example.feedback.FeedbackCollectorProto.*;

public class FeedbackCollectorServiceImpl extends FeedbackCollectorServiceGrpc.FeedbackCollectorServiceImplBase {

    @Override
    public StreamObserver<FeedbackRequest> submitFeedbacks(StreamObserver<FeedbackSummary> responseObserver) {
        // Usando variáveis imutáveis para as variáveis locais
        final int[] totalFeedbacks = {0};  // Usando array para simular variáveis mutáveis em uma classe final
        final int[] positiveCount = {0};
        final int[] negativeCount = {0};
        final float[] sentimentScore = {0.0f};

        // Processando os feedbacks do cliente
        return new StreamObserver<FeedbackRequest>() {

            @Override
            public void onNext(FeedbackRequest feedback) {
                // Lógica para processar cada feedback
                totalFeedbacks[0]++;
                // Exemplo de lógica para determinar se o feedback é positivo ou negativo
                if (feedback.getFeedbackText().contains("happy")) {
                    positiveCount[0]++;
                } else {
                    negativeCount[0]++;
                }
            }

            @Override
            public void onError(Throwable t) {
                // Se ocorrer algum erro no stream
                System.err.println("Erro no fluxo de feedbacks: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                // Após o término do stream, calcular o resultado final
                sentimentScore[0] = 0.75f; // Exemplo fictício de pontuação média

                // Criar o resumo dos feedbacks
                FeedbackSummary summary = FeedbackSummary.newBuilder()
                        .setTotalFeedbacks(totalFeedbacks[0])
                        .setNegativeCount(negativeCount[0])
                        .setPositiveCount(positiveCount[0])
                        .setAverageSentimentScore(sentimentScore[0])
                        .build();

                // Enviar o resumo para o cliente
                responseObserver.onNext(summary);
                responseObserver.onCompleted(); // Finaliza a resposta do servidor
            }
        };
    }
}
