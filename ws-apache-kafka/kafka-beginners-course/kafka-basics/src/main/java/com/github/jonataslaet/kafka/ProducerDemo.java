package com.github.jonataslaet.kafka;

import java.util.Properties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProducerDemo {

  private static final Logger log = LoggerFactory.getLogger(ProducerDemo.class.getSimpleName());

  public static void main(String[] args) {
    log.info("Hello, World!");

    //Create Producer Properties
    Properties properties = new Properties();
    properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
    properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
    properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

    //Create the Producer
    KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);

    //Create a producer record
    ProducerRecord<String, String> producerRecord = new ProducerRecord<>("demo_java", "Hello, World");

    //Send the data - asynchronous
    producer.send(producerRecord);

    //Flush data - synchronous
    producer.flush();

    //Flush and close producer
    producer.close();

  }
}
