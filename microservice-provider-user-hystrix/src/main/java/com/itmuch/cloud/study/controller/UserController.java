package com.itmuch.cloud.study.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.itmuch.cloud.study.entity.User;
import com.itmuch.cloud.study.repository.UserRepository;

@RestController
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository;

    @HystrixCommand(fallbackMethod="findByIdFallback")
    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        User findOne = this.userRepository.findOne(id);
        if(findOne == null){
            throw new RuntimeException("查询数据为空");
        }
        return findOne;
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
