package com.springboot.blogapp.repository;

import com.springboot.blogapp.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {

    //create a query method to retrieve a list of blog post that belongs to particular category
    List<Post> findByCategoryId(Long categoryId);
}
