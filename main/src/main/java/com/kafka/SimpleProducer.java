package com.kafka;


import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;
import org.apache.kafka.clients.producer.Callback;

public class SimpleProducer {
    public static void main(String[] args) {

        // Define the properties for the Kafka producer
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        final Logger logger = LoggerFactory.getLogger(SimpleProducer.class);

        Producer<String, String> producer = new KafkaProducer<>(props);
                for (int i = 0; i < 1000; i++) {
                    producer.send(new ProducerRecord<String, String>("fourth-topic", Integer.toString(i), "Simple message " + i));
                }
                
                logger.info("Closing the producer");
        logger.info("Closing the producer");
        producer.close();
    }
}
    
