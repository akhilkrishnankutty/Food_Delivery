package com.example.Food_Restaurant.Controller;

import com.example.Food_Restaurant.Models.DeliveryPartner;
import com.example.Food_Restaurant.Models.Order;
import com.example.Food_Restaurant.Models.OrderStatus;
import com.example.Food_Restaurant.Repo.DeliveryPartnerRepo;
import com.example.Food_Restaurant.Repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ResetController {
    @Autowired
    OrderRepo orderRepo;
    @Autowired
    DeliveryPartnerRepo deliveryPartnerRepo;
    @GetMapping("/reset")
    public void reset(){
        List<Order> orders = orderRepo.findAll();
        for (Order j:orders){
            j.setStatus(Boolean.TRUE);
            j.setUpdate(OrderStatus.Orderd);
            orderRepo.save(j);

        }

        List<DeliveryPartner> dps = deliveryPartnerRepo.findAll();
        for (DeliveryPartner dp:dps){
            dp.setCurrentorderid(0);
            dp.setActive(Boolean.TRUE);
            dp.setIsfree(Boolean.TRUE);
            deliveryPartnerRepo.save(dp);
        }
    }
}
