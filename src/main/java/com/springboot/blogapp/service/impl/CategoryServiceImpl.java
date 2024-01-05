package com.springboot.blogapp.service.impl;

import com.springboot.blogapp.entity.Category;
import com.springboot.blogapp.payload.CategoryDto;
import com.springboot.blogapp.repository.CategoryRepository;
import com.springboot.blogapp.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;
    private ModelMapper modelMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CategoryDto addCategory(CategoryDto categoryDto) {
        Category category=modelMapper.map(categoryDto,Category.class);
        Category savedCategory=categoryRepository.save(category);
        return modelMapper.map(savedCategory, CategoryDto.class);
    }
}
