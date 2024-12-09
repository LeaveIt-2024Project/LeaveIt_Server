package com.LeaveIt.server.repository.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
<<<<<<< HEAD
import lombok.Getter;
=======
>>>>>>> 18-feat-리뷰-등록-구현-jwt-기능-구체화
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Builder
<<<<<<< HEAD
@Getter
=======
>>>>>>> 18-feat-리뷰-등록-구현-jwt-기능-구체화
@Entity
@Table(name = "review")
public class Review {

    @Id
    @Column(name = "feeduid")
    private String  feedUID;

<<<<<<< HEAD

    @Column(name = "kakaouid")
    private  String kaKaoUID;

    @Column(name = "useruid")
    private  String userUID;

=======
>>>>>>> 18-feat-리뷰-등록-구현-jwt-기능-구체화
    private String nickname;

    private  String content;

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
