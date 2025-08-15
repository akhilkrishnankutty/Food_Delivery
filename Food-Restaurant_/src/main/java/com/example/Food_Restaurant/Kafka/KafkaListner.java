package com.example.Food_Restaurant.Kafka;

import com.example.Food_Restaurant.Models.DeliveryPartner;
import com.example.Food_Restaurant.Models.Order;
import lombok.Data;
import org.apache.kafka.clients.consumer.internals.Acknowledgements;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
@Data
public class KafkaListner {
    private DeliveryPartner currentpartner;
    @KafkaListener(topics = "free_partner",groupId = "order_group")
    public DeliveryPartner printer(DeliveryPartner s, Acknowledgment ack){
//        System.out.println(s);
        ack.acknowledge();
        System.out.println(s);
        this.currentpartner = s;
        return s;
    }
    public DeliveryPartner getPartner(){
        return currentpartner;
    }
}
