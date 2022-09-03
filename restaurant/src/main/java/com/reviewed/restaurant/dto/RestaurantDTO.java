package com.reviewed.restaurant.dto;

import com.reviewed.restaurant.enums.Cuisine;
import com.reviewed.restaurant.enums.Type;
import com.reviewed.restaurant.model.Address;
import com.reviewed.restaurant.model.RestaurantRating;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class RestaurantDTO {

    private Integer restaurantId;

    private String restaurantName;

    private Address restaurantAddress;

    private RestaurantRating rating;

    private String type;

    private Set<String> cuisines = new HashSet<>();

    private String category;
}
