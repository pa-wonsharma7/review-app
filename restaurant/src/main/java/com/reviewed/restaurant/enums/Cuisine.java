package com.reviewed.restaurant.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public enum Cuisine {

    // TODO try to make this embeddable rather than a totally different table

    SOUTH_INDIAN("South-Indian"),
    CHINESE("Chinese"),
    ITALIAN("Italian"),
    NORTH_INDIAN("North-Indian"),
    FAST_FOOD("Fast-Food"),
    DESSERTS("Desserts"),
    BAKERY("Bakery"),
    MUGHLAI("Mughlai"),
    SHAKES("Shakes"),
    MITHAI("Mithai"),
    SICHUAN("Sichuan"),
    CONTINENTAL("Continental"),
    FRENCH("French"),
    JAPANESE("Japanese");

    private final String cuisines;

    Cuisine(String cuisines) {
        this.cuisines = cuisines;
    }
}
