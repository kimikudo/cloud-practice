package com.kay.practice.rabbitmqtest;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RabbitmqTestApplicationTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    void testHelloWorld(){
        rabbitTemplate.convertAndSend("hellosr","hello spring boot reabbitmq");
    }

    /*@Test
    void contextLoads() {
    }*/

}
