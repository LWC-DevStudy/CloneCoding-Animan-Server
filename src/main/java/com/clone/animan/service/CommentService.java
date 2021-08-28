package com.clone.animan.service;

import com.clone.animan.domain.Comment;
import com.clone.animan.dto.request.CommentRequestDto;
import com.clone.animan.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;


    public Comment createComment(Long reviewId, CommentRequestDto commentRequestDto) {

        Comment comment = new Comment(reviewId,commentRequestDto);
        return commentRepository.save(comment);
    }


    public List<Comment> getComment(Long reviewId) {

        return commentRepository.findAllByReviewId(reviewId);
    }


    @Transactional
    public Long editComment(Long commentId, CommentRequestDto commentRequestDto) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(
                ()-> new NullPointerException("해당 댓글이 없습니다.")
        );

        comment.update(commentRequestDto);
        return comment.getCommentId();
    }

    public void deleteComment(Long commentId) {

        commentRepository.deleteById(commentId);
    }
}
