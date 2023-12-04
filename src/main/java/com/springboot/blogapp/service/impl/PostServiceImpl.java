package com.springboot.blogapp.service.impl;

import com.springboot.blogapp.entity.Post;
import com.springboot.blogapp.payload.PostDto;
import com.springboot.blogapp.repository.PostRepository;
import com.springboot.blogapp.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    @Override
    public PostDto createPost(PostDto postDto) {

        //convert Dto to entity
        Post post=convertDtoToEntity(postDto);

        Post newpost=postRepository.save(post);

        //convert entity to Dto
        //to show in response
        PostDto postResponse=convertEntityToDto(newpost);

        return postResponse;
    }

    @Override
    public List<PostDto> getAllPosts() {
        List<Post> posts=postRepository.findAll();
        return posts.stream().map(post -> convertEntityToDto(post)).collect(Collectors.toList());
    }

    private Post convertDtoToEntity(PostDto postDto){
        Post post=new Post();
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setDescription(postDto.getDescription());

        return post;
    }

    private PostDto convertEntityToDto(Post post){
        PostDto postResponse=new PostDto();
        postResponse.setId(post.getId());
        postResponse.setTitle(post.getTitle());
        postResponse.setDescription(post.getDescription());
        postResponse.setContent(post.getContent());

        return postResponse;
    }
}