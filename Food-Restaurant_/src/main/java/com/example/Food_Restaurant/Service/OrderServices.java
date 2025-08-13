package com.example.Food_Restaurant.Service;

import com.example.Food_Restaurant.Models.Order;
import com.example.Food_Restaurant.Repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class OrderServices {
    @Autowired
    OrderRepo orep;

    public Order neworder(Order o1) {
        return orep.save(o1);
    }

    public List<Order> getallordersforres(int rid){
        return orep.findByrid(rid).stream().filter(Order::getStatus).toList();
    }

    public List<Order> getallhisordersforres(int rid){
        return orep.findByrid(rid).stream().filter(order -> Boolean.FALSE.equals(order.getStatus())).toList();
    }

    public Order ready(int id) {
        Order o2 = orep.findById(id).get();
        o2.setUpdate("Ready for pick");
        orep.save(o2);
        return o2;
    }
}
