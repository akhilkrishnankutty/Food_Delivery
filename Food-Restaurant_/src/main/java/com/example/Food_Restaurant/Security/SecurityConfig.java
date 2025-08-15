package com.example.Food_Restaurant.Security;

import com.example.Food_Restaurant.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private usersec userservice;
    @Bean
    public AuthenticationProvider auth(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userservice);
        provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
        return provider;
    }
    @Bean
    public SecurityFilterChain sec(HttpSecurity ht) throws Exception {
        ht.csrf(customobject-> customobject.disable());
        ht.authorizeHttpRequests(auth->auth.anyRequest().authenticated());
        //ht.formLogin(Customizer.withDefaults());
        ht.httpBasic(Customizer.withDefaults());
        ht.sessionManagement(ss->ss.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        return ht.build();
    }
}
