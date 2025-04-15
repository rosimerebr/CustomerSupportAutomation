/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.feedback;

import io.grpc.stub.StreamObserver;
import com.example.feedback.FeedbackCollectorProto.*;
import io.grpc.Status;

public class FeedbackCollectorServiceImpl extends FeedbackCollectorServiceGrpc.FeedbackCollectorServiceImplBase {

    @Override
    public StreamObserver<FeedbackRequest> submitFeedbacks(StreamObserver<FeedbackSummary> responseObserver) {
        final int[] totalFeedbacks = {0};
        final int[] positiveCount = {0};
        final int[] negativeCount = {0};
        final float[] sentimentScore = {0.0f};

        return new StreamObserver<FeedbackRequest>() {

            @Override
            public void onNext(FeedbackRequest feedback) {
                try {
                    totalFeedbacks[0]++;
                    if (feedback.getFeedbackText().contains("happy")) {
                        positiveCount[0]++;
                    } else {
                        negativeCount[0]++;
                    }
                } catch (Exception e) {
                    responseObserver.onError(Status.INTERNAL.withDescription("Error processing feedback: " + e.getMessage()).asRuntimeException());
                }
            }

            @Override
            public void onError(Throwable t) {
                responseObserver.onError(Status.INTERNAL.withDescription("Error in feedback stream: " + t.getMessage()).asRuntimeException());
            }

            @Override
            public void onCompleted() {
                try {
                    sentimentScore[0] = 0.75f; // Fictional example of average score
                    FeedbackSummary summary = FeedbackSummary.newBuilder()
                            .setTotalFeedbacks(totalFeedbacks[0])
                            .setNegativeCount(negativeCount[0])
                            .setPositiveCount(positiveCount[0])
                            .setAverageSentimentScore(sentimentScore[0])
                            .build();

                    responseObserver.onNext(summary);
                    responseObserver.onCompleted();
                } catch (Exception e) {
                    responseObserver.onError(Status.INTERNAL.withDescription("Error generating feedback summary: " + e.getMessage()).asRuntimeException());
                }
            }
        };
    }
}
