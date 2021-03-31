package com.kay.practice.rabbitmqtest;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queuesToDeclare = @Queue("hellosr"))
public class HelloConsumer {

    @RabbitHandler
    public void receivel(String message){
        System.out.println(message);
    }
}
