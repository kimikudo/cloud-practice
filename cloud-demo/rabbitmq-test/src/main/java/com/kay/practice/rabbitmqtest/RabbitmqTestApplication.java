package com.kay.practice.rabbitmqtest;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.stereotype.Component;


@SpringBootApplication
@EnableDiscoveryClient
public class RabbitmqTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqTestApplication.class, args);
    }

}
