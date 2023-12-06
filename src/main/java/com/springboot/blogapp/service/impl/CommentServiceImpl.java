package com.springboot.blogapp.service.impl;

import com.springboot.blogapp.entity.Comment;
import com.springboot.blogapp.entity.Post;
import com.springboot.blogapp.exception.BlogAPIException;
import com.springboot.blogapp.exception.ResourceNotFoundException;
import com.springboot.blogapp.payload.CommentDto;
import com.springboot.blogapp.payload.PostDto;
import com.springboot.blogapp.repository.CommentRepository;
import com.springboot.blogapp.repository.PostRepository;
import com.springboot.blogapp.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private PostRepository postRepository;

    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @Override
    public CommentDto createComment(long postId, CommentDto commentDto) {

        Comment comment=convertDtoToEntity(commentDto);
        //retrieve post entity by id
        Post post=postRepository.findById(postId).orElseThrow(
                () -> new ResourceNotFoundException("Post","id",postId));

        //set post to comment entity
        comment.setPost(post);

        //save comment entity to db
        Comment newComment=commentRepository.save(comment);

        return convertEntityToDto(newComment);
    }

    @Override
    public List<CommentDto> getCommentsByPostId(long postId) {
        //retrieve comments by postId
        List<Comment> comments=commentRepository.findByPostId(postId);

        //convert list of comment entities to list of comment dto's
        return comments.stream().map(comment -> convertEntityToDto(comment)).collect(Collectors.toList());
    }

    @Override
    public CommentDto getCommentById(long postId, long commentId) {
        //retrieve post entity by id
        Post post=postRepository.findById(postId).orElseThrow(
                () -> new ResourceNotFoundException("Post","id",postId));

        //retrieve comment entity by id
        Comment comment=commentRepository.findById(commentId).orElseThrow(
                () -> new ResourceNotFoundException("Comment","id",commentId));

        if(!comment.getPost().getId().equals(post.getId())){
            throw new BlogAPIException(HttpStatus.BAD_REQUEST,"Comment does not belongs to post");
        }
        return convertEntityToDto(comment);
    }

    @Override
    public CommentDto updateComment(long postId, long commentId, CommentDto commentDto) {
        //retrieve post entity by id
        Post post=postRepository.findById(postId).orElseThrow(
                () -> new ResourceNotFoundException("Post","id",postId));

        //retrieve comment entity by id
        Comment comment=commentRepository.findById(commentId).orElseThrow(
                () -> new ResourceNotFoundException("Comment","id",commentId));

        if(!comment.getPost().getId().equals(post.getId())){
            throw new BlogAPIException(HttpStatus.BAD_REQUEST,"Comment does not belongs to post");
        }

        comment.setName(commentDto.getName());
        comment.setEmail(commentDto.getEmail());
        comment.setBody(commentDto.getBody());

        Comment updatedComment=commentRepository.save(comment);
        return convertEntityToDto(updatedComment);
    }

    @Override
    public void deleteComment(long postId, long commentId) {
        //retrieve post entity by id
        Post post=postRepository.findById(postId).orElseThrow(
                () -> new ResourceNotFoundException("Post","id",postId));

        //retrieve comment entity by id
        Comment comment=commentRepository.findById(commentId).orElseThrow(
                () -> new ResourceNotFoundException("Comment","id",commentId));

        if(!comment.getPost().getId().equals(post.getId())){
            throw new BlogAPIException(HttpStatus.BAD_REQUEST,"Comment does not belongs to post");
        }

        commentRepository.delete(comment);
    }


    private Comment convertDtoToEntity(CommentDto commentDto){
        Comment comment=new Comment();
        comment.setName(commentDto.getName());
        comment.setEmail(commentDto.getEmail());
        comment.setBody(commentDto.getBody());

        return comment;
    }

    private CommentDto convertEntityToDto(Comment comment){
        CommentDto commentDto=new CommentDto();
        commentDto.setId(comment.getId());
        commentDto.setName(comment.getName());
        commentDto.setEmail(comment.getEmail());
        commentDto.setBody(comment.getBody());

        return commentDto;
    }
}
