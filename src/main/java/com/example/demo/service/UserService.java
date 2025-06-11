package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.mapper.UserMapper;

@Service
public class UserService{

    private final UserMapper userMapper;

    UserService(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    public User createUser(User user){
        userMapper.createUser(user);
        return user;
    }

    public User getUserById(Long id){
        User user = userMapper.getUserById(id);
        return user;
    }

    public void deleteUserById(Long id){
        userMapper.deleteUserById(id);
    }

}