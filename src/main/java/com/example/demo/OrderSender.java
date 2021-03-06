package com.example.demo;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queue;

    public String sendAndReceive(String order) {
        System.out.println("Sending..."+order);
        return (String) rabbitTemplate.convertSendAndReceive(this.queue.getName(), order);
    }

}
