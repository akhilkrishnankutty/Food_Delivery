package com.example.Food_Restaurant.Repo;

import com.example.Food_Restaurant.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
}
