package com.trinhvannam.userapi.Repository.custom;

import com.trinhvannam.userapi.Model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductRepositoryCustom {
    public Page<Product> findProductByName(String name, Pageable pageable);
}
