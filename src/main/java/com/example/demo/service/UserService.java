package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.mapper.UserMapper;

import java.util.List;

@Service
public class UserService{

    private final UserMapper userMapper;

    UserService(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    public List<User> getAllUsers(){
        return userMapper.getAllUsers();
    }

    public void updateUser(User user){
         userMapper.updateUser(user);
    }

    public void createUser(User user){
        userMapper.createUser(user);
    }

    public User getUserById(Long id){
        User user = userMapper.getUserById(id);
        return user;
    }

    public void deleteUserById(Long id){
        userMapper.deleteUserById(id);
    }

}