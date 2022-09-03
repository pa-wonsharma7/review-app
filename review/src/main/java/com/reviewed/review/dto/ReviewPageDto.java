package com.reviewed.review.dto;

import com.reviewed.review.model.Review;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewPageDto {

    private List<Review> content;
    private long totalElements;

}
