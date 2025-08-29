package com.example.Food_Restaurant.Repo;

import com.example.Food_Restaurant.Models.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepo extends JpaRepository<Restaurant,Integer> {
}
