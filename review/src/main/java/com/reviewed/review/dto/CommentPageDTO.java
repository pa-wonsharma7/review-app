package com.reviewed.review.dto;

import com.reviewed.review.model.Comment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentPageDTO {

    private List<Comment> content;
    private long totalElements;
}
