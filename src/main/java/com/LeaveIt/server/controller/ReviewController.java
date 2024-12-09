package com.LeaveIt.server.controller;


<<<<<<< HEAD
import com.LeaveIt.server.controller.model.request.ReviewRequest;
=======
>>>>>>> 18-feat-리뷰-등록-구현-jwt-기능-구체화
import com.LeaveIt.server.controller.model.response.ReviewResponse;
import com.LeaveIt.server.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.*;

import java.util.List;
=======
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
>>>>>>> 18-feat-리뷰-등록-구현-jwt-기능-구체화

@RestController
@RequiredArgsConstructor
public class ReviewController {


    private  final ReviewService reviewService;


<<<<<<< HEAD
    @GetMapping("/get/review/{id}")
    public List<ReviewRequest> getFeed(
            @PathVariable String id){

        return  reviewService.findFeed(id);
    }

    @PostMapping("/save/review")
    public ReviewResponse saveFeed(
=======

    @PostMapping("/save/review")
    private ReviewResponse saveFeed(
>>>>>>> 18-feat-리뷰-등록-구현-jwt-기능-구체화
            @RequestBody ReviewResponse response){

      return   reviewService.saveFeed(response);
    }


}
