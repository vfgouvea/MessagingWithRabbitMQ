package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    @Autowired
    OrderSender order;

    @PostMapping(value = "msg",consumes = "application/json")
    private String msg(@RequestBody List<String> values){
        List<String> saida = new ArrayList<>();
        values.forEach(value -> saida.add(order.sendAndReceive(value)));
        return saida.toString();
    }

}
