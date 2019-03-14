package com.demo.service.demoservice.mapper;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class TestMapperImpl implements TestMapper{
    @Override
    public void test() {
        System.out.println("Service!");
    }
}
