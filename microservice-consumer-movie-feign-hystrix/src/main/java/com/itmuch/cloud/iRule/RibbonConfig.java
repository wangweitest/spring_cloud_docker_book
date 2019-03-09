package com.itmuch.cloud.iRule;


import com.itmuch.cloud.study.ConsumerMovieFeignApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;

@Configuration
@RibbonClient(name="microservice-provider-user",configuration = ConsumerMovieFeignApplication.class)
public class RibbonConfig {
}
