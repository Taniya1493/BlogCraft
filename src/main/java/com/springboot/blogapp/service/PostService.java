package com.springboot.blogapp.service;

import com.springboot.blogapp.payload.PostDto;
import com.springboot.blogapp.payload.PostResponse;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto postDto);

    PostResponse getAllPosts(int pageNo, int pageSize,String sortBy,String sortDir);

    PostDto getPostById(Long id);

    PostDto updatePost(PostDto postDto,Long id);

    void deletePostById(Long id);

    List<PostDto> getPostByCategory(Long categoryId);
}
