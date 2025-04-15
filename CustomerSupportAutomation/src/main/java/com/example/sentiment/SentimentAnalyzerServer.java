/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sentiment;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;

public class SentimentAnalyzerServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        int port = 50051;
        Server server = ServerBuilder.forPort(port)
                .addService(new SentimentAnalyzerServiceImpl())
                .build();

        System.out.println("Starting Sentiment Analyzer Service on port " + port);
        server.start();
        server.awaitTermination();
    }
}
