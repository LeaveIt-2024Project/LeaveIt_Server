package com.LeaveIt.server.service;

import com.LeaveIt.server.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private  final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {

        return  null;

//        User user=new User();
//
//        return userRepository.findByUserId(id)
//                .orElseThrow(() -> new UsernameNotFoundException(id + " -> 데이터베이스에서 찾을 수 없습니다."));
    }

    private UserDetails createUserDetails(User user) {
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(user.getAuthorities().toString());
        return new User(
                String.valueOf(user.getUsername()),
                user.getPassword(),
                Collections.singleton(grantedAuthority)
        );
    }
}
