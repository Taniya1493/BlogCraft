package com.springboot.blogapp.service;

import com.springboot.blogapp.payload.CategoryDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CategoryService {

    CategoryDto addCategory(CategoryDto categoryDto);

    CategoryDto getCategory(Long categoryId);

    List<CategoryDto> getAllCategories();

    CategoryDto updateCategory(CategoryDto categoryDto,Long categoryId);

    void deleteCategory(Long categoryId);


}
