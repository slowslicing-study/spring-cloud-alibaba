package com.lynchj.study.user.config;

import feign.Logger;
import feign.Request;
import org.springframework.context.annotation.Bean;

//@Configuration // 如果加上此注解，则全局生效，否则就只生效在配置的 Feign 上
public class FeignConfig {

    @Bean
    public Logger.Level level() {
        return Logger.Level.FULL;
    }

//    @Bean
    public Request.Options options() {
        return new Request.Options(2000, 2000);
    }

    /*@Bean
    public Retryer retryer() {
        // period=1000 当前请求失败之后 到 发起下一次重试请求之间的间隔时间，单位毫秒
        // maxPeriod=1000 发起当前请求的最大间隔时间，单位毫秒
        // maxAttempts=2 重试次数，包括第一次请求，所以如果想要重试 2 次，就需要设置为 3
        Retryer retryer = new Retryer.Default(1000, 1000, 3);
        return retryer;
    }*/

}
