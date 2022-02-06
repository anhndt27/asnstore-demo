package com.trinhvannam.userapi.Service.impl;

import com.trinhvannam.userapi.Exception.ResourceNotFoundException;
import com.trinhvannam.userapi.Model.Product;
import com.trinhvannam.userapi.Repository.ProductRepository;
import com.trinhvannam.userapi.Repository.custom.ProductRepositoryCustom;
import com.trinhvannam.userapi.Service.DTO.request.ProductRequestDTO;
import com.trinhvannam.userapi.Service.ProductService;
import com.trinhvannam.userapi.Service.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductRepositoryCustom productRepositoryCustom;

    @Override
    public Product createNewProduct(ProductRequestDTO productRequestDTO) {
        ProductMapper productMapper = new ProductMapper();
        Product product = productMapper.toEntity(productRequestDTO);
        return productRepository.save(product);
    }

    @Override
    public Page<Product> findProductByName(String name, Pageable pageable) {
        return productRepositoryCustom.findProductByName(name, pageable);
    }

    @Override
    public Page<Product> findAllProduct(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

}
