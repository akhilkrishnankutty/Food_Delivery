package com.example.Food_Restaurant.Service;

import com.example.Food_Restaurant.Kafka.KafkaListner;
import com.example.Food_Restaurant.Kafka.KafkaProducer;
import com.example.Food_Restaurant.Models.DeliveryPartner;
import com.example.Food_Restaurant.Models.Order;
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
        if(drs != null &&drs.getIsfree().equals(true)) {
            List<Order> ors = orp.findByupdate("Ready for pick");
            for (Order s : ors) {
//                System.out.println(dp2);
//                kpp.saver(s);
                drs.setIsfree(Boolean.FALSE);
                drs.setCurrentorderid(s.getRid());
//                drepo.save(drs);
                s.setUpdate("Picked");
//                orp.save(s);
//                System.out.println("Order"+s.getOid()+ " Assigned to"+drs.getDpname());

            }
        }
    }
}
