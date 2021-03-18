package com.kay.practice.servicemain.controller;

import com.kay.practice.servicemain.entity.ImsiSourceData;
import com.kay.practice.servicemain.entity.User;
import com.kay.practice.servicemain.service.DruidTestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @Autowired
    private DruidTestService druidTestService;

    @GetMapping("/swagger-ui")
    @ApiOperation(value = "接口测试", notes = "Swagger测试")
    public String swaggerTest() {
        System.out.println("这里是控制器!");
        return "请求成功哦!";
    }

    @GetMapping("/practice-source-test")
    @ApiOperation(value = "主数据源测试", notes = "主数据源测试")
    public String practiceSourceTest() {
        List<User> userList = druidTestService.listUser();
        System.out.println(userList.toString());
        return "测试成功";
    }

    @GetMapping("/police-source-test")
    @ApiOperation(value = "副数据源测试", notes = "副数据源测试")
    public String policeSourceTest() {
        List<ImsiSourceData> imsiList = druidTestService.listImsi();
        System.out.println(imsiList.toString());
        return "测试成功";
    }
}
