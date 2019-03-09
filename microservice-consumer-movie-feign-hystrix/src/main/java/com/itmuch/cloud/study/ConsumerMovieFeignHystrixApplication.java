package com.itmuch.cloud.study;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class ConsumerMovieFeignHystrixApplication {
  public static void main(String[] args) {
    SpringApplication.run(ConsumerMovieFeignHystrixApplication.class, args);
  }

  @Bean
  public IRule iRule(){
    return new RandomRule();
  }

}


