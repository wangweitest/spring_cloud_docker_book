package com.itmuch.cloud.iRule;


import com.itmuch.cloud.study.ConsumerMovieApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;

@Configuration
@RibbonClient(name="microservice-provider-user",configuration = ConsumerMovieApplication.class)
public class RibbonConfig {
}
