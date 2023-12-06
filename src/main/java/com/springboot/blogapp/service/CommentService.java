package com.springboot.blogapp.service;

import com.springboot.blogapp.payload.CommentDto;

public interface CommentService {

    CommentDto createComment(long postId,CommentDto commentDto);
}
