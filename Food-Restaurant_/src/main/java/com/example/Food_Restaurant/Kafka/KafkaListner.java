package com.example.Food_Restaurant.Kafka;

import com.example.Food_Restaurant.Models.Order;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListner {
    @KafkaListener(topics = "Available_partners",groupId = "order_group")
    public void printer(Order s){
        System.out.println();
    }
}
