package com.example.demo;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class OrderConsumer {

    @RabbitListener(queues = {"${queue.order.name}"})
    public String receive(@Payload String order) throws InterruptedException {
        System.out.println("Consumindo... "+order);
        Thread.sleep(1000);
        return "Consumido: "+order;
    }
}