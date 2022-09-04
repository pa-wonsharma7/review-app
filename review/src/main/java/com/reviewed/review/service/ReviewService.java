package com.reviewed.review.service;

import com.reviewed.review.dto.ReviewPageDTO;
import com.reviewed.review.model.Review;

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
    public Review updateSelectedReview(Review review);

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
     * @param sortField
     * @return ReviewPageDto
     */
    public ReviewPageDTO fetchReviewByRestaurantId (int pageNo, int pageSize, String sortField, Integer restaurantId);

    /**
     * Service method for fetching reviews given by a user based on user Id
     *
     * @param pageNo
     * @param pageSize
     * @param userId
     * @param sortField
     * @return ReviewPageDto
     */
    public ReviewPageDTO fetchReviewByUserId(int pageNo, int pageSize, String sortField, Integer userId);

    /**
     * Service method for fetching reviews for a particular restaurant and a user based on restaurant Id and user Id
     *
     * @param userId
     * @param restaurantId
     * @return Review
     */
    public Review fetchReviewByUserIdAndRestaurantId(Integer userId, Integer restaurantId);

}
