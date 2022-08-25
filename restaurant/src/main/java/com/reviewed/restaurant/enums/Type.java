package com.reviewed.restaurant.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Type {
    VEG("Veg"),
    NON_VEG("Non-Veg");

    private final String type;
}
