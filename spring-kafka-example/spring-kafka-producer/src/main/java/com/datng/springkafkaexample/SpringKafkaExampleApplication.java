package com.datng.springkafkaexample;

import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@Slf4j
@EnableScheduling
public class SpringKafkaExampleApplication {

  @Autowired
  private KafkaTemplate<String, String> kafkaTemplate;
  private int messageCounter = 0;

  public static void main(String[] args) {
    SpringApplication.run(SpringKafkaExampleApplication.class, args);
  }

  @Scheduled(fixedDelay = 2000)
  public void produce() {
    kafkaTemplate.send("topic1", "This is message number: " + messageCounter);
    log.info("Message sent [{}]", messageCounter);
    messageCounter++;
  }


}
