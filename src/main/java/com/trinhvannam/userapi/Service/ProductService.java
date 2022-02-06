package com.trinhvannam.userapi.Service;

import com.trinhvannam.userapi.Model.Product;
import com.trinhvannam.userapi.Service.DTO.request.ProductRequestDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    public Product createNewProduct(ProductRequestDTO productRequestDTO);
    public Page<Product> findProductByName(String name, Pageable pageable);
    public Page<Product> findAllProduct(Pageable pageable);
}
