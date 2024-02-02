package com.springboot.blogapp.controller;

import com.springboot.blogapp.payload.PostDto;
import com.springboot.blogapp.payload.PostResponse;
import com.springboot.blogapp.service.PostService;
import com.springboot.blogapp.utils.AppConstants;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    //create a blog post
    @SecurityRequirement(
            name = "Bear Authentication"
    )
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<PostDto> createPost(@Valid @RequestBody PostDto postDto){
        return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
    }

    @GetMapping
    public PostResponse getAllPosts(
            @RequestParam(value = "pageNo",defaultValue = AppConstants.DEFAULT_PAGE_NO,required = false) int pageNo,
            @RequestParam(value = "pageSize",defaultValue = AppConstants.DEFAULT_PAGE_SIZE,required = false)int pageSize,
            @RequestParam(value = "sortBy",defaultValue = AppConstants.DEFAULT_SORT_BY,required = false)String sortBy,
            @RequestParam(value = "sortDir",defaultValue = AppConstants.DEFAULT_SORT_DIR,required = false)String sortDir
    ){
        return postService.getAllPosts(pageNo,pageSize,sortBy,sortDir);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable long id){
        return ResponseEntity.ok(postService.getPostById(id));
    }

    @SecurityRequirement(
            name = "Bear Authentication"
    )
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost(@Valid @RequestBody PostDto postDto, @PathVariable Long id) {
        PostDto postResponse=postService.updatePost(postDto,id);
        return new ResponseEntity<>(postResponse,HttpStatus.OK);
    }

    @SecurityRequirement(
            name = "Bear Authentication"
    )
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePostById(@PathVariable Long id){
        postService.deletePostById(id);
        return new ResponseEntity<>("Post Deleted Successfully",HttpStatus.OK);
    }

    //Build Get Post By Category Rest Api
    @GetMapping("/category/{id}")
    public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable("id") Long categoryId) {
        List<PostDto> postDtos=postService.getPostByCategory(categoryId);
        return ResponseEntity.ok(postDtos);
    }
}
