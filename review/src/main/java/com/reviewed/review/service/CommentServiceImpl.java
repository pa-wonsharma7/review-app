package com.reviewed.review.service;

import com.reviewed.review.dto.CommentPageDTO;
import com.reviewed.review.model.Comment;
import com.reviewed.review.model.Review;
import com.reviewed.review.repository.CommentRepository;
import com.reviewed.review.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    ReviewRepository reviewRepository;

    /**
     * Service method for adding a new review
     *
     * @param comment
     * @return Comment
     */
    @Override
    public Comment addComment(Comment comment) {
        Assert.notNull(comment,"Comment is null");
        Optional<Review> reviewResponse = reviewRepository.findById(comment.getReviewId());
        if(reviewResponse.isPresent()){
            comment.setLastUpdatedCommentDateTime(LocalDateTime.now());
            return commentRepository.save(comment);
        }else{
            throw new RuntimeException("Review does not exists");
        }
    }

    /**
     * Service method for fetching comments given on a review based on review id
     *
     * @param pageNo
     * @param pageSize
     * @param sortField
     * @param reviewId
     * @return CommentPageDTO
     */
    @Override
    public CommentPageDTO fetchCommentByReviewId(int pageNo, int pageSize, String sortField, Integer reviewId) {
        Sort sort = Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Comment> comments = commentRepository.findByReviewId(reviewId,pageable);
        CommentPageDTO commentPageDto = new CommentPageDTO();
        commentPageDto.setContent(comments.getContent());
        commentPageDto.setTotalElements(comments.getTotalElements());
        return commentPageDto;
    }

    /**
     * Service method for updating a comment on a review
     *
     * @param comment
     * @return Comment
     */
    @Override
    public Comment updateSelectedComment(Comment comment) {
        Assert.notNull(comment,"Comment is null");
        Optional<Comment> commentResponse = commentRepository.findByUserIdAndReviewIdAndCommentId(comment.getUserId(), comment.getReviewId(), comment.getCommentId());
        if(commentResponse.isPresent()){
            commentResponse.get().setCommentOnReview(comment.getCommentOnReview());
            commentResponse.get().setLastUpdatedCommentDateTime(LocalDateTime.now());
            commentResponse.get().setReviewId(comment.getReviewId());
            return commentRepository.save(commentResponse.get());
        }else{
            throw new RuntimeException("Your comment does not exist");
        }
    }

    /**
     * Service method for deleting a comment based on comment id and user id
     *
     * @param commentId
     * @param userId
     * @return String
     */
    @Override
    public String deleteCommentByCommentIdAndUserId(Integer commentId, Integer userId) {
        Assert.notNull(userId,"User Id is null");
        Assert.notNull(commentId, "Comment Id is null");
        Optional<Comment> commentResponse = commentRepository.findByCommentIdAndUserId(commentId,userId);
        try {
            if(commentResponse.isPresent()){
                reviewRepository.deleteById(commentResponse.get().getCommentId());
            }else{
                return "Comment does not exist for given User Id and Comment Id combination" ;
            }
        }catch (Exception e){
            System.out.println("Will Handle Later");
        }
        return "Review with given User Id and Comment Id deleted Successfully";
    }


}
