/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sentiment;

import io.grpc.stub.StreamObserver;
import com.example.sentiment.SentimentAnalyzerProto.*;

public class SentimentAnalyzerServiceImpl extends SentimentAnalyzerServiceGrpc.SentimentAnalyzerServiceImplBase {

    @Override
    public void analyzeText(TextRequest request, StreamObserver<SentimentResponse> responseObserver) {
        // Lógica de análise de sentimentos aqui
        String sentiment = "positive";  // Exemplo simples
        float score = 0.95f;  // Pontuação fictícia de confiança

        SentimentResponse response = SentimentResponse.newBuilder()
                .setSentiment(sentiment)
                .setScore(score)
                .setTicketId("ticket123")  // ID fictício do ticket
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void streamLiveSentiment(TextRequest request, StreamObserver<SentimentResponse> responseObserver) {
        // Simulando o envio de atualizações de análise em tempo real
        String sentiment = "positive";
        float score = 0.8f;
        SentimentResponse response = SentimentResponse.newBuilder()
                .setSentiment(sentiment)
                .setScore(score)
                .setTicketId("ticket123")
                .build();
        responseObserver.onNext(response);

        // Continuar enviando atualizações
        response = SentimentResponse.newBuilder()
                .setSentiment("negative")
                .setScore(0.2f)
                .setTicketId("ticket123")
                .build();
        responseObserver.onNext(response);

        responseObserver.onCompleted();
    }
}
