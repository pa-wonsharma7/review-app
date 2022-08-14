package com.reviewed.restaurant.model;

import lombok.*;

import javax.persistence.*;

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

    @Enumerated(EnumType.STRING)
    private Cuisine cuisine;
}
