package com.reviewed.restaurant.controller;

import com.reviewed.restaurant.dto.RestaurantDTO;
import com.reviewed.restaurant.model.Restaurant;
import com.reviewed.restaurant.service.impl.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<RestaurantDTO> getRestaurant(@PathVariable(name = "id") Integer id) {
        RestaurantDTO restaurantDTO = restaurantService.getRestaurantById(id);
        return new ResponseEntity<>(restaurantDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/")
    public List<Restaurant> allRestaurants() {
        return restaurantService.getAllRestaurant();
    }

    @PostMapping(value = "/")
    public ResponseEntity<RestaurantDTO> addRestaurant(@RequestBody Restaurant restaurant) {
        return new ResponseEntity<>(restaurantService.addRestaurant(restaurant), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<RestaurantDTO> updateRestaurant(@RequestBody Restaurant restaurant, @PathVariable(name = "id") Integer id) {
        return new ResponseEntity<>(restaurantService.updateRestaurantById(restaurant, id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteRestaurant(@PathVariable(name = "id") Integer id) {
        restaurantService.deleteRestaurantById(id);
        return new ResponseEntity<>("Restaurant with id = " + id + " deleted successfully.", HttpStatus.OK) ;
    }

    @DeleteMapping(value = "/")
    public ResponseEntity<String> deleteAllRestaurants() {
        restaurantService.deleteAllRestaurants();
        return ResponseEntity.ok("All restaurants deleted successfully.");
    }

}
