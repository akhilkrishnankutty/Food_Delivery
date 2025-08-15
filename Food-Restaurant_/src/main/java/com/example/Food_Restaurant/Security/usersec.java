package com.example.Food_Restaurant.Security;

import com.example.Food_Restaurant.Models.User;
import com.example.Food_Restaurant.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class usersec implements UserDetailsService {
        @Autowired
        private UserRepo repo1;
        private BCryptPasswordEncoder encode = new BCryptPasswordEncoder(12);
        public List<User> getuserFromRepo(){
            return (List<User>) repo1.findAll();
        }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return (UserDetails) repo1.findAll();
    }
//        public User saveusertorepo(User us){
//            us.setPassword(encode.encode(us.getPassword()));
//            return repo1.save(us);
//        }
    }
