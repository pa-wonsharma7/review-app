package com.reviewed.review.service;

import com.reviewed.review.dto.ReviewPageDTO;
import com.reviewed.review.model.Review;
import com.reviewed.review.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService{

    @Autowired
    ReviewRepository reviewRepository;


    /**
     * Service method for adding a new review
     *
     * @param review
     * @return Review
     */
    @Override
    public Review addReview(Review review) {
        Assert.notNull(review,"Review is null");
        Optional<Review> reviewResponse = reviewRepository.findByUserIdAndRestaurantId(review.getUserId(),review.getRestaurantId());
        if(reviewResponse.isEmpty()){
            review.setLastUpdatedDateTime(LocalDateTime.now());
           return reviewRepository.save(review);
        }else{
            throw new RuntimeException("User has already reviewed this restaurant");
        }
    }

    /**
     * Service Method for deleting a review
     *
     * @param reviewId
     * @return String
     */
    @Override
    public String deleteSelectedReview(Integer reviewId) {
        Assert.notNull(reviewId,"Review Id is null");
        try {
            if(reviewRepository.existsById(reviewId)){
                reviewRepository.deleteById(reviewId);
            }else{
                return "Review does not exists";
            }
        }catch (Exception e){
            System.out.println("Will Handle Later");
        }
        return "Review Deleted Successfully";
    }

    /**
     * Service method for deleting review by UserId and RestaurantId
     *
     * @param userId
     * @param restaurantId
     * @return String
     */
    @Override
    public String deleteReviewByUserIdAndRestaurantId(Integer userId, Integer restaurantId) {
        Assert.notNull(userId,"User Id is null");
        Assert.notNull(restaurantId, "Restaurant Id is null");
        Optional<Review> reviewResponse = reviewRepository.findByUserIdAndRestaurantId(userId,restaurantId);
        try {
            if(reviewResponse.isPresent()){
                reviewRepository.deleteById(reviewResponse.get().getReviewId());
            }else{
                return "Review does not exist for given User Id and Restaurant Id combination" ;
            }
        }catch (Exception e){
            System.out.println("Will Handle Later");
        }
        return "Review with given User Id and Restaurant Id deleted Successfully";
    }

    /**
     * Service method for fetching reviews for a particular restaurant based on restaurant Id
     *
     * @param pageNo
     * @param pageSize
     * @param restaurantId
     * @param sortField
     * @return ReviewPageDto
     */
    @Override
    public ReviewPageDTO fetchReviewByRestaurantId(int pageNo, int pageSize, String sortField, Integer restaurantId) {
        Sort sort = Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Review> reviews = reviewRepository.findByRestaurantId(restaurantId,pageable);
        ReviewPageDTO reviewPageDto = new ReviewPageDTO();
        reviewPageDto.setContent(reviews.getContent());
        reviewPageDto.setTotalElements(reviews.getTotalElements());
        return reviewPageDto;
    }


    /**
     * Service method for fetching reviews given by a user based on user Id
     *
     * @param pageNo
     * @param pageSize
     * @param userId
     * @param sortField
     * @return ReviewPageDto
     */
    @Override
    public ReviewPageDTO fetchReviewByUserId(int pageNo, int pageSize, String sortField, Integer userId) {
        Sort sort = Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Review> reviews = reviewRepository.findByUserId(userId,pageable);
        ReviewPageDTO reviewPageDto = new ReviewPageDTO();
        reviewPageDto.setContent(reviews.getContent());
        reviewPageDto.setTotalElements(reviews.getTotalElements());
        return reviewPageDto;
    }

    /**
     * Service method for fetching reviews for a particular restaurant and a user based on restaurant Id and user Id
     *
     * @param userId
     * @param restaurantId
     * @return
     */
    @Override
    public Review fetchReviewByUserIdAndRestaurantId(Integer userId, Integer restaurantId) {
        Assert.notNull(userId, "User Id is null");
        Assert.notNull(restaurantId, "Restaurant Id is null");
        Optional<Review> reviewResponse = reviewRepository.findByUserIdAndRestaurantId(userId,restaurantId);
    if(reviewResponse.isPresent()){
        return reviewResponse.get();
    }else
       throw new RuntimeException("The review for given restaurant id and user id does not exists ");
    }

    /**
     * Service method for updating a review
     *
     * @param review
     * @return Review
     */
    @Override
    public Review updateSelectedReview(Review review) {
        Assert.notNull(review,"Review is null");
        Optional<Review> reviewResponse = reviewRepository.findByUserIdAndRestaurantId(review.getUserId(), review.getRestaurantId());
        if(reviewResponse.isPresent()){
            reviewResponse.get().setReviewId(review.getReviewId());
            reviewResponse.get().setReviewDescription(review.getReviewDescription());
            reviewResponse.get().setRating(review.getRating());
            reviewResponse.get().setLastUpdatedDateTime(LocalDateTime.now());
         return reviewRepository.save(reviewResponse.get());
        }else{
            throw new RuntimeException("Your review does not exist");
        }
    }
}
