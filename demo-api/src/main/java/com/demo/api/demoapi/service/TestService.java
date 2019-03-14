package com.demo.api.demoapi.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@FeignClient(value = "demo-service")
public interface TestService {

    @GetMapping(value = "/test")
    void test();
}
