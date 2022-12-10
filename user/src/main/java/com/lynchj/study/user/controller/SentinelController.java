package com.lynchj.study.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sentinel")
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
    public String helloWorld() {
        // 被保护的逻辑
        return  "Sentinel hello world";
    }

}
