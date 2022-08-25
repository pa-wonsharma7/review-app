package com.reviewed.restaurant.controller;

import com.reviewed.restaurant.model.Restaurant;
import com.reviewed.restaurant.service.impl.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping(value = "/{id}")
    public Restaurant getRestaurant(@PathVariable(name = "id") Integer id) {
        return restaurantService.getRestaurantById(id);
    }

    @GetMapping(value = "/")
    public List<Restaurant> allRestaurants() {
        return restaurantService.getAllRestaurant();
    }

    @PostMapping(value = "/")
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantService.addRestaurant(restaurant);
    }

    @PutMapping(value = "/{id}")
    public Restaurant updateRestaurant(@RequestBody Restaurant restaurant, @PathVariable(name = "id") Integer id) {
        return restaurantService.updateRestaurantById(restaurant, id);
    }

    @DeleteMapping(value = "/{id}")
    public String deleteRestaurant(@PathVariable(name = "id") Integer id) {
        restaurantService.deleteRestaurantById(id);
        return "Restaurant with id = " + id + " deleted.";
    }

    @DeleteMapping(value = "/")
    public String deleteRestaurants() {
        restaurantService.deleteAllRestaurants();
        return "Deleted all restaurants.";
    }

}
