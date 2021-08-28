package com.clone.animan.domain;


import com.clone.animan.dto.request.CommentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Getter
public class Comment extends TimeStamped{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long commentId;

    @Column(nullable = false)
    private String commentContents;

    @Column(nullable = false)
    private Long reviewId;

    public Comment(Long reviewId, CommentRequestDto commentRequestDto) {
        this.commentContents = commentRequestDto.getCommentContents();
        this.reviewId = reviewId;
    }

    public void update(CommentRequestDto commentRequestDto) {
        this.commentContents = commentRequestDto.getCommentContents();

    }
}
