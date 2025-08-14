package com.example.Food_Restaurant.Service;

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
    @Scheduled(fixedRate = 1000)
    public void scheduler(){
        List<Order> ors = orp.findByupdate("Ready for pick");
        List<DeliveryPartner> drs = drepo.findByIsfreeTrueAndActiveTrue();
        System.out.println(ors);
        for (Order s:ors){
            if (!drs.isEmpty()){
                DeliveryPartner dp2 = drs.remove(0);
//                System.out.println(dp2);
                kpp.saver(s);
                dp2.setIsfree(Boolean.FALSE);
                dp2.setCurrentorderid(s.getRid());
//                drepo.save(dp2);
                s.setUpdate("Picked");
//                orp.save(s);
                System.out.println("Order"+s.getOid()+ " Assigned to"+dp2.getDpname());
            }
        }
    }
}
