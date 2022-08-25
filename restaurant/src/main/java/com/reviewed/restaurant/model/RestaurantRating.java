package com.reviewed.restaurant.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;

@Getter
@Setter
@Embeddable
public class RestaurantRating {

    private Double food;

    private Double ambience;

    private Double hygiene;

    private Double staffBehaviour;
}
