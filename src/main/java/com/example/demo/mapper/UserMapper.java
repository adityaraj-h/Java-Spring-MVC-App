package com.example.demo.mapper;

import com.example.demo.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper{

    void createUser(User user);
    User getUserById(Long id);
    void deleteUserById(Long id);
    List<User>getAllUsers();
    void updateUser(User user);
   
}

