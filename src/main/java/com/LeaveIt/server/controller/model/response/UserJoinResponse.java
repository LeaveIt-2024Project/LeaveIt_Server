package com.LeaveIt.server.controller.model.response;

import com.LeaveIt.server.repository.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class UserJoinResponse {

    private String userUID;

    private String id;

    private  String nickname;

    private String password;

    private  String PhoneNumber;

    private LocalDateTime createdAt;





}
