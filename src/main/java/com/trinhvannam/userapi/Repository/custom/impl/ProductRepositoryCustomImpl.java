package com.trinhvannam.userapi.Repository.custom.impl;

import com.trinhvannam.userapi.Model.Product;
import com.trinhvannam.userapi.Repository.custom.ProductRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class ProductRepositoryCustomImpl implements ProductRepositoryCustom {
    @Autowired
    public EntityManager entityManager;

    @Override
    public Page<Product> findProductByName(String name, Pageable pageable) {
        String sql = "select * from products where product_name like CONCAT('%', :productName, '%')";
        Query query = entityManager.createNativeQuery(sql, Product.class);
        query.setParameter("productName", name);

        Long count = Long.valueOf(query.getResultList().size());

        int page = pageable.getPageNumber();
        int limit = pageable.getPageSize();
        int offset = page * limit;

        List<Product> userList = query.setFirstResult(offset).setMaxResults(limit).getResultList();

        return new PageImpl<>(userList, pageable, count);
    }
}
