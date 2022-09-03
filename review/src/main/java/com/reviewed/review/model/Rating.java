package com.reviewed.review.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
public class Rating {

    private Integer food;

    private Integer ambience;

    private Integer hygiene;

    private Integer staffBehaviour;
}
