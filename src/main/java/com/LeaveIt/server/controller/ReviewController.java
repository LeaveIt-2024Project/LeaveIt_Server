package com.LeaveIt.server.controller;


import com.LeaveIt.server.controller.model.request.ReviewRequest;
import com.LeaveIt.server.controller.model.response.LikeReview;
import com.LeaveIt.server.controller.model.response.ReviewResponse;
import com.LeaveIt.server.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequiredArgsConstructor
public class ReviewController {


    private final ReviewService reviewService;


    @GetMapping("/get/review/{id}")
    public List<ReviewRequest> getReview(
            @PathVariable String id) {

        return reviewService.findReview(id);
    }

    @PostMapping("/save/review")
    public ReviewResponse saveReview(
            @RequestBody ReviewResponse response) {

        return reviewService.saveReview(response);
    }

    @GetMapping("/get/review/count/{id}")
    public int getReviewCount(
            @PathVariable String id){

        return  reviewService.findReviewCount(id);}

    @GetMapping("/get/reviewall")
    public List<ReviewRequest> getReviewAll(){

        return  reviewService.findReviewAll();
    }

    @PostMapping("/save/like/{feedUID}")
    public void  saveReviewLike(@PathVariable String feedUID, @RequestBody LikeReview likeReview){

        reviewService.saveReviewLike(feedUID,likeReview);
    }

    @PostMapping("/cancel/like/{feedUID}")
    public void  cancelReviewLike(@PathVariable String feedUID, @RequestBody LikeReview likeReview){

        reviewService.cancelReviewLike(feedUID,likeReview);
    }
}
