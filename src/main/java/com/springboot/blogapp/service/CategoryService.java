package com.springboot.blogapp.service;

import com.springboot.blogapp.payload.CategoryDto;
import org.springframework.stereotype.Service;

public interface CategoryService {

    CategoryDto addCategory(CategoryDto categoryDto);
}
