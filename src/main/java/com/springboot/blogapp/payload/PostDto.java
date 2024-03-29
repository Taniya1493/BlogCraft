package com.springboot.blogapp.payload;

import com.springboot.blogapp.entity.Comment;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Set;

@Data
@Schema(
        description = "PostDto Model Information"
)
public class PostDto {
    private long id;

    @Schema(
            description = "Blog Post Title"
    )
    @NotEmpty
    @Size(min = 2,message = "Post title should have maximum 2 characters")
    private String title;

    @Schema(
            description = "Post description"
    )
    @NotEmpty
    @Size(min = 2,message = "Post Description should have maximum 2 characters")
    private String description;

    @Schema(
            description = "Blog Post Content"
    )
    @NotEmpty
    private String content;
    private Set<CommentDto> comments;

    @Schema(
            description = "Blog Post category"
    )
    private Long categoryId;
}
