package com.trinhvannam.userapi.Service.mapper;

import com.trinhvannam.userapi.Model.User;
import com.trinhvannam.userapi.Service.DTO.request.UserRequestDTO;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;

public class UserMapper {
    public User toEntity(UserRequestDTO userDTO) {
        User user = new User();
        user.setUserName(userDTO.getUserName());
        user.setUserPass(userDTO.getUserPass());
        user.setUserAddress(userDTO.getUserAddress());
        user.setUserEmail(userDTO.getUserEmail());
        user.setUserPhone(userDTO.getUserPhone());
        user.setAdmin(false);
        user.setUserFirstName(userDTO.getUserFirstName());
        user.setUserLastName(user.getUserLastName());
        return user;
    }
}
