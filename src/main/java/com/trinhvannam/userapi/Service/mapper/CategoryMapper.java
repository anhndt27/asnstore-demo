package com.trinhvannam.userapi.Service.mapper;

import com.trinhvannam.userapi.Model.Category;
import com.trinhvannam.userapi.Service.DTO.request.CategoryRequestDTO;

public class CategoryMapper {
    public Category toEntity(CategoryRequestDTO categoryDTO) {
        Category category = new Category();
        category.setCategoryName(categoryDTO.getCategoryName());
        return category;
    }
}
