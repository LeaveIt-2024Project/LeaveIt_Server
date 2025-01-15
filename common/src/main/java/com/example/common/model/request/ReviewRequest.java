package com.example.common.model.request;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ReviewRequest {
    private String  feedUID;

    private String nickname;

    private  String content;

    private String feedImage;

    private  Integer likeCount;

    private  Integer starCount;

    private  String placeArea;

    private  String region;

    private Boolean isUserLiked;

    private LocalDateTime createdAt;

    public ReviewRequest(String feedUID, String nickname, String content, Integer likeCount, String placeArea, Integer starCount, String region, LocalDateTime createdAt) {

        this.feedUID=feedUID;
        this.nickname=nickname;
        this.content=content;
        this.likeCount=likeCount;
        this.placeArea=placeArea;
        this.starCount=starCount;
        this.region=region;
        this.createdAt=createdAt;

    }


}
