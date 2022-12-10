package com.lynchj.study.user.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/sentinel")
@Slf4j
public class SentinelController {

    /**
     * 配置限流规则
     *  定义了资源 HelloWorld 每秒最多只能通过 2 个请求。
     */
    /*@PostConstruct
    public void initFlowRules() {
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        rule.setResource("HelloWorld");
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        // Set limit QPS to 20.
        rule.setCount(2);
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
    }*/

    @GetMapping("/helloWorld")
//    @SentinelResource("HelloWorld")
    public String helloWorld() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        return  "Sentinel hello world";
    }

    @GetMapping("/downgrade/slowCall")
    public String slowCall() throws InterruptedException {
        int random = ThreadLocalRandom.current().nextInt(10) + 1;
        if (random > 3) {
            TimeUnit.MILLISECONDS.sleep(101);
            log.warn("【slowCall】- 超过 100ms");
        } else {
            log.info("【slowCall】- 正常返回");
        }
        return  "Sentinel downgrade slowCall";
    }

    @GetMapping("/downgrade/errorRatio")
    public String errorRatio() {
        int random = ThreadLocalRandom.current().nextInt(10) + 1;
        if (random > 5) {
            log.warn("【errorRatio】- 触发异常");
            int i = 1 / 0;
        } else {
            log.info("【errorRatio】- 正常返回");
        }
        return  "Sentinel downgrade errorRatio";
    }

}
