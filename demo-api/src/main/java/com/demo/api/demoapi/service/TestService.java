package com.demo.api.demoapi.service;

import com.demo.api.demoapi.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@FeignClient(value = "demo-service")
public interface TestService {

    @GetMapping(value = "/test")
    User test();
}
