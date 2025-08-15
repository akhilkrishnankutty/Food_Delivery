package com.example.Food_Restaurant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class  FoodRestaurantApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodRestaurantApplication.class, args);
	}

}
