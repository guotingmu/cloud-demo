package com.demo.service.demoservice.serviceImpl;

import com.demo.api.demoapi.service.TestService;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    public void test() {
        System.out.println("Hello World");
    }
}
