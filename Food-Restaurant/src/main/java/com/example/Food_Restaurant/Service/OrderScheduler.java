package com.example.Food_Restaurant.Service;

import com.example.Food_Restaurant.Kafka.KafkaListner;
import com.example.Food_Restaurant.Kafka.KafkaProducer;
import com.example.Food_Restaurant.Models.DeliveryPartner;
import com.example.Food_Restaurant.Models.Order;
import com.example.Food_Restaurant.Models.OrderStatus;
import com.example.Food_Restaurant.Repo.DeliveryPartnerRepo;
import com.example.Food_Restaurant.Repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderScheduler {

    @Autowired
    OrderRepo orp;
    @Autowired
    DeliveryPartnerRepo drepo;
    @Autowired
    KafkaProducer kpp;
    @Autowired
    KafkaListner kll;
    @Scheduled(fixedRate = 1000)
    public void scheduler(){
        DeliveryPartner drs = kll.getPartner();
        Order o1 = kll.getOrder();
        if(drs != null &&drs.getIsfree().equals(true) && drs.getActive().equals(true)) {
//            List<Order> ors = orp.findByupdate(OrderStatus.Ready_to_pick);
            if(o1 != null && o1.getUpdate()==OrderStatus.Ready_to_pick)
                 {
                drs.setIsfree(Boolean.FALSE);
                drs.setCurrentorderid(o1.getOid());
                drepo.save(drs);
                o1.setUpdate(OrderStatus.Picked);
                orp.save(o1);
                System.out.println("Order"+o1.getOid()+ " Assigned to"+drs.getDpname());

            }
        }
    }
}
