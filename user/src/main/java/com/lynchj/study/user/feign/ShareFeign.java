package com.lynchj.study.user.feign;

import com.lynchj.study.user.config.FeignConfig;
import com.lynchj.study.user.model.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "order", configuration = FeignConfig.class)
public interface ShareFeign {

    @GetMapping("/order/getOrder/{id}")
    String getOrder(@PathVariable("id") Long id);

    @GetMapping("/order/querySingle")
    String querySingle(@RequestParam("id") String id);

    @GetMapping("/order/queryModel")
    Order queryModel(@SpringQueryMap Order order);

    @PostMapping("/order/bodyModel")
    Order bodyModel(@RequestBody Order order);

}
