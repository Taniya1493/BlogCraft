package com.springboot.blogapp.service;

import com.springboot.blogapp.payload.LoginDto;

public interface AuthService {

    String login(LoginDto loginDto);
}
