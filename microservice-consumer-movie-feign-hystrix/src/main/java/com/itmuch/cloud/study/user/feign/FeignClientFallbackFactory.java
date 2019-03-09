package com.itmuch.cloud.study.user.feign;

import com.itmuch.cloud.study.user.entity.User;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * UserFeignClient的fallbackFactory类，该类需实现FallbackFactory接口，并覆写create方法
 * The fallback factory must produce instances of fallback classes that
 * implement the interface annotated by {@link FeignClient}.
 */
@Component //不要忘记添加，不要忘记添加
class FeignClientFallbackFactory implements FallbackFactory<UserFeignClient> {
  private static final Logger LOGGER = LoggerFactory.getLogger(FeignClientFallbackFactory.class);

  @Override
  public UserFeignClient create(Throwable cause) {
    return new UserFeignClient() {
      @Override
      public User findById(Long id) {
        // 日志最好放在各个fallback方法中，而不要直接放在create方法中。
        // 否则在引用启动时，就会打印该日志。
        // 详见https://github.com/spring-cloud/spring-cloud-netflix/issues/1471
        FeignClientFallbackFactory.LOGGER.info("fallback; reason was:", cause);
        User user = new User();
        user.setId(-1L);
        user.setUsername("默认用户");
        return user;
      }
    };
  }
}