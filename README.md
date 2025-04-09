# CustomerSupportAutomation
An intelligent automation system for customer support that uses sentiment analysis to prioritize critical tickets. It includes three services: SentimentAnalyzerService, FeedbackCollectorService, and AlertService. Built with gRPC, Java, and React, it aims to enhance support efficiency and response time.
Intelligent Automation System for Customer Support with Sentiment Analysis
This project builds an automated customer support system that uses sentiment analysis to prioritize important tickets and improve service efficiency. The system is made up of three services connected through gRPC:
SentimentAnalyzerService: Analyzes customer messages to detect sentiment (positive, neutral, negative).
FeedbackCollectorService: Collects and processes customer feedback in batches.
AlertService: Sends real-time alerts to the support team about urgent issues.
Key Features
Detects sentiment in customer messages.
Prioritizes tickets based on urgency.
Sends alerts for critical issues.
Uses gRPC for communication between services.
Provides a React interface for easy monitoring.
Technologies
Backend: Java with gRPC and Stanford CoreNLP for sentiment analysis.
Frontend: React for the graphical interface.
Security: JWT authentication.
Service Discovery: Consul for service registration.
Logs: Apache Log4j for error tracking.
Goal
The system helps businesses respond faster to unhappy customers and improves how support teams handle urgent tickets.
