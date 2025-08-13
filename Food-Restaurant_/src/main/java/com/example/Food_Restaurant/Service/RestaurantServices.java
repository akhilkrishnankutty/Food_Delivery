package com.example.Food_Restaurant.Service;

import com.example.Food_Restaurant.Models.Order;
import com.example.Food_Restaurant.Models.Restaurant;
import com.example.Food_Restaurant.Repo.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class RestaurantServices {
    @Autowired
    RestaurantRepo rRepo;

    @Autowired
    OrderServices oser;
    public Restaurant saveres(Restaurant res) {
        return rRepo.save(res);
    }

    public List<Restaurant> getall() {
        return rRepo.findAll();
    }

    public Restaurant updateMenu(int id, HashMap<String, Integer> upmenu) {
        Restaurant res = rRepo.findById(id).get();
        if (res.getRid()!=0){
            res.setRmenu(upmenu);
            rRepo.save(res);
        }
        return res;
    }

    public List<Order> getallorders(int id) {
        return oser.getallordersforres(id);
    }

    public List<Order> historyorders(int id) {
        return oser.getallhisordersforres(id);
    }

    public Order ready(int id) {
        return oser.ready(id);
    }
}
