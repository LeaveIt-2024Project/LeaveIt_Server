package com.example.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "likes")
public class Like {

    @Id
    private String id;

    @Column(name = "feeduid")
    private String  feedUID;


    @Column(name = "kakaouid")
    private  String kaKaoUID;

    @Column(name = "useruid")
    private  String userUID;

    @Column(name = "is_liked")
    private Boolean isUserLiked;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

}
