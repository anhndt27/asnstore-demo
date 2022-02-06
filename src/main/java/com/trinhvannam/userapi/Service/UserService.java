package com.trinhvannam.userapi.Service;

import com.trinhvannam.userapi.Model.User;
import com.trinhvannam.userapi.Service.DTO.request.UserRequestDTO;

import java.util.List;

public interface UserService {
    public User createNewUser(UserRequestDTO userRequestDTO);
    public List<User> findUserByName(String name);
    public List<User> findUserByEmail(String email);
}
