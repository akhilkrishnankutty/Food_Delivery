package com.example.Food_Restaurant.Controller;

import com.example.Food_Restaurant.Models.DeliveryPartner;
import com.example.Food_Restaurant.Service.DeliveryPatnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("partner")
public class DeliveryPartnerController {
    @Autowired
    DeliveryPatnerService deliveryPatnerService;
    @PostMapping("/new")
    public DeliveryPartner savenew(@RequestBody DeliveryPartner dp1){
        return deliveryPatnerService.savennew(dp1);
    }
    @PostMapping("/completed/{id}")
    public DeliveryPartner completed(@PathVariable int id){
        return deliveryPatnerService.completed(id );
    }
    @PostMapping("/active/{id}")
    public String active(@PathVariable int id){
        return deliveryPatnerService.active(id);
    }


}
