package com.kay.practice.serviceapi.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("service-web")
public interface ServiceWebFeignClient {
    @RequestMapping("/web/service-web/test")
    String feignWeb();
}
