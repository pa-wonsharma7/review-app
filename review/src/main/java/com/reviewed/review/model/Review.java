package com.reviewed.review.model;

import com.sun.istack.NotNull;
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

    @NotNull
    private Integer restaurantId;

    private String reviewDescription;

    @Embedded
    private Rating rating;

    @NotNull
    private Integer userId;

    private LocalDateTime lastUpdatedDateTime;

}
