package sentimentanalyzer;

import javax.swing.*;
import java.awt.*;
import io.grpc.*;
import sentimentanalyzer.AlertServiceProto.*;
import sentimentanalyzer.FeedbackCollectorProto.*;
import io.grpc.stub.*;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.prefs.Preferences;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.io.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SentimentAnalyzerUI extends JFrame {
    private static final Logger logger = LoggerFactory.getLogger(SentimentAnalyzerUI.class);

    private final ManagedChannel channel;
    private final SentimentAnalyzerServiceGrpc.SentimentAnalyzerServiceStub sentimentAnalyzerStub;
    private final AlertServiceGrpc.AlertServiceStub alertServiceStub;
    private final FeedbackCollectorServiceGrpc.FeedbackCollectorServiceStub feedbackCollectorStub;

    private JTextArea inputTextArea, resultArea;
    private JButton analyzeButton, clearButton, loginButton, feedbackButton;
    private JPanel alertPanel, userPanel;
    private JLabel alertLabel, userLabel;
    private String currentUser;

    private final Preferences prefs = Preferences.userNodeForPackage(SentimentAnalyzerUI.class);
    private static final String USER_ID_KEY = "user_id";

    private final Object[][] NEGATIVE_KEYWORDS = {
            {"frustrated", 0.9f}, {"angry", 1.0f}, {"disappointed", 0.8f},
            {"terrible", 1.0f}, {"awful", 1.0f}, {"horrible", 1.0f},
    };

    private final Object[][] POSITIVE_KEYWORDS = {
            {"good", 0.7f}, {"excellent", 0.9f}, {"great", 0.8f},
            {"awesome", 0.9f}, {"perfect", 1.0f}, {"love", 0.9f}
    };

    public SentimentAnalyzerUI() {
        currentUser = prefs.get(USER_ID_KEY, "Guest");

        channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();
        sentimentAnalyzerStub = SentimentAnalyzerServiceGrpc.newStub(channel);
        alertServiceStub = AlertServiceGrpc.newStub(channel);
        feedbackCollectorStub = FeedbackCollectorServiceGrpc.newStub(channel);

        setTitle("Enhanced Sentiment Analysis Dashboard");
        setSize(700, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        createUserPanel();
        createAnalysisPanel();
        createAlertPanel();

        setVisible(true);
    }

    private void createUserPanel() {
        userPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        userLabel = new JLabel("User: " + currentUser);
        loginButton = new JButton("Change User");

        loginButton.addActionListener(e -> showLoginDialog());

        userPanel.add(userLabel);
        userPanel.add(loginButton);
        add(userPanel);
    }

    private void createAnalysisPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder("Enhanced Sentiment Analysis"));

        inputTextArea = new JTextArea(5, 60);
        inputTextArea.setLineWrap(true);
        inputTextArea.setWrapStyleWord(true);

        resultArea = new JTextArea(10, 60);
        resultArea.setEditable(false);
        resultArea.setBackground(new Color(240, 240, 240));

        analyzeButton = new JButton("Analyze Text");
        clearButton = new JButton("Clear");
        feedbackButton = new JButton("Show Feedback Summary");

        clearButton.addActionListener(e -> {
            inputTextArea.setText("");
            resultArea.setText("");
            clearAlert();
        });

        analyzeButton.addActionListener(e -> {
            String text = inputTextArea.getText().trim();
            if (text.isEmpty()) {
                resultArea.setText("Please enter some text to analyze");
                return;
            }

            resultArea.setText("Analyzing...");
            analyzeButton.setEnabled(false);

            sentimentAnalyzerStub.analyzeText(
                    TextRequest.newBuilder().setText(text).build(),
                    new StreamObserver<SentimentResponse>() {
                        @Override
                        public void onNext(SentimentResponse response) {
                            SwingUtilities.invokeLater(() -> {
                                SentimentResult result = enhancedSentimentAnalysis(text, response);
                                displayResults(result);
                                analyzeButton.setEnabled(true);
                            });
                        }

                        @Override
                        public void onError(Throwable t) {
                            SwingUtilities.invokeLater(() -> {
                                resultArea.setText("Error: " + t.getMessage());
                                logger.error("Error analyzing text", t);
                                analyzeButton.setEnabled(true);
                            });
                        }

                        @Override
                        public void onCompleted() {
                            SwingUtilities.invokeLater(() -> analyzeButton.setEnabled(true));
                        }
                    }
            );
        });

        feedbackButton.addActionListener(e -> submitFeedbacks());

        panel.add(new JLabel("Enter text to analyze:"));
        panel.add(new JScrollPane(inputTextArea));
        panel.add(Box.createVerticalStrut(10));
        panel.add(analyzeButton);
        panel.add(Box.createVerticalStrut(5));
        panel.add(clearButton);
        panel.add(Box.createVerticalStrut(10));
        panel.add(feedbackButton);
        panel.add(Box.createVerticalStrut(10));
        panel.add(new JLabel("Enhanced Analysis Result:"));
        panel.add(new JScrollPane(resultArea));

        add(panel);
    }

    private void createAlertPanel() {
        alertPanel = new JPanel(new BorderLayout());
        alertPanel.setBorder(BorderFactory.createTitledBorder("Priority Alerts"));
        alertPanel.setBackground(Color.WHITE);
        alertPanel.setPreferredSize(new Dimension(400, 150));

        alertLabel = new JLabel("No active alerts", SwingConstants.CENTER);
        alertLabel.setFont(new Font("Arial", Font.BOLD, 14));
        alertPanel.add(alertLabel, BorderLayout.CENTER);

        add(alertPanel);
    }

    private void showLoginDialog() {
        JPanel panel = new JPanel(new GridLayout(2, 2, 5, 5));
        JTextField userIdField = new JTextField(currentUser.equals("Guest") ? "" : currentUser);

        panel.add(new JLabel("User ID:"));
        panel.add(userIdField);
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));

        int result = JOptionPane.showConfirmDialog(
                this,
                panel,
                "User Login",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );

        if (result == JOptionPane.OK_OPTION) {
            String newUser = userIdField.getText().trim();
            if (!newUser.isEmpty()) {
                currentUser = newUser;
                userLabel.setText("User: " + currentUser);
                prefs.put(USER_ID_KEY, currentUser);
            }
        }
    }

    private void displayResults(SentimentResult result) {
        resultArea.setText(String.format(
                "Service Response: %s (%.2f)\n" +
                        "Enhanced Analysis: %s (%.2f)\n" +
                        "Negative Words: %s\n" +
                        "Positive Words: %s\n\n" +
                        "Final Determination: %s",
                result.sentiment,
                result.score,
                result.finalSentiment,
                result.finalScore,
                result.negativeWords.isEmpty() ? "None" : result.negativeWords,
                result.positiveWords.isEmpty() ? "None" : result.positiveWords,
                result.finalSentiment
        ));

        if (result.finalSentiment.equals("negative")) {
            triggerAlert(inputTextArea.getText().trim(), result);
        }
    }

    private SentimentResult enhancedSentimentAnalysis(String text, SentimentResponse serviceResponse) {
        String lowerText = text.toLowerCase();

        StringBuilder negativeWords = new StringBuilder();
        float maxNegativeWeight = 0f;
        for (Object[] keywordData : NEGATIVE_KEYWORDS) {
            String keyword = (String) keywordData[0];
            float weight = (Float) keywordData[1];
            if (lowerText.contains(keyword)) {
                if (negativeWords.length() > 0) negativeWords.append(", ");
                negativeWords.append(keyword);
                maxNegativeWeight = Math.max(maxNegativeWeight, weight);
            }
        }

        StringBuilder positiveWords = new StringBuilder();
        float maxPositiveWeight = 0f;
        for (Object[] keywordData : POSITIVE_KEYWORDS) {
            String keyword = (String) keywordData[0];
            float weight = (Float) keywordData[1];
            if (lowerText.contains(keyword)) {
                if (positiveWords.length() > 0) positiveWords.append(", ");
                positiveWords.append(keyword);
                maxPositiveWeight = Math.max(maxPositiveWeight, weight);
            }
        }

        String finalSentiment;
        float finalScore;

        if (maxNegativeWeight >= 0.9f) {
            finalSentiment = "negative";
            finalScore = Math.max(0.9f, serviceResponse.getScore());
        } else if (maxPositiveWeight >= 0.9f) {
            finalSentiment = "positive";
            finalScore = Math.max(0.9f, serviceResponse.getScore());
        } else if (maxNegativeWeight >= 0.7f) {
            finalSentiment = serviceResponse.getScore() < 0.5f ? "negative" : "neutral";
            finalScore = serviceResponse.getScore();
        } else if (maxPositiveWeight >= 0.7f) {
            finalSentiment = serviceResponse.getScore() > 0.5f ? "positive" : "neutral";
            finalScore = serviceResponse.getScore();
        } else {
            finalSentiment = serviceResponse.getSentiment();
            finalScore = serviceResponse.getScore();
        }

        return new SentimentResult(
                serviceResponse.getSentiment(),
                serviceResponse.getScore(),
                negativeWords.toString(),
                positiveWords.toString(),
                finalSentiment,
                finalScore
        );
    }

    private static class SentimentResult {
        String sentiment;
        float score;
        String negativeWords;
        String positiveWords;
        String finalSentiment;
        float finalScore;

        public SentimentResult(String sentiment, float score,
                               String negativeWords, String positiveWords,
                               String finalSentiment, float finalScore) {
            this.sentiment = sentiment;
            this.score = score;
            this.negativeWords = negativeWords;
            this.positiveWords = positiveWords;
            this.finalSentiment = finalSentiment;
            this.finalScore = finalScore;
        }
    }

    private void showCriticalAlert(String message) {
        SwingUtilities.invokeLater(() -> {
            alertLabel.setText("<html>" + message.replace("\n", "<br>") + "</html>");
            alertPanel.setBackground(Color.RED);
            alertLabel.setForeground(Color.WHITE);

            javax.swing.Timer flashTimer = new javax.swing.Timer(500, e -> {
                Color current = alertPanel.getBackground();
                alertPanel.setBackground(current.equals(Color.RED) ? Color.ORANGE : Color.RED);
            });
            flashTimer.start();

            new javax.swing.Timer(5000, e -> flashTimer.stop()).start();
        });
    }

    private void clearAlert() {
        SwingUtilities.invokeLater(() -> {
            alertLabel.setText("No active alerts");
            alertPanel.setBackground(Color.WHITE);
            alertLabel.setForeground(Color.BLACK);
        });
    }

    private void triggerAlert(String text, SentimentResult result) {
        int ticketId = new Random().nextInt(999999);
        String alertMessage = String.format(
                "NEGATIVE SENTIMENT ALERT\n" +
                        "User ID: %s\n" +
                        "Message: \"%s\"\n" +
                        "Score: %.2f\n" +
                        "Negative Words: %s\n" +
                        "Time: %s",
                currentUser,
                text.length() > 50 ? text.substring(0, 47) + "..." : text,
                result.finalScore,
                result.negativeWords,
                DateTimeFormatter.ISO_INSTANT.format(Instant.now())
        );

        showCriticalAlert(alertMessage);
        saveTicketToHistory(ticketId, currentUser, result.finalSentiment, text);
        sendAlertToService(text, result, ticketId);
    }

    private void sendAlertToService(String text, SentimentResult result, int ticketId) {
        AlertRequest alertRequest = AlertRequest.newBuilder()
                .setTicketId("T-" + ticketId)
                .setUrgency(result.finalScore > 0.9f ? "critical" : "high")
                .setSentiment(result.finalSentiment)
                .setMessage(text)
                .setUserId(currentUser)
                .build();

        alertServiceStub.alertChannel(new StreamObserver<AlertResponse>() {
            @Override
            public void onNext(AlertResponse response) {
                logger.info("Alert {} at {} for user {}", response.getStatus(), response.getTimestamp(), currentUser);
            }

            @Override
            public void onError(Throwable t) {
                logger.error("Failed to send alert", t);
            }

            @Override
            public void onCompleted() {}
        }).onNext(alertRequest);
    }

    private void saveTicketToHistory(int ticketId, String user, String sentiment, String message) {
        try (PrintWriter out = new PrintWriter(new FileWriter("ticket_history.txt", true))) {
            out.printf("Ticket: T-%06d | User: %s | Sentiment: %s | Time: %s | Message: %s%n",
                    ticketId,
                    user,
                    sentiment,
                    DateTimeFormatter.ISO_INSTANT.format(Instant.now()),
                    message.replace("\n", " "));
        } catch (IOException e) {
            logger.warn("Failed to write ticket history", e);
        }
    }

    private void submitFeedbacks() {
        CountDownLatch latch = new CountDownLatch(1);
        StreamObserver<FeedbackRequest> requestObserver = feedbackCollectorStub.submitFeedbacks(new StreamObserver<FeedbackSummary>() {
            @Override
            public void onNext(FeedbackSummary summary) {
                SwingUtilities.invokeLater(() -> {
                    JOptionPane.showMessageDialog(SentimentAnalyzerUI.this,
                            String.format("Feedback Summary:\n\nTotal: %d\nPositive: %d\nNegative: %d\nAvg Score: %.2f",
                                    summary.getTotalFeedbacks(),
                                    summary.getPositiveCount(),
                                    summary.getNegativeCount(),
                                    summary.getAverageSentimentScore()),
                            "Feedback Summary",
                            JOptionPane.INFORMATION_MESSAGE);
                });
            }

            @Override
            public void onError(Throwable t) {
                logger.error("Failed to get feedback summary", t);
                latch.countDown();
            }

            @Override
            public void onCompleted() {
                latch.countDown();
            }
        });

        // Simulated feedbacks
        requestObserver.onNext(FeedbackRequest.newBuilder().setFeedbackText("I love this service").build());
        requestObserver.onNext(FeedbackRequest.newBuilder().setFeedbackText("It was terrible today").build());
        requestObserver.onNext(FeedbackRequest.newBuilder().setFeedbackText("Pretty average experience").build());
        requestObserver.onCompleted();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                new SentimentAnalyzerUI();
            } catch (Exception e) {
                logger.error("Failed to start application", e);
            }
        });
    }
}
