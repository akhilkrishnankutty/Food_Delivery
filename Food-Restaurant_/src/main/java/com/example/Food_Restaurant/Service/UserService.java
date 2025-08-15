package com.example.Food_Restaurant.Service;

import com.example.Food_Restaurant.Models.User;
import com.example.Food_Restaurant.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;
    public User newuser(User u1) {
        System.out.println(u1);
        return userRepo.save(u1);
    }
}
