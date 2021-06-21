package com.zookeeper.servicediscovery.consumer;

import com.zookeeper.servicediscovery.consumer.ProducerClient.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

  @Autowired
  private Client client;

  @GetMapping("/hello-from-producer")
  public String greeting() {
    return client.hello();
  }
}
