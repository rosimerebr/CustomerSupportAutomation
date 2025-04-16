package sentimentanalyzer;

import io.grpc.*;
import java.io.IOException;


public class SentimentAnalyzerServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(8080)
                .addService(new SentimentAnalyzerServiceImpl())
                .addService(new FeedbackCollectorServiceImpl())
                .build();

        server.start();
        System.out.println("Server running on port 8080");
        server.awaitTermination();
    }
}

