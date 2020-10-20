package com.kay.practice.serviceweb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/web/service-web")
public class WebController {

    @GetMapping("/test")
    public String test(){
        return "This is service-web test";
    }
}
