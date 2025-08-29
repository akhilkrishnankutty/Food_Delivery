package com.example.Food_Restaurant.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashMap;

@Data
@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rid;
    private String rname;
    private HashMap<String,Integer> rmenu;

}
