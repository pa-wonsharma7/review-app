package com.reviewed.review.repository;

import com.reviewed.review.model.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
    @Query(value = "SELECT * FROM review r WHERE r.user_id= :userId AND r.restaurant_id = :restaurantId ",nativeQuery = true)
    public Optional<Review> findByUserIdAndRestaurantId(@Param("userId") Integer userId,@Param("restaurantId") Integer restaurantId);

    public Page<Review> findByUserId(Integer userId, Pageable pageable);

    public Page<Review> findByRestaurantId(Integer restaurantId, Pageable pageable);
}
