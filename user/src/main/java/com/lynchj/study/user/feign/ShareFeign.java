package com.lynchj.study.user.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "order")
public interface ShareFeign {

    @GetMapping("/order/getOrder/{id}")
    String getOrder(@PathVariable("id") Long id);

}
