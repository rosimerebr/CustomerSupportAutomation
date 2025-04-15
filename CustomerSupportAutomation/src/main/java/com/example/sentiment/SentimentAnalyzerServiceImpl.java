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
        // Sentiment analysis logic here (simple example)
        String sentiment = "neutral";  // Initially neutral sentiment
        if (request.getText().contains("good")) {
            sentiment = "positive";  // Detect if the text contains 'good'
        } else if (request.getText().contains("bad")) {
            sentiment = "negative";  // Detect if the text contains 'bad'
        }

        float score = 0.5f;  // Set default score value

        // Adjust score based on detected sentiment
        if ("positive".equals(sentiment)) {
            score = 0.95f;
        } else if ("negative".equals(sentiment)) {
            score = 0.2f;
        }

        // Create the response with the identified sentiment
        SentimentResponse response = SentimentResponse.newBuilder()
                .setSentiment(sentiment)
                .setScore(score)
                .setTicketId("ticket123")  // Dummy ticket ID
                .build();

        responseObserver.onNext(response);  // Send the response to the client
        responseObserver.onCompleted();  // Mark the end of the response
    }

    @Override
    public void streamLiveSentiment(TextRequest request, StreamObserver<SentimentResponse> responseObserver) {
        // Simulating the streaming of sentiment analysis updates in real-time
        String[] sentiments = {"positive", "negative", "neutral"};
        float[] scores = {0.95f, 0.2f, 0.5f};  // Example fictitious scores for simulation

        // Loop through the predefined sentiments and send them in a real-time streaming fashion
        for (int i = 0; i < sentiments.length; i++) {
            SentimentResponse response = SentimentResponse.newBuilder()
                    .setSentiment(sentiments[i])
                    .setScore(scores[i])
                    .setTicketId("ticket123")  // Dummy ticket ID
                    .build();

            responseObserver.onNext(response);  // Send the update to the client

            // Simulate a delay between updates to mimic real-time streaming behavior
            try {
                Thread.sleep(1000);  // 1-second delay between updates
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();  // Handle thread interruption
            }
        }

        responseObserver.onCompleted();  // Mark the end of the stream
    }
}
