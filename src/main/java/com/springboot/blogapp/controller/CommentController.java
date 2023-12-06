package com.springboot.blogapp.controller;

import com.springboot.blogapp.payload.CommentDto;
import com.springboot.blogapp.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<CommentDto> createComment(@PathVariable(value = "postId") long postId,
                                        @RequestBody CommentDto commentDto){
        return new ResponseEntity<>(commentService.createComment(postId,commentDto)
                , HttpStatus.CREATED);
    }

    @GetMapping("/posts/{postId}/comments")
    public List<CommentDto> getCommentsByPostId(@PathVariable(value = "postId") long postId) {
        return commentService.getCommentsByPostId(postId);
    }

    @GetMapping("/posts/{postId}/comments/{commentId}")
    public ResponseEntity<CommentDto> getCommentById(@PathVariable long postId,
                                                     @PathVariable long commentId) {
        CommentDto commentDto=commentService.getCommentById(postId, commentId);
        return new ResponseEntity<>(commentDto,HttpStatus.OK);
    }

    @PutMapping("/posts/{postId}/comments/{commentId}")
    public ResponseEntity<CommentDto> updateComment(@PathVariable long postId, @PathVariable long commentId, @RequestBody CommentDto commentDto) {
        CommentDto updatedComment=commentService.updateComment(postId, commentId, commentDto);
        return new ResponseEntity<>(updatedComment,HttpStatus.OK);
    }
}
