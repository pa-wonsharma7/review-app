package com.reviewed.restaurant.model;

import lombok.*;

@Getter
@Setter
public class Address {

    private String addressLine;

    private String area;

    private String landmark;

    private String city;

    private String state;

    private Integer postalCode;
}
