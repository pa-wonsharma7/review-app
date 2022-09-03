package com.reviewed.review.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer reviewId;

    private Integer restaurantId;

    private String reviewDescription;

    @Embedded
    private Rating rating;

    private Integer userId;

    private LocalDateTime lastUpdatedDateTime;

    @Embedded
    private List<Comment> comment;

    private Integer likes;

    private Integer dislikes;

}
