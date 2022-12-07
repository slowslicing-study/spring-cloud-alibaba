package com.lynchj.study.user.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
@RefreshScope
public class NacosConfigController {

    @Value("${my.name}")
    private String myName;
    @Value("${my.hei}")
    private Integer myHei;

    @GetMapping("/testConfig1")
    public String testConfig1() {
        return myName + " : " + myHei;
    }

}
