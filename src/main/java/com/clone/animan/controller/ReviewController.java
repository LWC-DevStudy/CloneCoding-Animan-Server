package com.clone.animan.controller;


import com.clone.animan.domain.Review;
import com.clone.animan.dto.request.ReviewRequestDto;
import com.clone.animan.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/review")
    public Page<Review> getReviewPage(
            @RequestParam("page") int page,
            @RequestParam("size") int size
    ){
        return reviewService.getReviewPage(page,size);
    }


    @GetMapping("review/{reviewId}")
    public Review getReview(@PathVariable(name = "reviewId") Long reviewId){

        return reviewService.getReview(reviewId);

    }

    @PostMapping("/review")
    public Review createReview(@RequestBody ReviewRequestDto reviewRequestDto){

        return reviewService.createReview(reviewRequestDto);
    }

    @PutMapping("/review/{reviewId}")
    public Long editReview(@RequestBody ReviewRequestDto reviewRequestDto, @PathVariable Long reviewId){
        return reviewService.editReview(reviewRequestDto,reviewId);
    }

    @DeleteMapping("/review/{reviewId}")
    public void editReview(@PathVariable Long reviewId){
        reviewService.deleteReview(reviewId);
    }


}
