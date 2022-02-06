package com.trinhvannam.userapi.Repository.custom;

import com.trinhvannam.userapi.Model.User;

import java.util.List;

public interface UserRepositoryCustom {
    public List<User> findUserByEmail(String email);
}
