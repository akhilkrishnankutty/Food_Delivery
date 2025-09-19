package com.example.Food_Restaurant.Controller;

import com.example.Food_Restaurant.Models.User;
import com.example.Food_Restaurant.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
//@PreAuthorize("hasAnyRole('Admin','Customer')")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/new")
    public User newuser(@RequestBody User u1){
        return userService.newuser(u1);
    }
}
