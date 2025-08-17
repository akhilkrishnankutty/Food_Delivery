package com.example.Food_Restaurant.Kafka;

import com.example.Food_Restaurant.Models.DeliveryPartner;
import com.example.Food_Restaurant.Models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {
    private KafkaTemplate<String,Object> kafkaTemplate;
    @Autowired
    public KafkaProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    public void saver(Order dd){
        kafkaTemplate.send("Available_partners",dd);
    }

    public void Deliverypartnerfree(DeliveryPartner p1){
        kafkaTemplate.send("free_partner",p1);
    }

    public void foodready(Order order){
        kafkaTemplate.send("order_pickup",order);
    }
}
