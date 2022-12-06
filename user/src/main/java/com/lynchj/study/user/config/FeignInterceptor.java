package com.lynchj.study.user.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Slf4j
public class FeignInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        log.info("【FeignInterceptor】- 进入拦截器");
        template.header("TOKEN", UUID.randomUUID().toString());
    }

}
