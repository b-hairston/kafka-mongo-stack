package com.kafka;

import java.util.*;
import java.util.concurrent.ExecutionException;



import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class MongoConsumer {
    public static void main(String[] args) {
        final Logger logger = LoggerFactory.getLogger(MongoConsumer.class);

        // Connect to MongoDB
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase database = mongoClient.getDatabase("mydatabase");
            MongoCollection<Document> collection = database.getCollection("messages");

            // Fetch sample msgs from Kafka
            for (int i = 0; i < 1000; i++) {
                // Create a document for the message
                Document doc = new Document("topic", "fourth-topic")
                                .append("messageId", i)
                                .append("message", "Simple message " + i);

                // Insert the document into the collection
                collection.insertOne(doc);
                logger.info("Inserted message with ID: " + i);
            }
        } catch (Exception e) {
            logger.error("An error occurred while inserting into MongoDB", e);
        }
    }
}