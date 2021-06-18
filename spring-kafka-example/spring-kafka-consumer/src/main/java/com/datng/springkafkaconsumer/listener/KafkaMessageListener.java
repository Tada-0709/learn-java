package com.datng.springkafkaconsumer.listener;

import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.TopicPartition;
import org.jetbrains.annotations.NotNull;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.ConsumerSeekAware;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaMessageListener implements ConsumerSeekAware {

  @KafkaListener(groupId = "group1", id = "consumer1", topics = "topic1")
  public void consumer(String message) {
    log.info("Group 1 - Consumer 1: {}", message);
  }

  @KafkaListener(groupId = "group1", id = "consumer2", topics = "topic1")
  public void consumer2(String message) {
    log.info("Group 1 - Consumer 2: {}", message);
  }

  @KafkaListener(groupId = "group1", id = "consumer3", topics = "topic1")
  public void consumer3(String message) {
    log.info("Group 1 - Consumer 3: {}", message);
  }

  @KafkaListener(groupId = "group1", id = "consumer4", topics = "topic1")
  public void consumer4(String message) {
    log.info("Group 1 - Consumer 4: {}", message);
  }

  /* Replay message on partition assigned */
  @Override
  public void onPartitionsAssigned(Map<TopicPartition, Long> assignments,
      @NotNull ConsumerSeekCallback callback) {
    assignments.forEach((t, o) -> {
      log.info("[Seek to beginning] Topic {}, Partition {}", t.topic(), t.partition());
      callback.seekToBeginning(t.topic(), t.partition());
    });
  }

//  @KafkaListener(groupId = "group1", id = "consumer5", topics = "topic1")
//  public void listen5(String message) {
//    log.info("Group 1 - Consumer 5: {}", message);
//  }

}
