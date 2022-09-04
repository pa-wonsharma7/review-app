package com.reviewed.review.service;

import com.reviewed.review.dto.CommentPageDTO;
import com.reviewed.review.dto.ReviewPageDTO;
import com.reviewed.review.model.Comment;
import com.reviewed.review.model.Review;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface CommentService {

    /**
     * Service method for adding a new comment to a review
     *
     * @param comment
     * @return Comment
     */
    public Comment addComment(Comment comment);

    /**
     * Service method for fetching comments given on a review based on review Id
     *
     * @param pageNo
     * @param pageSize
     * @param reviewId
     * @param sortField
     * @return CommentPageDTO
     */
    public CommentPageDTO fetchCommentByReviewId(int pageNo, int pageSize, String sortField, Integer reviewId);

    /**
     * Service method for updating a comment on a review
     *
     * @param comment
     * @return Comment
     */
    public Comment updateSelectedComment(Comment comment);

    /**
     *
     * Service method for deleting a comment based on comment Id and user Id
     *
     * @param commentId
     * @param userId
     * @return String
     */
    public String deleteCommentByCommentIdAndUserId(Integer commentId, Integer userId);

    }
