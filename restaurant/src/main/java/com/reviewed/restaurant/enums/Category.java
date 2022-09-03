package com.reviewed.restaurant.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Category {

    RESTAURANT("Restaurant/Dine-In"),
    STALL("Food-Stall/Dine-In"),
    OUTLET("Outlet");

    private final String categories;
}
