package com.reviewed.review.repository;

import com.reviewed.review.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommentRepository  extends JpaRepository<Comment, Integer> {

    public Page<Comment> findByReviewId(Integer reviewId, Pageable pageable);

    @Query(value = "SELECT * FROM comment r WHERE r.user_id= :userId AND r.review_id = :reviewId AND r.commentId = :commentId ",nativeQuery = true)
    public Optional<Comment> findByUserIdAndReviewIdAndCommentId(Integer userId, Integer reviewId, Integer commentId);

    @Query(value = "SELECT * FROM comment r WHERE r.commentId = :commentId AND r.user_id= :userId ",nativeQuery = true)
    public Optional<Comment> findByCommentIdAndUserId(Integer commentId, Integer userId);
}
