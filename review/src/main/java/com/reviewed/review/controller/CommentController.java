package com.reviewed.review.controller;

import com.reviewed.review.dto.CommentPageDTO;
import com.reviewed.review.model.Comment;
import com.reviewed.review.model.Review;
import com.reviewed.review.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    /**
     * API for adding a comment to a review
     *
     * @param comment
     * @return ResponseEntity<Comment>
     */
    @PostMapping(value = "/add-comment")
    public ResponseEntity<Comment> addComment(@RequestBody Comment comment){
        Comment commentRes = new Comment();
        try {
            commentRes = commentService.addComment(comment);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
        return ResponseEntity.ok(commentRes);
    }

    /**
     * Pageable API for Fetching Comments based on Review id
     *
     * @param reviewId
     * @param pageNo
     * @param pageSize
     * @param sortField
     * @return ResponseEntity<CommentPageDTO>
     */
    @GetMapping(value = "/fetch-comment/")
    public  ResponseEntity<CommentPageDTO> getCommentByReviewId(
            @RequestParam(required = true) Integer reviewId,
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "3") int pageSize,
            @RequestParam(defaultValue = "lastUpdatedDateTime") String sortField
    ){
        CommentPageDTO commentRes = new CommentPageDTO();
        try {
            commentRes = commentService.fetchCommentByReviewId(pageNo,pageSize,sortField,reviewId);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
        return ResponseEntity.ok(commentRes);
    }

    /**
     * API for updating a comment on a review
     *
     * @param comment
     * @return ResponseEntity<Comment>
     */
    @PutMapping(value = "/update-comment")
    public ResponseEntity<Comment> updateComment(@RequestBody Comment comment) {
        Comment commentRes = new Comment();
        try {
            commentRes = commentService.updateSelectedComment(comment);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return ResponseEntity.ok(commentRes);
    }

    /**
     * API for deleting a comment by comment id
     *
     * @param commentId
     * @return ResponseEntity<String>
     */
    @DeleteMapping(value = "/delete-comment/{commentId}/{userId}")
    public ResponseEntity<String> deleteCommentById(@PathVariable(name = "commentId") Integer commentId, @PathVariable(name = "userId") Integer userId) {
        String message = "";
        try {
            message = commentService.deleteCommentByCommentIdAndUserId(commentId,userId);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
        return ResponseEntity.ok(message);
    }

    }
