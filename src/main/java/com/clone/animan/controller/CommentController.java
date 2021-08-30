package com.clone.animan.controller;


import com.clone.animan.domain.Comment;
import com.clone.animan.dto.request.CommentRequestDto;
import com.clone.animan.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/comment/{reviewId}")
    public Comment createComment(@PathVariable(name = "reviewId") Long reviewId, @RequestBody CommentRequestDto commentRequestDto){

        return commentService.createComment(reviewId,commentRequestDto);

    }

    @GetMapping("/comment/{reviewId}")
    public List<Comment> getComment(@PathVariable Long reviewId){
        return commentService.getComment(reviewId);
    }

    @PutMapping("/comment/{commentId}")
    public Long editComment(@PathVariable Long commentId,
             @RequestBody CommentRequestDto commentRequestDto){
        return commentService.editComment(commentId, commentRequestDto);
    }

    @DeleteMapping("/comment/{commentId}")
    public void deleteComment(@PathVariable Long commentId){
        commentService.deleteComment(commentId);
    }

}
