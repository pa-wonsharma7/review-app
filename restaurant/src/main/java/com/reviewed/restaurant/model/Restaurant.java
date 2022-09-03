package com.reviewed.restaurant.model;

import com.reviewed.restaurant.enums.Category;
import com.reviewed.restaurant.enums.Cuisine;
import com.reviewed.restaurant.enums.Type;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer restaurantId;

    private String restaurantName;

    @Embedded
    private Address restaurantAddress;

    @Embedded
    private RestaurantRating restaurantRating;

    @Enumerated(EnumType.STRING)
    private Type type;

    @ElementCollection
    @JoinTable(name = "Cuisine", joinColumns = @JoinColumn(name = "restaurant_id"))
    @Enumerated(EnumType.STRING)
    private Set<Cuisine> cuisines = new HashSet<>();

    @Enumerated(EnumType.STRING)
    private Category category;
}
