package com.reviewed.review.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
public class Comment {

    private String commentOnReview;

    private Integer likes;

    private Integer dislikes;
}
