package com.itmuch.cloud.study;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
//注意：测试这个hystrix的时候，关闭provider测试
public class ConsumerMovieFeignHystrixApplication {
  public static void main(String[] args) {
    SpringApplication.run(ConsumerMovieFeignHystrixApplication.class, args);
  }

  @Bean
  public IRule iRule(){
    return new RandomRule();
  }

}



