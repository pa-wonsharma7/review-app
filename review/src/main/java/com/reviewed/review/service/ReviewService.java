package com.reviewed.review.service;

import com.reviewed.review.dto.ReviewPageDto;
import com.reviewed.review.model.Review;

import java.util.UUID;

public interface ReviewService {

    /**
     * Service method for adding a new review
     *
     * @param review
     * @return Review
     */
    public Review addReview(Review review);

    /**
     * Service method for deleting a review based on review Id
     *
     * @param reviewId
     * @return String
     */
    public String deleteSelectedReview(Integer reviewId);

    /**
     * Service method for updating a review
     *
     * @param review
     * @return Review
     */
    public Review updateSelectedPost(Review review);

    /**
     *
     * Service method for deleting a review based on user Id and restaurant Id
     *
     * @param userId
     * @param restaurantId
     * @return String
     */
    public String deleteReviewByUserIdAndRestaurantId(Integer userId, Integer restaurantId);

    /**
     * Service method for fetching reviews for a particular restaurant based on restaurant Id
     *
     * @param pageNo
     * @param pageSize
     * @param restaurantId
     * @return ReviewPageDto
     */
    public ReviewPageDto fetchReviewByRestaurantId (int pageNo,int pageSize, Integer restaurantId);

    /**
     * Service method for fetching reviews given by a user based on user Id
     *
     * @param pageNo
     * @param pageSize
     * @param userId
     * @return ReviewPageDto
     */
    public ReviewPageDto fetchReviewByUserId(int pageNo,int pageSize,Integer userId);

    /**
     * Service method for fetching reviews for a particular restaurant and a user based on restaurant Id and user Id
     *
     * @param userId
     * @param restaurantId
     * @return Review
     */
    public Review fetchReviewByUserIdAndRestaurantId(Integer userId, Integer restaurantId);

}
