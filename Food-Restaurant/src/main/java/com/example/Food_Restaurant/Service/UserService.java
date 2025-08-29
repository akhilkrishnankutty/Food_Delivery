package com.example.Food_Restaurant.Service;

import com.example.Food_Restaurant.Models.User;
import com.example.Food_Restaurant.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);
    public User newuser(User u1) {
        System.out.println(u1);
        u1.setUpassword(bCryptPasswordEncoder.encode(u1.getUpassword()));
        return userRepo.save(u1);
    }
}
