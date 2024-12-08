package com.LeaveIt.server.controller;


import com.LeaveIt.server.controller.model.response.ReviewResponse;
import com.LeaveIt.server.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReviewController {


    private  final ReviewService reviewService;



    @PostMapping("/save/review")
    private ReviewResponse saveFeed(
            @RequestBody ReviewResponse response){

      return   reviewService.saveFeed(response);
    }


}
