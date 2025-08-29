package com.example.Food_Restaurant.Controller;

import com.example.Food_Restaurant.Models.Order;
import com.example.Food_Restaurant.Service.OrderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class OrderController {
    @Autowired
    OrderServices orderServices;
    @PostMapping("/new")
    public Order newOrder(@RequestBody Order o1){
        return orderServices.neworder(o1);
    }


}
