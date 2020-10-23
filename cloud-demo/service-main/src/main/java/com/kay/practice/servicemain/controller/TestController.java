package com.kay.practice.servicemain.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试控制器
 *
 * @author Kay
 * @date 2020-10-23
 */
@RestController
@RequestMapping(value = "/test")
@Api(tags = "功能测试控制器")
public class TestController {

    @GetMapping("/swagger-ui")
    @ApiOperation(value = "接口测试", notes = "Swagger测试")
    public String swaggerTest() {
        System.out.println("这里是控制器!");
        return "请求成功哦!";
    }
}
