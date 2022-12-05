package com.lynchj.study.user.feign;

import com.lynchj.study.user.model.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "order")
public interface ShareFeign {

    @GetMapping("/order/getOrder/{id}")
    String getOrder(@PathVariable("id") Long id);

    @GetMapping("/order/querySingle")
    String querySingle(@RequestParam("id") String id);

    @GetMapping("/order/queryModel")
    Order queryModel(@SpringQueryMap Order order);

}
