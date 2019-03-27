package com.demo.service.demoservice.serviceImpl;

import com.demo.api.demoapi.entity.User;
import com.demo.api.demoapi.service.TestService;
import com.demo.service.demoservice.config.TestJavaConfigBean;
import com.demo.service.demoservice.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestServiceImpl implements TestService {

    @Autowired
    UserMapper userMapper;

    @Override
    @GetMapping(value = "/test")
    public User test() {
       User user = userMapper.selectByPrimaryKey(new Long(1));
       return user;
    }
}
