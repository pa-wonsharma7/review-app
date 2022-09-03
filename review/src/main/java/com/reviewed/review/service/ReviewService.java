package com.reviewed.review.service;

import com.reviewed.review.model.Review;

import java.util.UUID;

public interface ReviewService {

    /**
     *
     * @param review
     * @return Review
     */
    public Review addReview(Review review);

    /**
     *
     * @param reviewId
     * @return String
     */
    public String deleteSelectedReview(Integer reviewId);

    /**
     *
     * @param review
     * @return Review
     */
    public Review updateSelectedPost(Review review);

    /**
     *
     * @param userId
     * @param restaurantId
     * @return String
     */
    public String deleteReviewByUserIdAndRestaurantId(Integer userId, Integer restaurantId);
}
