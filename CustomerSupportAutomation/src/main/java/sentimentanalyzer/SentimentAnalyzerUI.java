package sentimentanalyzer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import io.grpc.*;
import sentimentanalyzer.FeedbackCollectorProto.*;
import sentimentanalyzer.SentimentAnalyzerProto.*;
import io.grpc.stub.*;

public class SentimentAnalyzerUI extends JFrame {
    // gRPC Channel and Stubs
    private final ManagedChannel channel;
    private final SentimentAnalyzerServiceGrpc.SentimentAnalyzerServiceStub sentimentAnalyzerStub;  // Async stub
    private final FeedbackCollectorServiceGrpc.FeedbackCollectorServiceStub feedbackCollectorStub;

    // UI Components
    private JTextArea feedbackTextArea, feedbackSummaryArea, textToAnalyzeArea, sentimentResultArea, liveSentimentArea;
    private JButton submitFeedbackButton, cleanFeedbackButton, analyzeSentimentButton, cleanSentimentButton, startLiveSentimentButton, cleanLiveSentimentButton;

    public SentimentAnalyzerUI() {
        // Initialize gRPC channel and stubs
        channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();
        sentimentAnalyzerStub = SentimentAnalyzerServiceGrpc.newStub(channel);
        feedbackCollectorStub = FeedbackCollectorServiceGrpc.newStub(channel);

        // Set up JFrame
        setTitle("Sentiment Analyzer & Feedback Collector");
        setSize(600, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Initialize UI sections
        createFeedbackSection();
        createSentimentSection();
        createLiveSentimentSection();

        setVisible(true);
    }

    // --- Feedback Section ---
    private void createFeedbackSection() {
        /*JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder("Feedback Collector"));

        feedbackTextArea = new JTextArea(5, 20);
        submitFeedbackButton = new JButton("Submit Feedback");
        feedbackSummaryArea = new JTextArea(5, 20);
        feedbackSummaryArea.setEditable(false);
        cleanFeedbackButton = new JButton("Clear");

        submitFeedbackButton.addActionListener(e -> submitFeedback());
        cleanFeedbackButton.addActionListener(e -> clearFields("feedback"));

        panel.add(new JLabel("Feedback Text:"));
        panel.add(new JScrollPane(feedbackTextArea));
        panel.add(submitFeedbackButton);
        panel.add(cleanFeedbackButton);
        panel.add(new JScrollPane(feedbackSummaryArea));

        add(panel, BorderLayout.NORTH);*/
    }

    private void submitFeedback() {
        /*StreamObserver<FeedbackRequest> requestObserver = feedbackCollectorStub.submitFeedbacks(
                new StreamObserver<FeedbackSummary>() {
                    @Override
                    public void onNext(FeedbackSummary summary) {
                        SwingUtilities.invokeLater(() -> {
                            feedbackSummaryArea.setText(
                                    "Total Feedbacks: " + summary.getTotalFeedbacks() + "\n" +
                                            "Positive: " + summary.getPositiveCount() + "\n" +
                                            "Negative: " + summary.getNegativeCount() + "\n" +
                                            "Avg. Score: " + summary.getAverageSentimentScore()
                            );
                        });
                    }

                    @Override
                    public void onError(Throwable t) {
                        SwingUtilities.invokeLater(() -> {
                            feedbackSummaryArea.setText("Error: " + t.getMessage());
                        });
                    }

                    @Override
                    public void onCompleted() {
                        // Optional: Log completion
                    }
                }
        );

        FeedbackRequest request = FeedbackRequest.newBuilder()
                .setFeedbackText(feedbackTextArea.getText())
                .build();
        requestObserver.onNext(request);
        requestObserver.onCompleted();*/
    }

    // --- Sentiment Analysis Section ---
    private void createSentimentSection() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder("Sentiment Analyzer"));

        textToAnalyzeArea = new JTextArea(5, 20);
        analyzeSentimentButton = new JButton("Analyze Sentiment");
        sentimentResultArea = new JTextArea(5, 20);
        sentimentResultArea.setEditable(false);
        cleanSentimentButton = new JButton("Clear");

        analyzeSentimentButton.addActionListener(e -> analyzeSentiment());
        cleanSentimentButton.addActionListener(e -> clearFields("sentiment"));

        panel.add(new JLabel("Text to Analyze:"));
        panel.add(new JScrollPane(textToAnalyzeArea));
        panel.add(analyzeSentimentButton);
        panel.add(cleanSentimentButton);
        panel.add(new JScrollPane(sentimentResultArea));

        add(panel, BorderLayout.CENTER);
    }

    private void analyzeSentiment() {
        String text = textToAnalyzeArea.getText();
        if (text.isEmpty()) {
            sentimentResultArea.setText("Please enter text to analyze!");
            return;
        }

        TextRequest request = TextRequest.newBuilder()
                .setText(text)
                .build();

        sentimentAnalyzerStub.analyzeText(request, new StreamObserver<SentimentResponse>() {
            @Override
            public void onNext(SentimentResponse response) {
                SwingUtilities.invokeLater(() -> {
                    sentimentResultArea.setText(
                            "Sentiment: " + response.getSentiment() +
                                    "\nScore: " + response.getScore()
                    );
                });
            }

            @Override
            public void onError(Throwable t) {
                SwingUtilities.invokeLater(() -> {
                    sentimentResultArea.setText("Error: " + t.getMessage());
                    JOptionPane.showMessageDialog(
                            SentimentAnalyzerUI.this,
                            "Analysis failed: " + t.getMessage(),
                            "Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                });
            }

            @Override
            public void onCompleted() {
                System.out.println("Analysis completed.");
            }
        });
    }

    // --- Live Sentiment Section ---
    private void createLiveSentimentSection() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder("Live Sentiment Stream"));

        liveSentimentArea = new JTextArea(5, 20);
        liveSentimentArea.setEditable(false);
        startLiveSentimentButton = new JButton("Start Live Stream");
        cleanLiveSentimentButton = new JButton("Clear");

        startLiveSentimentButton.addActionListener(e -> startLiveSentimentStream());
        cleanLiveSentimentButton.addActionListener(e -> clearFields("live"));

        panel.add(startLiveSentimentButton);
        panel.add(cleanLiveSentimentButton);
        panel.add(new JScrollPane(liveSentimentArea));

        add(panel, BorderLayout.SOUTH);
    }

    private void startLiveSentimentStream() {
        StreamObserver<SentimentResponse> responseObserver = new StreamObserver<SentimentResponse>() {
            @Override
            public void onNext(SentimentResponse response) {
                SwingUtilities.invokeLater(() -> {
                    liveSentimentArea.setText(
                            "Live Sentiment: " + response.getSentiment() +
                                    "\nScore: " + response.getScore()
                    );
                });
            }

            @Override
            public void onError(Throwable t) {
                SwingUtilities.invokeLater(() -> {
                    liveSentimentArea.setText("Stream error: " + t.getMessage());
                });
            }

            @Override
            public void onCompleted() {
                SwingUtilities.invokeLater(() -> {
                    liveSentimentArea.append("\nStream ended.");
                });
            }
        };

       // StreamObserver<TextRequest> requestObserver = sentimentAnalyzerStub
       //         .streamLiveSentiment(responseObserver);


      //  TextRequest request = TextRequest.newBuilder()
       //         .setText(textToAnalyzeArea.getText())
       //         .build();
       // requestObserver.onNext(request);
      //  requestObserver.onCompleted();

    }
    // --- Helper Methods ---
    private void clearFields(String section) {
        switch (section) {
            case "feedback":
                feedbackTextArea.setText("");
                feedbackSummaryArea.setText("");
                break;
            case "sentiment":
                textToAnalyzeArea.setText("");
                sentimentResultArea.setText("");
                break;
            case "live":
                liveSentimentArea.setText("");
                break;
        }
    }

    public static void main(String[] args) {
        new SentimentAnalyzerUI();
    }
}