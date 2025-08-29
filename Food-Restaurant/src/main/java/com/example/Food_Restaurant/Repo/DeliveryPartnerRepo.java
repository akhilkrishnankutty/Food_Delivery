package com.example.Food_Restaurant.Repo;

import com.example.Food_Restaurant.Models.DeliveryPartner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeliveryPartnerRepo extends JpaRepository<DeliveryPartner,Integer> {
    List<DeliveryPartner> findByisfreeTrue();

//    List<DeliveryPartner> findByisfreeTrueAndactiveTrue();

    List<DeliveryPartner> findByIsfreeTrueAndActiveTrue();
}
