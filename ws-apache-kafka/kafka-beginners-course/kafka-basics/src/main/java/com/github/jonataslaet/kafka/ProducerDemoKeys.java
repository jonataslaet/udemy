package com.github.jonataslaet.kafka;

import java.util.Properties;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProducerDemoKeys {

  private static final Logger log = LoggerFactory.getLogger(ProducerDemoKeys.class.getSimpleName());

  public static void main(String[] args) {
    log.info("I am a kafka producer using callback");

    //Create Producer Properties
    Properties properties = new Properties();
    properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
    properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
    properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

    //Create the Producer
    KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);

    for (int j = 0; j < 2; j++) {
      for (int i = 0; i < 10; i++) {
        String topic = "demo_java";
        String key = "id_" + i;
        String value = "Hello, World " + i;

        //Create a producer record
        ProducerRecord<String, String> producerRecord = new ProducerRecord<>(topic, key, value);

        //Send the data - asynchronous
        producer.send(producerRecord, new Callback() {
          @Override
          public void onCompletion(RecordMetadata metadata, Exception exception) {
            //Executes every time a record successfully sent or exception is thrown
            if (exception == null) {
              //The record was succesfully sent
              log.info("Key: " + key + "| Partition: " + metadata.partition());

            } else {
              log.error("Error while producing", exception);
            }
          }
        });
      }
    }

    //Flush data - synchronous
    producer.flush();

    //Flush and close producer
    producer.close();

  }
}
