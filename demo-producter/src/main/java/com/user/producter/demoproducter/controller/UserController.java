package com.user.producter.demoproducter.controller;

import com.user.producter.demoproducter.entity.User;
import com.user.producter.demoproducter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "insertUser")
    public void insertUser(User user){
        userService.insertUser(user);
    }

    @GetMapping(value = "selectUser")
    public List<User> selectUser(Integer id){
        User user = new User();
        user.setId(new Long(id));
        List<User> userList = userService.selectUser(user);
        return userList;
    }

    @PostMapping(value = "modifyUser")
    public void modifyUser(User user){
        userService.modifyUser(user);
    }
}
