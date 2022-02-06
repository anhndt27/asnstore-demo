package com.trinhvannam.userapi.Repository;

import com.trinhvannam.userapi.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // all crud database methods
    @Query(value = "select * from user_management where user_name like CONCAT('%', :userName, '%')", nativeQuery = true)
    public List<User> findUserByName(@Param("userName") String userName);

    @Query(value = "select * from user_management where user_phone = :userPhone", nativeQuery = true)
    public Optional<User> findUserByPhone(@Param("userPhone") String userPhone);

}