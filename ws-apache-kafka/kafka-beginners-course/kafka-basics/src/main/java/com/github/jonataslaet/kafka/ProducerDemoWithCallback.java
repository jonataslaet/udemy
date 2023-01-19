package com.github.jonataslaet.kafka;

import java.util.Properties;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.clients.producer.RoundRobinPartitioner;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProducerDemoWithCallback {

  private static final Logger log = LoggerFactory.getLogger(ProducerDemoWithCallback.class.getSimpleName());

  public static void main(String[] args) {
    log.info("I am a kafka producer using callback");

    //Create Producer Properties
    Properties properties = new Properties();
    properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
    properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
    properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
    properties.setProperty("batch.size", "320");
//    properties.setProperty("partitioner.class", RoundRobinPartitioner.class.getName())

    //Create the Producer
    KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);

    for (int j = 0; j < 10; j++) {
      for (int i = 0; i < 30; i++) {
        //Create a producer record
        ProducerRecord<String, String> producerRecord = new ProducerRecord<>("demo_java", j+" Hello, World "+i);

        //Send the data - asynchronous
        producer.send(producerRecord, new Callback() {
          @Override
          public void onCompletion(RecordMetadata metadata, Exception exception) {
            //Executes every time a record successfully sent or exception is thrown
            if (exception == null) {
              //The record was succesfully sent
              log.info("Received new metadata: \n"+
                  "Topic: " + metadata.topic() + "\n" +
                  "Partition: " + metadata.partition() + "\n" +
                  "Offset: " + metadata.offset() + "\n" +
                  "Timestamp: " + metadata.timestamp()
              );

            } else {
              log.error("Error while producing", exception);
            }
          }
        });
      }

      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    //Flush data - synchronous
    producer.flush();

    //Flush and close producer
    producer.close();

  }
}
