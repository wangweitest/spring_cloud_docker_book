package com.itmuch.cloud.study.user.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.itmuch.cloud.study.user.entity.User;
import com.itmuch.cloud.study.user.feign.UserFeignClient;

@RestController
public class MovieController {
  private static final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);
  @Autowired
  private UserFeignClient userFeignClient;

  @GetMapping("/user/{id}")
//  也可以用fallbackfactory处理
//  @HystrixCommand(fallbackMethod = "findByIdFallback")
  public User findById(@PathVariable Long id) {
    User user = this.userFeignClient.findById(id);
    return user;
  }

  /**
   * 如果想要获得导致fallback的原因，只需在fallback方法上添加Throwable参数即可。
   */
  public User findByIdFallback(Long id,Throwable throwable) {
    LOGGER.error("进入回退方法，异常：", throwable);
    User user = new User();
    user.setId(-1L);
    user.setName("默认用户");
    return user;
  }
}
