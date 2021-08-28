package com.clone.animan.domain;

import com.clone.animan.dto.request.ReviewRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Review extends TimeStamped{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long reviewId;


    @Column(nullable = true)
    private String reviewImage;

    @Column(nullable = false)
    private String reviewContents;

    public Review(ReviewRequestDto reviewRequestDto) {
        this.reviewImage = reviewRequestDto.getReviewImage();
        this.reviewContents = reviewRequestDto.getReviewContents();
    }

    public void update(ReviewRequestDto reviewRequestDto) {

        this.reviewImage = reviewRequestDto.getReviewImage();
        this.reviewContents = reviewRequestDto.getReviewContents();
    }
}
