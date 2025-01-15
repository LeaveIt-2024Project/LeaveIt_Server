package com.example.api.controller;


import com.example.common.model.request.ReviewRequest;
import com.example.common.model.response.LikeReview;
import com.example.common.model.response.ReviewResponse;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.domain.service.ReviewService;

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

    @GetMapping("/get/review/region/{region}")
    public Page<ReviewRequest> getReviewRegion(@PageableDefault(page = 0, size = 10) Pageable pageable, @PathVariable String region){

        return  reviewService.findReviewRegionAll(region,pageable);
    }

    @GetMapping("/get/review/region/latest/{region}")
    public Page<ReviewRequest> getReviewLatestRegion(@PageableDefault(page = 0, size = 10) Pageable pageable, @PathVariable String region){

        return  reviewService.findReviewLatestRegion(region,pageable);
    }

    @GetMapping("/get/review/region/like/rank/{region}")
    public Page<ReviewRequest> getReviewLikeDESCRegion(@PageableDefault(page = 0, size = 10) Pageable pageable, @PathVariable String region){

        return  reviewService.findReviewLikeDESCRegion(region,pageable);
    }

    @GetMapping("/get/review/region/star/rank/{region}")
    public Page<ReviewRequest> getReviewStarDESCRegion(@PageableDefault(page = 0, size = 10) Pageable pageable, @PathVariable String region){

        return  reviewService.findReviewStarDESCRegion(region,pageable);
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
