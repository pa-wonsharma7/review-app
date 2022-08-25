package com.reviewed.restaurant.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public enum Type {
    VEG("Veg"),
    NON_VEG("Non-Veg");

    private final String type;

    Type(String type) {
        this.type = type;
    }
}
