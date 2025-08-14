package com.example.Food_Restaurant.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class DeliveryPartner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dpid;
    private String dpname;
    private Boolean active;
    private Boolean isfree;
    private int currentorderid;

}
