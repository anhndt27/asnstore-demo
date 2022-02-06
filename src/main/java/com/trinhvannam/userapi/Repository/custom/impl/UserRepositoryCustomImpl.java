package com.trinhvannam.userapi.Repository.custom.impl;

import com.trinhvannam.userapi.Model.User;
import com.trinhvannam.userapi.Repository.custom.UserRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserRepositoryCustomImpl implements UserRepositoryCustom {
    @Autowired
    public EntityManager entityManager;
    @Override
    public List<User> findUserByEmail(String email) {
        String sql = "select * from user_management where user_email like CONCAT('%', :userEmail, '%')";
        Query query = entityManager.createNativeQuery(sql, User.class);
        query.setParameter("userEmail", email);
        List<User> userList = query.getResultList();
        return userList;
    }
}
