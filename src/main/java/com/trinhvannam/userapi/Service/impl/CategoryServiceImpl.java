package com.trinhvannam.userapi.Service.impl;

import com.trinhvannam.userapi.Model.Category;
import com.trinhvannam.userapi.Repository.CategoryRepository;
import com.trinhvannam.userapi.Service.CategoryService;
import com.trinhvannam.userapi.Service.DTO.request.CategoryRequestDTO;
import com.trinhvannam.userapi.Service.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category createNewCategory(CategoryRequestDTO categoryDTO) {
        CategoryMapper categoryMapper = new CategoryMapper();
        Category category = categoryMapper.toEntity(categoryDTO);
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> findCategoryByName(String name) {
        return categoryRepository.findCategoryByName(name);
    }


}
