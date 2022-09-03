package com.reviewed.review.repository;

import com.reviewed.review.model.Review;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Integer> {
    @Query(value = "SELECT * FROM review r WHERE r.user_id= :userId AND r.restaurant_id = :restaurantId ",nativeQuery = true)
    public Optional<Review> existsByUserIdAndRestaurantId(@Param("userId") Integer userId,@Param("restaurantId") Integer restaurantId);
}
