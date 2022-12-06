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

}
