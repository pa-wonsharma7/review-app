package com.reviewed.restaurant.service;

import com.reviewed.restaurant.model.Restaurant;
import com.reviewed.restaurant.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService{

    @Autowired
    RestaurantRepository restaurantRepository;

    @Override
    public Restaurant addRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public List<Restaurant> getAllRestaurant() {
        return restaurantRepository.findAll();
    }

    @Override
    public Restaurant updateRestaurantById(Restaurant restaurant, Integer id) {
        Restaurant restaurant1 = restaurantRepository.findById(id).orElseThrow(() -> new RuntimeException());
        restaurant1.setRestaurantAddress(restaurant.getRestaurantAddress());
        restaurant1.setRestaurantName(restaurant.getRestaurantName());
        restaurant1.setRestaurantRating(restaurant.getRestaurantRating());
        restaurant1.setType(restaurant.getType());
        restaurant1.setCuisine(restaurant.getCuisine());
        return restaurantRepository.save(restaurant1);
    }

    @Override
    public void deleteRestaurantById(Integer id) {
        restaurantRepository.deleteById(id);
    }

    @Override
    public void deleteAllRestaurants() {
        restaurantRepository.deleteAll();
    }
}
