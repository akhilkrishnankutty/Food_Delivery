package com.example.Food_Restaurant.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
@Data
@Entity
@Table(name = "orders")
public class Order {
//    Enum status {};
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int oid;
    private Boolean status;
    private String update;
    private int cid;
    private int rid;
    private ArrayList<String> items;

}
