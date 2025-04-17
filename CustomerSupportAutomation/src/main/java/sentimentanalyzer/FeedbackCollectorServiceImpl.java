// FeedbackCollectorServiceImpl.java
package sentimentanalyzer;

import com.google.protobuf.BoolValue;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implements the gRPC FeedbackCollectorService to receive feedback stream and reset summary.
 * Thread-safe implementation with improved sentiment analysis.
 */
public class FeedbackCollectorServiceImpl extends FeedbackCollectorServiceGrpc.FeedbackCollectorServiceImplBase {
    private static final Logger logger = LoggerFactory.getLogger(FeedbackCollectorServiceImpl.class);

    // Thread-safe collections for concurrent access
    private final ConcurrentLinkedQueue<Float> scores = new ConcurrentLinkedQueue<>();
    private final AtomicInteger positiveCount = new AtomicInteger(0);
    private final AtomicInteger negativeCount = new AtomicInteger(0);

    // Sentiment analysis thresholds
    private static final float POSITIVE_THRESHOLD = 0.7f;
    private static final float NEGATIVE_THRESHOLD = 0.3f;
    private static final float NEUTRAL_SCORE = 0.5f;

    /**
     * Handles the feedback stream from the client and returns the computed summary.
     */
    @Override
    public StreamObserver<FeedbackRequest> submitFeedbacks(StreamObserver<FeedbackSummary> responseObserver) {
        return new StreamObserver<FeedbackRequest>() {
            @Override
            public void onNext(FeedbackRequest value) {
                try {
                    if (value == null || value.getFeedbackText().trim().isEmpty()) {
                        logger.warn("Received empty feedback request");
                        return;
                    }

                    float score = analyzeSentiment(value.getFeedbackText());
                    scores.add(score);

                    if (score >= POSITIVE_THRESHOLD) {
                        positiveCount.incrementAndGet();
                    } else if (score <= NEGATIVE_THRESHOLD) {
                        negativeCount.incrementAndGet();
                    }

                    logger.debug("Processed feedback with score: {}", score);
                } catch (Exception e) {
                    logger.error("Error processing feedback: " + value, e);
                }
            }

            @Override
            public void onError(Throwable t) {
                logger.error("Error in feedback stream", t);
                responseObserver.onError(t);
            }

            @Override
            public void onCompleted() {
                try {
                    double average = scores.stream()
                            .mapToDouble(f -> f)
                            .average()
                            .orElse(0.0);

                    FeedbackSummary summary = FeedbackSummary.newBuilder()
                            .setTotalFeedbacks(scores.size())
                            .setAverageSentimentScore((float) average)
                            .setNegativeCount(negativeCount.get())
                            .setPositiveCount(positiveCount.get())
                            .build();

                    responseObserver.onNext(summary);
                    responseObserver.onCompleted();

                    logger.info("Feedback summary generated. Total: {}, Avg: {}. Positive: {}, Negative: {}",
                            scores.size(), average, positiveCount.get(), negativeCount.get());
                } catch (Exception e) {
                    logger.error("Error generating summary", e);
                    responseObserver.onError(e);
                }
            }
        };
    }

    /**
     * Resets internal state of feedback statistics.
     */
    @Override
    public void resetFeedbacks(Empty request, StreamObserver<BoolValue> responseObserver) {
        try {
            scores.clear();
            positiveCount.set(0);
            negativeCount.set(0);

            responseObserver.onNext(BoolValue.of(true));
            responseObserver.onCompleted();

            logger.info("Feedback statistics reset successfully");
        } catch (Exception e) {
            logger.error("Error resetting feedbacks", e);
            responseObserver.onNext(BoolValue.of(false));
            responseObserver.onError(e);
        }
    }

    /**
     * Improved sentiment analysis implementation.
     * @param text Feedback text
     * @return sentiment score (0.0 to 1.0)
     */
    private float analyzeSentiment(String text) {
        if (text == null || text.trim().isEmpty()) {
            return NEUTRAL_SCORE;
        }

        String lower = text.toLowerCase();
        int positiveWords = countMatches(lower, "love", "great", "excellent", "happy", "good");
        int negativeWords = countMatches(lower, "hate", "terrible", "awful", "bad", "worst");

        // Simple weighted calculation
        float score = NEUTRAL_SCORE;
        if (positiveWords > 0 || negativeWords > 0) {
            float delta = (positiveWords * 0.1f) - (negativeWords * 0.1f);
            score = Math.max(0.0f, Math.min(1.0f, NEUTRAL_SCORE + delta));
        }

        return score;
    }

    /**
     * Counts occurrences of target words in text
     */
    private int countMatches(String text, String... words) {
        int count = 0;
        for (String word : words) {
            int index = text.indexOf(word);
            while (index >= 0) {
                count++;
                index = text.indexOf(word, index + 1);
            }
        }
        return count;
    }
}