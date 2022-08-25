package com.reviewed.restaurant.service.impl;

import com.reviewed.restaurant.dto.RestaurantDTO;
import com.reviewed.restaurant.model.Restaurant;

import java.util.List;

public interface RestaurantService {

    RestaurantDTO getRestaurantById(Integer id);

    RestaurantDTO addRestaurant(Restaurant restaurant);

    List<Restaurant> getAllRestaurant();

    RestaurantDTO updateRestaurantById(Restaurant restaurant, Integer id);

    void deleteRestaurantById(Integer id);

    void deleteAllRestaurants();
}
