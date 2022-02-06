package com.trinhvannam.userapi.Repository;

import com.trinhvannam.userapi.Model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "select * from products where product_name like CONCAT('%', :productName, '%')", nativeQuery = true)
    public Page<Product> findProductByName(@Param("productName") String productName, Pageable pageable);

}
