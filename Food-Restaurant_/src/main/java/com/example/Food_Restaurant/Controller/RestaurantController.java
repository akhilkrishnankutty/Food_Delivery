package com.example.Food_Restaurant.Controller;


import com.example.Food_Restaurant.Models.Order;
import com.example.Food_Restaurant.Models.Restaurant;
import com.example.Food_Restaurant.Service.RestaurantServices;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("res")
public class RestaurantController {
    @Autowired
    RestaurantServices rservices;
    @GetMapping("/all")
    public List<Restaurant> getall(){
        System.out.println(rservices.getall());
        return rservices.getall();
    }
    @PostMapping("/save")
    public Restaurant saveRestaurant(@RequestBody Restaurant res){
        return rservices.saveres(res);

    }
    @PatchMapping("/changemenu/{id}")
    public Restaurant changeMenu(@PathVariable int id, @RequestBody HashMap<String,Integer> upmenu){
        return rservices.updateMenu(id,upmenu);
    }

    @GetMapping("/orders")
    public List<Order> getallorder(@PathVariable int id){
        return rservices.getallorders(id);
    }

    @GetMapping("/hisorders/{id}")
    public List<Order> orderhistory(@PathVariable int id){
        return rservices.historyorders(id);
    }
    @PostMapping("/ready/{id}")
    public Order ready(@PathVariable int id){
        return rservices.ready(id);
    }
}
