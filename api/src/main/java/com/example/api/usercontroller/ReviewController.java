package com.example.api.usercontroller;


import com.example.common.config.S3Uploader;
import com.example.common.model.request.ReviewRequest;
import com.example.common.model.response.LikeReview;
import com.example.common.model.response.ReviewResponse;

import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.domain.userservice.ReviewService;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ReviewController {


    private final ReviewService reviewService;

    private final S3Uploader s3Uploader;


    @GetMapping("/get/review/{id}")
    public List<ReviewRequest> getReview(
            @PathVariable String id) {

        return reviewService.findReview(id);
    }

    @PostMapping("/save/review")
    public ReviewResponse saveReview(
            @RequestParam(required = false, value = "imageFiles") MultipartFile file,
            @RequestBody ReviewResponse response) throws IOException {
        if (file != null && !file.isEmpty()) {
            log.info("File upload started");
            response.setFeedImage(s3Uploader.upload(file,response.getFeedUID()));
        }

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
