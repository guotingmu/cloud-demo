package com.user.consumer.democonsumer.controller;

import com.user.consumer.democonsumer.entity.User;
import com.user.consumer.democonsumer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "insertUser")
    public void insertUser(User user){
        userService.insertUser(user);
    }

    @GetMapping(value = "selectUser")
    public List<User> selectUser(Integer id){
        List<User> userList = userService.selectUser(id);
        return userList;
    }

    @PostMapping(value = "modifyUser")
    public void modifyUser(User user){
        userService.modifyUser(user);
    }
}
