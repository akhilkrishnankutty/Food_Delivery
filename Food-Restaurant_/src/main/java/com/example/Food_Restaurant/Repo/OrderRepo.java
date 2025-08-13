package com.example.Food_Restaurant.Repo;

import com.example.Food_Restaurant.Models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Order,Integer> {
    List<Order> findByrid(int rid);
    List<Order> findByupdate(String s);
}
