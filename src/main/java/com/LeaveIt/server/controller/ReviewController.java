package com.LeaveIt.server.controller;


import com.LeaveIt.server.controller.model.request.ReviewRequest;
import com.LeaveIt.server.controller.model.response.ReviewResponse;
import com.LeaveIt.server.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReviewController {


    private  final ReviewService reviewService;


    @GetMapping("/get/review/{id}")
    public List<ReviewRequest> getFeed(
            @PathVariable String id){

        return  reviewService.findFeed(id);
    }

    @PostMapping("/save/review")
    public ReviewResponse saveFeed(
            @RequestBody ReviewResponse response){

      return   reviewService.saveFeed(response);
    }


}
