package com.springboot.blogapp.payload;

import com.springboot.blogapp.entity.Comment;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Set;

@Data
public class PostDto {
    private long id;

    @NotEmpty
    @Size(min = 2,message = "Post title should have maximum 2 characters")
    private String title;

    @NotEmpty
    @Size(min = 2,message = "Post Description should have maximum 2 characters")
    private String description;

    @NotEmpty
    private String content;
    private Set<CommentDto> comments;

    private Long categoryId;
}
