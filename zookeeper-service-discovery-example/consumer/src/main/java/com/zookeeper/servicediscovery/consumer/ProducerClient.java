package com.zookeeper.servicediscovery.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Configuration
@EnableFeignClients
@EnableDiscoveryClient
public class ProducerClient {

  @Autowired
  private Client client;

  @FeignClient(name = "producer")
  interface Client {
    @GetMapping(path = "/producer/hello")
    @ResponseBody
    String hello();
  }

  public String hello() {
    return client.hello();
  }

}
