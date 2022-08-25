package com.reviewed.restaurant;

import com.reviewed.restaurant.enums.Cuisine;
import com.reviewed.restaurant.enums.Type;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class RestaurantApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantApplication.class, args);

//		Cuisine[] cuisines = Cuisine.values();
//		Arrays.stream(cuisines).sequential().forEach((cuisine) -> System.out.println(cuisine.getCuisines()));
	}
}
