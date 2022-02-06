package com.trinhvannam.userapi.Service;

import com.trinhvannam.userapi.Model.Category;
import com.trinhvannam.userapi.Service.DTO.request.CategoryRequestDTO;

import java.util.List;

public interface CategoryService {
    public Category createNewCategory(CategoryRequestDTO categoryDTO);
    public List<Category> findCategoryByName(String name);

}
