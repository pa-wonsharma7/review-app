package com.reviewed.restaurant.service;

import com.reviewed.restaurant.model.Restaurant;

import java.util.List;

public interface RestaurantService {

    Restaurant addRestaurant(Restaurant restaurant);

    List<Restaurant> getAllRestaurant();

    Restaurant updateRestaurantById(Restaurant restaurant, Integer id);

    void deleteRestaurantById(Integer id);

    void deleteAllRestaurants();
}
