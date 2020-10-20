package com.kay.practice.serviceapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/service-api")
public class ApiController {

    @Autowired
    private ServiceWebFeignClient serviceWebFeignClient;

    @GetMapping("/apiTest")
    public String apiTest() {
        return "This is service-api apiTest";
    }

    @GetMapping("/feignWeb")
    public String feignWeb() {
        String result = serviceWebFeignClient.feignWeb();
        return "api feign to web , and call back " + result;
    }
}
