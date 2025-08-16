package com.example.Food_Restaurant.Service;

import com.example.Food_Restaurant.Models.User;
import com.example.Food_Restaurant.Repo.UserRepo;
import com.example.Food_Restaurant.Security.UserDetailsProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    @Autowired
    UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User u1 = userRepo.findByuname(username);
        if (u1==null){
            throw new UsernameNotFoundException("no user");
        }

        return new UserDetailsProvider(u1);
    }
}
