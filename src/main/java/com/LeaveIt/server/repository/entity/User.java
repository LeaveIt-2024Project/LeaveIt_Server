package com.LeaveIt.server.repository.entity;


import com.LeaveIt.server.controller.model.response.UserJoin;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.stream.Collectors;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "user")
public class User  implements UserDetails {



    @Id
    private String userUID;


    private String id;

    private  String nickname;

    private String password;

    @Column(name = "phonenumber")
    private  String phoneNumber;


    @Column(name = "createdat")
    private LocalDateTime createdAt;


    @Column(name = "updatedat")
    private LocalDateTime  updatedAt;

    @Column(name = "profileimage")
    @Lob
    private String profileImage;

    @Column(name = "preferregion")
    private String preferRegion;

    @Column(name = "lastlogin")
    private LocalDateTime lastLogin;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {

        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    @Override
    public String getUsername() {

        return userUID;
    }


}
