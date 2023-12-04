package com.springboot.blogapp.service.impl;

import com.springboot.blogapp.entity.Post;
import com.springboot.blogapp.payload.PostDto;
import com.springboot.blogapp.repository.PostRepository;
import com.springboot.blogapp.service.PostService;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    @Override
    public PostDto createPost(PostDto postDto) {

        //convert Dto to entity
        Post post=new Post();
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setDescription(postDto.getDescription());

        Post newpost=postRepository.save(post);

        //convert entity to Dto
        //to show in response
        PostDto postResponse=new PostDto();
        postResponse.setId(newpost.getId());
        postResponse.setTitle(newpost.getTitle());
        postResponse.setDescription(newpost.getDescription());
        postResponse.setContent(newpost.getContent());

        return postResponse;
    }
}
