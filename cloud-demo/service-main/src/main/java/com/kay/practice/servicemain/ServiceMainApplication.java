package com.kay.practice.servicemain;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
//@MapperScan("com.kay.practice.servicemain.dao")
public class ServiceMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceMainApplication.class, args);
    }

}
