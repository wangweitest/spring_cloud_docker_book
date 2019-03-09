package com.itmuch.cloud.study.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.itmuch.cloud.study.user.entity.User;

@RestController
public class MovieController {
  @Autowired
  private RestTemplate restTemplate;

//  private static String REST_URL_PREFIX = "http://localhost:8000";
  private static String REST_URL_PREFIX = "http://microservice-provider-user";


  @GetMapping("/user/{id}")
  public User findById(@PathVariable Long id) {
    return this.restTemplate.getForObject(REST_URL_PREFIX+"/" + id, User.class);
  }
}
