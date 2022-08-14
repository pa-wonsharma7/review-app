package com.reviewed.restaurant.model;

import lombok.*;

import javax.persistence.Embeddable;

@Getter
@Setter
@Embeddable
public class Address {

    private String addressLine;

    private String area;

    private String landmark;

    private String city;

    private String country;

    private Integer postalCode;
}
