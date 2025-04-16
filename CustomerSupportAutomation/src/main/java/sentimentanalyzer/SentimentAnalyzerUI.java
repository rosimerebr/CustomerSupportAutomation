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
    private final SentimentAnalyzerServiceGrpc.SentimentAnalyzerServiceBlockingStub sentimentAnalyzerBlockingStub;
    private final FeedbackCollectorServiceGrpc.FeedbackCollectorServiceStub feedbackCollectorStub;

    // Components for the Feedback Collector
    private JTextArea feedbackTextArea;
    private JButton submitFeedbackButton;
    private JTextArea feedbackSummaryArea;

    // Components for the Sentiment Analyzer
    private JTextArea textToAnalyzeArea;
    private JButton analyzeSentimentButton;
    private JTextArea sentimentResultArea;

    // Components for the Live Sentiment Stream
    private JTextArea liveSentimentArea;
    private JButton startLiveSentimentButton;

    public SentimentAnalyzerUI() {
        // Initialize gRPC channel and stubs
        channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        sentimentAnalyzerBlockingStub = SentimentAnalyzerServiceGrpc.newBlockingStub(channel);
        feedbackCollectorStub = FeedbackCollectorServiceGrpc.newStub(channel);

        // Set up the JFrame
        setTitle("Sentiment Analyzer & Feedback Collector");
        setSize(600, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Initialize the sections of the interface
        createFeedbackSection();
        createSentimentSection();
        createLiveSentimentSection();

        // Make the window visible
        setVisible(true);
    }

    // Create the Feedback Collector section
    private void createFeedbackSection() {
        JPanel feedbackPanel = new JPanel();
        feedbackPanel.setLayout(new BoxLayout(feedbackPanel, BoxLayout.Y_AXIS));
        feedbackPanel.setBorder(BorderFactory.createTitledBorder("Feedback Collector"));

        // Initialize components for the Feedback Collector
        feedbackTextArea = new JTextArea(5, 20);
        submitFeedbackButton = new JButton("Submit Feedback");
        feedbackSummaryArea = new JTextArea(5, 20);
        feedbackSummaryArea.setEditable(false);

        // Action listener for the "Submit Feedback" button
        submitFeedbackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submitFeedback();
            }
        });

        // Add components to the panel
        feedbackPanel.add(new JLabel("Feedback Text:"));
        feedbackPanel.add(new JScrollPane(feedbackTextArea));
        feedbackPanel.add(submitFeedbackButton);
        feedbackPanel.add(new JScrollPane(feedbackSummaryArea));

        // Add the panel to the frame
        add(feedbackPanel, BorderLayout.NORTH);
    }

    // Submit feedback to the server via gRPC
    private void submitFeedback() {
        StreamObserver<FeedbackRequest> feedbackObserver = feedbackCollectorStub.submitFeedbacks(new StreamObserver<FeedbackSummary>() {
            @Override
            public void onNext(FeedbackSummary value) {
                // Show feedback summary in the UI
                feedbackSummaryArea.setText("Total Feedbacks: " + value.getTotalFeedbacks() + "\n" +
                        "Positive: " + value.getPositiveCount() + "\n" +
                        "Negative: " + value.getNegativeCount() + "\n" +
                        "Average Sentiment: " + value.getAverageSentimentScore());
            }

            @Override
            public void onError(Throwable t) {
                feedbackSummaryArea.setText("Error submitting feedback: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                // No action needed when feedback submission is completed
            }
        });

        // Create the feedback request and send it
        String feedbackText = feedbackTextArea.getText();
        FeedbackRequest request = FeedbackRequest.newBuilder().setFeedbackText(feedbackText).build();
        feedbackObserver.onNext(request);  // Send feedback
        feedbackObserver.onCompleted();  // Close the stream
    }

    // Create the Sentiment Analyzer section
    private void createSentimentSection() {
        JPanel sentimentPanel = new JPanel();
        sentimentPanel.setLayout(new BoxLayout(sentimentPanel, BoxLayout.Y_AXIS));
        sentimentPanel.setBorder(BorderFactory.createTitledBorder("Sentiment Analyzer"));

        // Initialize components for the Sentiment Analyzer
        textToAnalyzeArea = new JTextArea(5, 20);
        analyzeSentimentButton = new JButton("Analyze Sentiment");
        sentimentResultArea = new JTextArea(5, 20);
        sentimentResultArea.setEditable(false);

        // Action listener for the "Analyze Sentiment" button
        analyzeSentimentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                analyzeSentiment();
            }
        });

        // Add components to the panel
        sentimentPanel.add(new JLabel("Text to Analyze:"));
        sentimentPanel.add(new JScrollPane(textToAnalyzeArea));
        sentimentPanel.add(analyzeSentimentButton);
        sentimentPanel.add(new JScrollPane(sentimentResultArea));

        // Add the panel to the frame
        add(sentimentPanel, BorderLayout.CENTER);
    }

    // Analyze sentiment of the entered text using gRPC
    private void analyzeSentiment() {
        String text = textToAnalyzeArea.getText();
        TextRequest request = TextRequest.newBuilder().setText(text).build();

        // Send request and receive response
        SentimentResponse response = sentimentAnalyzerBlockingStub.analyzeText(request);

        // Show the result in the UI
        sentimentResultArea.setText("Sentiment: " + response.getSentiment() + "\nScore: " + response.getScore());
        JOptionPane.showMessageDialog(this, "Sentiment: " + response.getSentiment(), "Sentiment Analysis Result", JOptionPane.INFORMATION_MESSAGE);
    }

    // Create the Live Sentiment Stream section
    private void createLiveSentimentSection() {
        JPanel liveSentimentPanel = new JPanel();
        liveSentimentPanel.setLayout(new BoxLayout(liveSentimentPanel, BoxLayout.Y_AXIS));
        liveSentimentPanel.setBorder(BorderFactory.createTitledBorder("Live Sentiment Stream"));

        // Initialize components for live sentiment streaming
        liveSentimentArea = new JTextArea(5, 20);
        liveSentimentArea.setEditable(false);
        startLiveSentimentButton = new JButton("Start Live Sentiment Stream");

        // Action listener for the "Start Live Sentiment Stream" button
        startLiveSentimentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startLiveSentimentStream();
            }
        });

        // Add components to the panel
        liveSentimentPanel.add(startLiveSentimentButton);
        liveSentimentPanel.add(new JScrollPane(liveSentimentArea));

        // Add the panel to the frame
        add(liveSentimentPanel, BorderLayout.SOUTH);
    }

    // Start live sentiment stream using gRPC
// Start live sentiment stream using gRPC
    private void startLiveSentimentStream() {
        // Create the StreamObserver for sending TextRequest to the gRPC service
        /*StreamObserver<TextRequest> requestObserver = sentimentAnalyzerBlockingStub
                .streamLiveSentiment(new StreamObserver<TextRequest>() {

                    public void onNext(SentimentResponse value) {
                        // Display live sentiment updates in the text area
                        liveSentimentArea.setText("Live Sentiment: " + value.getSentiment() + "\nScore: " + value.getScore());
                    }

                    @Override
                    public void onError(Throwable t) {
                        liveSentimentArea.setText("Error in live sentiment stream: " + t.getMessage());
                    }

                    @Override
                    public void onCompleted() {
                        // Mark the end of the stream
                    }
                });

        // Create the TextRequest to send the entered text
        String text = textToAnalyzeArea.getText();
        TextRequest request = TextRequest.newBuilder().setText(text).build();

        // Send the request to start streaming
        requestObserver.onNext(request);*/

        // Optionally, you could keep the stream open for continuous updates.
        // You might want to add a loop here to simulate continuous sending, or just close it after the initial text.
        // To end the stream, we would call requestObserver.onCompleted();
    }

    // Main method to launch the application
    public static void main(String[] args) {
        new SentimentAnalyzerUI();
    }
}
