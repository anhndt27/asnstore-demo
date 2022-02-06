package com.trinhvannam.userapi.Service.impl;

import com.trinhvannam.userapi.Model.User;
import com.trinhvannam.userapi.Repository.UserRepository;
import com.trinhvannam.userapi.Repository.custom.UserRepositoryCustom;
import com.trinhvannam.userapi.Service.DTO.request.UserRequestDTO;
import com.trinhvannam.userapi.Service.UserService;
import com.trinhvannam.userapi.Service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRepositoryCustom userRepositoryCustom;

    @Override
    public User createNewUser(UserRequestDTO userRequestDTO) {
        UserMapper userMapper = new UserMapper();
        User user = userMapper.toEntity(userRequestDTO);
        return userRepository.save(user);
    }

    @Override
    public List<User> findUserByName(String name) {
        return userRepository.findUserByName(name);
    }

    @Override
    public List<User> findUserByEmail(String email) {
        return userRepositoryCustom.findUserByEmail(email);
    }

}
