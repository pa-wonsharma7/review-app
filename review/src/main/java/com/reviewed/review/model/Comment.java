package com.reviewed.review.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer commentId;

    @NotNull
    private Integer userId;

    @NotNull
    private String commentOnReview;

    private LocalDateTime lastUpdatedCommentDateTime;

    @NotNull
    private Integer reviewId;
}
