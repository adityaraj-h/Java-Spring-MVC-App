package com.example.demo.mapper;

import com.example.demo.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper{

    void createUser(User user);
    User getUserById(Long id);
    void deleteUserById(Long id);
   
}

