package com.reviewed.restaurant.service;

import com.reviewed.restaurant.dto.RestaurantDTO;
import com.reviewed.restaurant.enums.Cuisine;
import com.reviewed.restaurant.exceptions.ResourceNotFoundException;
import com.reviewed.restaurant.model.Restaurant;
import com.reviewed.restaurant.repository.RestaurantRepository;
import com.reviewed.restaurant.service.impl.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public RestaurantDTO getRestaurantById(Integer id) {

        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant", "restaurantId", id));
        return mapToDTO(restaurant);
    }

    @Override
    public RestaurantDTO addRestaurant(Restaurant restaurant) {

        Restaurant addedRestaurant = restaurantRepository.save(restaurant);
        return mapToDTO(addedRestaurant);
    }

    @Override
    public List<Restaurant> getAllRestaurant() {
        return restaurantRepository.findAll();
    }

    @Override
    public RestaurantDTO updateRestaurantById(Restaurant restaurant, Integer id) {

        Restaurant restaurant1 = restaurantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant", "restaurantId", id));

        restaurant1.setRestaurantAddress(restaurant.getRestaurantAddress());
        restaurant1.setRestaurantName(restaurant.getRestaurantName());
        restaurant1.setRestaurantRating(restaurant.getRestaurantRating());
        restaurant1.setType(restaurant.getType());
        restaurant1.setCuisines(restaurant.getCuisines());
        restaurant1.setCategory(restaurant.getCategory());
        Restaurant updatedRestaurant = restaurantRepository.save(restaurant1);
        return mapToDTO(updatedRestaurant);
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

    private RestaurantDTO mapToDTO(Restaurant restaurant) {
        RestaurantDTO restaurantDTO = new RestaurantDTO();
        restaurantDTO.setRestaurantId(restaurant.getRestaurantId());
        restaurantDTO.setRestaurantName(restaurant.getRestaurantName());
        restaurantDTO.setRestaurantAddress(restaurant.getRestaurantAddress());
        restaurantDTO.setRating(restaurant.getRestaurantRating());
        restaurantDTO.setType(restaurant.getType().getType());
        restaurantDTO.setCategory(restaurant.getCategory().getCategories());

        Set<Cuisine> cuisines = restaurant.getCuisines();
        Set<String> cuisineStrings = new HashSet<>();
        cuisines.forEach((cuisine -> cuisineStrings.add(cuisine.getCuisines())));
        restaurantDTO.setCuisines(cuisineStrings);
        return restaurantDTO;
    }
}
