package com.reviewed.restaurant.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reviewed.restaurant.exceptions.ResourceNotFoundException;
import com.reviewed.restaurant.model.Restaurant;
import com.reviewed.restaurant.repository.RestaurantRepository;
import com.reviewed.restaurant.service.impl.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public Restaurant getRestaurantById(Integer id) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant", "restaurantId", id));
        return restaurant;
    }

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
        Restaurant restaurant1 = restaurantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant", "restaurantId", id));

        restaurant1.setRestaurantAddress(restaurant.getRestaurantAddress());
        restaurant1.setRestaurantName(restaurant.getRestaurantName());
        restaurant1.setRestaurantRating(restaurant.getRestaurantRating());
        restaurant1.setType(restaurant.getType());
        restaurant1.setCuisines(restaurant.getCuisines());
        restaurant1.setCategory(restaurant.getCategory());
        return restaurantRepository.save(restaurant1);
    }

    @Override
    public void deleteRestaurantById(Integer id) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant", "restaurantId", id));
        restaurantRepository.delete(restaurant);
    }

    @Override
    public void deleteAllRestaurants() {
        restaurantRepository.deleteAll();
    }
}
