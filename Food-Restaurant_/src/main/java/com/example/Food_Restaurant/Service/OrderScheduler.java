package com.example.Food_Restaurant.Service;

import com.example.Food_Restaurant.Models.Order;
import com.example.Food_Restaurant.Repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderScheduler {

    @Autowired
    OrderRepo orp;
    @Scheduled(fixedRate = 5000)
    public void scheduler(){
        List<Order> ors = orp.findByupdate("Ready for pick");
        System.out.println(ors);
    }
}
