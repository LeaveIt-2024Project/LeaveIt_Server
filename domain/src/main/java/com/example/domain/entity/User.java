package com.example.domain.entity;


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


    @Column(name = "created_at")
    private LocalDateTime createdAt;


    @Column(name = "updated_at")
    private LocalDateTime  updatedAt;

    @Column(name = "profile_image")
    @Lob
    private String profileImage;

    @Column(name = "prefer_region")
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
    private UserDetails createUserDetails(User user){
        return User.builder()
                .id(user.getId())
                .password(user.getPassword())
                .build();
    }


}
