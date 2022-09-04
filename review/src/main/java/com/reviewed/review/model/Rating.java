package com.reviewed.review.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
public class Rating {

    private float food;

    private float ambience;

    private float hygiene;

    private float staffBehaviour;
}
