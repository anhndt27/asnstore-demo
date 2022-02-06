package com.trinhvannam.userapi.Service.mapper;

import com.trinhvannam.userapi.Model.Product;
import com.trinhvannam.userapi.Service.DTO.request.ProductRequestDTO;

public class ProductMapper {
    public Product toEntity(ProductRequestDTO productRequestDTO) {
        Product product = new Product();
        product.setProductName(productRequestDTO.getProductName());
        product.setCategory(productRequestDTO.getCategory());
        product.setProductPrice(productRequestDTO.getProductPrice());
        product.setProductQuantity(productRequestDTO.getProductQuantity());
        product.setProductDescription(productRequestDTO.getProductDescription());
        product.setProductImgURL(productRequestDTO.getProductImgURL());
        return product;
    }
}
