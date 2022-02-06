package com.trinhvannam.userapi.Controller;

import com.trinhvannam.userapi.Exception.ResourceNotFoundException;
import com.trinhvannam.userapi.Model.Category;
import com.trinhvannam.userapi.Repository.CategoryRepository;
import com.trinhvannam.userapi.Service.CategoryService;
import com.trinhvannam.userapi.Service.DTO.request.CategoryRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CategoryService categoryService;

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody CategoryRequestDTO categoryRequestDTO) {
        return ResponseEntity.ok().body(categoryService.createNewCategory(categoryRequestDTO));
    }

    @GetMapping
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable  long id){
        Category category  = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not exist with id:" + id));
        return ResponseEntity.ok(category);
    }

    @GetMapping("/findCategoryByName")
    public ResponseEntity<List<Category>> findCategoryByName(@RequestParam String name) {
        return ResponseEntity.ok().body(categoryService.findCategoryByName(name));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteCategory(@PathVariable long id){

        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not exist with id: " + id));

        categoryRepository.delete(category);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable long id,@RequestBody Category categoryDetails) {
        Category updateCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not exist with id: " + id));

        updateCategory.setCategoryName(categoryDetails.getCategoryName());
        categoryRepository.save(updateCategory);
        return ResponseEntity.ok(updateCategory);
    }
}
