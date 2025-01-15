package com.example.common.config;


import com.example.common.model.response.UserLogin;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import com.example.common.jwt.JwtToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.stream.Collectors;

@Slf4j
@Component
public class JwtTokenProvider {
    private  final Key key;




    public JwtTokenProvider(@Value("${jwt.secret}") String secretKey) {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        this.key = Keys.hmacShaKeyFor(keyBytes);
    }
    public JwtToken createAccessToken(UserLogin login){

        return  generateToken(login);
    }

//    Authentication authentication
    public JwtToken generateToken(UserLogin login) {
        // 권한 가져오기
//        String authorities = authentication.getAuthorities().stream()
//                .map(GrantedAuthority::getAuthority)
//                .collect(Collectors.joining(","));
         Claims claims=Jwts.claims();
         claims.put("loginId",login.getId());
         claims.put("password",login.getPassword());

        long now = (new Date()).getTime();
        // Access Token 생성
        Date accessTokenExpiresIn = new Date(now + 86400000);
        String accessToken = Jwts.builder()
                .setClaims(claims)
                .setExpiration(accessTokenExpiresIn)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
        // Refresh Token 생성
        String refreshToken = Jwts.builder()
                .setExpiration(new Date(now + 86400000))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();

        return JwtToken.builder()
                .grantType("Bearer")
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }
    public  String getUserId(String token){
        return  parseClaims(token).get("loginId",String.class);
    }

    public Authentication getAuthentication(String accessToken) {

        Claims claims = parseClaims(accessToken);
        String username = claims.get("loginId", String.class);
//        log.info(username);
        if (username == null || username.trim().isEmpty()) {
            throw new RuntimeException("유효하지 않은 토큰: 사용자 정보가 없습니다.");
        }

        // 클레임에서 권한 정보 가져오기
        Collection<? extends GrantedAuthority> authorities;
        if (claims.get("auth") != null) {
            authorities = Arrays.stream(claims.get("auth").toString().split(","))
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toList());
        } else {
            // 권한 정보가 없을 경우, 빈 권한 리스트 사용
            authorities = Collections.emptyList();
        }

        // UserDetails 객체 생성
        UserDetails principal = new User(username, "", authorities);

        // UsernamePasswordAuthenticationToken 생성 후 반환
        return new UsernamePasswordAuthenticationToken(principal, "", authorities);
//
//        if (claims.get("auth") == null) {
//            throw new RuntimeException("권한 정보가 없는 토큰입니다.");
//        }
//        String username = Jwts.parser()
//                .setSigningKey(key)
//                .parseClaimsJws(accessToken)
//                .getBody()
//                .getSubject();

        // 권한 정보가 없어도 인증 객체 생성 가능하도록 수정
//        UserDetails principal = new User(claims.getSubject(), "", Collections.emptyList());

        // 권한 없이 UsernamePasswordAuthenticationToken 생성
//        return new UsernamePasswordAuthenticationToken(principal, "", Collections.emptyList());
    }
// 토큰 정보를 검증하는 메서드
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (SecurityException | MalformedJwtException e) {
            log.info("Invalid JWT Token", e);
        } catch (ExpiredJwtException e) {
            log.info("Expired JWT Token", e);
        } catch (UnsupportedJwtException e) {
            log.info("Unsupported JWT Token", e);
        } catch (IllegalArgumentException e) {
            log.info("JWT claims string is empty.", e);
        }
        return false;
    }


    // accessToken
    private Claims parseClaims(String accessToken) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(accessToken)
                    .getBody();
        } catch (ExpiredJwtException e) {
            return e.getClaims();
        }
    }

}
