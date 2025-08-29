package com.example.Food_Restaurant.Service;

import com.example.Food_Restaurant.Kafka.KafkaProducer;
import com.example.Food_Restaurant.Models.DeliveryPartner;
import com.example.Food_Restaurant.Repo.DeliveryPartnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryPatnerService {
    @Autowired
    DeliveryPartnerRepo drepo;

    @Autowired
    OrderServices orderServices;
    @Autowired
    KafkaProducer kp1;


    public DeliveryPartner savennew(DeliveryPartner dp1) {
        return drepo.save(dp1);
    }

    public DeliveryPartner completed(int id) {
        DeliveryPartner p2 = drepo.findById(id).get();
        orderServices.completedorder(p2.getCurrentorderid());
        p2.setIsfree(Boolean.TRUE);
        p2.setCurrentorderid(0) ;
        drepo.save(p2);
        kp1.Deliverypartnerfree(p2);
        return p2;
    }

    public String active(int id) {
        DeliveryPartner p3 = drepo.findById(id).get();
        p3.setActive(!Boolean.TRUE.equals(p3.getActive()));
        p3.setCurrentorderid(0);
        drepo.save(p3);
        kp1.Deliverypartnerfree(p3);
        return p3.getActive().toString();
    }
}
