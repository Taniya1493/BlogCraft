package com.springboot.blogapp.service.impl;

import com.springboot.blogapp.config.SecurityConfig;
import com.springboot.blogapp.payload.LoginDto;
import com.springboot.blogapp.service.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private AuthenticationManager authenticationManager;

    public AuthServiceImpl(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public String login(LoginDto loginDto) {
        Authentication authentication=authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getUsernameOrEmail(),loginDto.getPassword()
                ));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return "User logged-in Successfully";
    }
}
