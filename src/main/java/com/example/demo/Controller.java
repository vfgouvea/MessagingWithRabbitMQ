package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    OrderQueueSender order;

    @PostMapping(value = "msg")
    private void msg(@RequestBody String value){
        order.send(value);
    }

}
