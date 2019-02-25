package com.itmuch.cloud.study;


import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;

@Configuration
@RibbonClient(name="microservice-provider-user",configuration = ConsumerMovieApplication.class)
public class RibbonConfig {
}
