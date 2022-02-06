package com.trinhvannam.userapi.Repository;

import com.trinhvannam.userapi.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query(value = "select * from categories where cat_name like CONCAT('%', :categoryName, '%')", nativeQuery = true)
    public List<Category> findCategoryByName(@Param("categoryName") String categoryName);
}
