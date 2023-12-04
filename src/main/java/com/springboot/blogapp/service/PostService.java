package com.springboot.blogapp.service;

import com.springboot.blogapp.payload.PostDto;

public interface PostService {

    PostDto createPost(PostDto postDto);
}
