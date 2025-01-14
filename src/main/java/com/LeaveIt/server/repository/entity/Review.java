package com.LeaveIt.server.repository.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "review")
public class Review {

    @Id
    @Column(name = "feeduid")
    private String  feedUID;


    @Column(name = "kakaouid")
    private  String kaKaoUID;

    @Column(name = "useruid")
    private  String userUID;

    private String nickname;

    private  String content;


    private  String region;


    @Column(name = "feedimage")
    private String feedImage;

    @Column(name = "like_count")
    private  Integer likeCount;

    @Column(name = "star_count")
    private  Integer starCount;

    @Column(name = "place_area")
    private  String placeArea;

    @Column(name = "is_user_liked")
    private Boolean isUserLiked;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
