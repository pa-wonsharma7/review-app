package com.reviewed.review.controller;

import com.reviewed.review.dto.ReviewPageDto;
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

    /**
     * Pageable API for Fetching Reviews based on restaurant id
     *
     * @param pageNo
     * @param pageSize
     * @param restaurantId
     * @param sortField
     * @return ResponseEntity<ReviewPageDto>
     */
    @GetMapping(value = "/fetch-review/restaurant")
    public  ResponseEntity<ReviewPageDto> getReviewByRestaurantId(
            @RequestParam(required = true) Integer restaurantId,
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "25") int pageSize,
            @RequestParam(defaultValue = "lastUpdatedDateTime") String sortField
           ){
        ReviewPageDto reviewRes = new ReviewPageDto();
        try {
            reviewRes = reviewService.fetchReviewByRestaurantId(pageNo,pageSize,sortField,restaurantId);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
        return ResponseEntity.ok(reviewRes);
    }

    /**
     * Pageable API for Fetching Reviews based on User id
     *
     * @param userId
     * @param pageNo
     * @param pageSize
     * @param sortField
     * @return ResponseEntity<ReviewPageDto>
     */
    @GetMapping(value = "/fetch-review/user")
    public  ResponseEntity<ReviewPageDto> getReviewByUserId(
            @RequestParam(required = true) Integer userId,
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "3") int pageSize,
            @RequestParam(defaultValue = "lastUpdatedDateTime") String sortField
    ){
        ReviewPageDto reviewRes = new ReviewPageDto();
        try {
            reviewRes = reviewService.fetchReviewByUserId(pageNo,pageSize,sortField,userId);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
        return ResponseEntity.ok(reviewRes);
    }

    /**
     * API for Fetching Review based on User id and Restaurant id
     *
     * @param userId
     * @param restaurantId
     * @return ResponseEntity<Review>
     */
    @GetMapping(value = "/fetch-review/user-rest")
    public  ResponseEntity<Review> getReviewByUserIdAndRestaurantId(
            @RequestParam(required = true) Integer userId,
            @RequestParam(required = true) Integer restaurantId
            ){
        Review reviewRes = new Review();
        try {
            reviewRes = reviewService.fetchReviewByUserIdAndRestaurantId(userId,restaurantId);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
        return ResponseEntity.ok(reviewRes);
    }

}
