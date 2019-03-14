package com.demo.service.demoservice.serviceImpl;

import com.demo.api.demoapi.service.TestService;
import com.demo.service.demoservice.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    TestMapper mapper;

    @GetMapping(value = "/test")
    public void test() {
        System.out.println("Begin！");
        mapper.test();
        System.out.println("Hello World");
    }
}
