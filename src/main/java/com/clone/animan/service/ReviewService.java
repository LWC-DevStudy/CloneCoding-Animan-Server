package com.clone.animan.service;

import com.clone.animan.domain.Review;
import com.clone.animan.dto.request.ReviewRequestDto;
import com.clone.animan.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public Page<Review> getReviewPage(int page, int size) {
        Pageable pageable = PageRequest.of(page,size);

        return reviewRepository.findAllByOrderByCreatedAtDesc(pageable);

    }

    public Review getReview(Long reviewId) {

        return reviewRepository.findById(reviewId).orElseThrow(
                ()-> new NullPointerException("해당 리뷰가 없습니다.")
        );
    }

    public Review createReview(ReviewRequestDto reviewRequestDto) {

        Review review = new Review(reviewRequestDto);
        reviewRepository.save(review);
        return review;
    }

    @Transactional
    public Long editReview(ReviewRequestDto reviewRequestDto, Long reviewId) {

        Review review = reviewRepository.findById(reviewId).orElseThrow(
                ()-> new NullPointerException("해당 리뷰가 없습니다.")
        );

        review.update(reviewRequestDto);
        return review.getReviewId();
    }

    public void deleteReview(Long reviewId) {

        reviewRepository.deleteById(reviewId);
    }
}
