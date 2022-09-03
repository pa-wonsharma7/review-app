package com.reviewed.review.controller;

import com.reviewed.review.model.Review;
import com.reviewed.review.service.ReviewService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/review")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    /**
     * API for adding a review
     *
     * @param review
     * @return ResponseEntity<Review>
     */
    @PostMapping(value = "/add-review")
    public ResponseEntity<Review> addReview(@RequestBody Review review){
        Review reviewRes = new Review();
        try {
            reviewRes = reviewService.addReview(review);
        }catch (Exception e){
           throw new RuntimeException(e.getMessage());
        }
        return ResponseEntity.ok(reviewRes);
    }

    /**
     * API for deleting a review by review id
     *
     * @param reviewId
     * @return ResponseEntity<String>
     */
    @DeleteMapping(value = "/delete-review/{reviewId}")
    public ResponseEntity<String> deleteReviewById(@PathVariable(name = "reviewId") Integer reviewId) {
        String message = "";
        try {
            message = reviewService.deleteSelectedReview(reviewId);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
        return ResponseEntity.ok(message);
    }

    /**
     * API for deleting review by User id and Restaurant id
     *
     * @param userId
     * @param restaurantId
     * @return String
     */
    @DeleteMapping(value = "/delete-review/{userId}/{restaurantId}")
    public ResponseEntity<String> deleteReviewByUserIdAndRestaurantId(@PathVariable(name = "userId") Integer userId, @PathVariable(name = "restaurantId") Integer restaurantId ) {
        String message = "";
        try {
            message = reviewService.deleteReviewByUserIdAndRestaurantId(userId, restaurantId);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
        return ResponseEntity.ok(message);
    }

    /**
     * API for updating a review
     *
     * @param review
     * @return ResponseEntity<Review>
     */
    @PutMapping(value = "/update-review")
    public ResponseEntity<Review> updatePostById(@RequestBody Review review) {
        Review reviewRes = new Review();
        try {
            reviewRes = reviewService.updateSelectedPost(review);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
        return ResponseEntity.ok(reviewRes);
    }

}
