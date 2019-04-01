package com.user.consumer.democonsumer.service;

import com.user.consumer.democonsumer.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("user-producter")
public interface UserService {

    /**
     * 新增用户
     * @param user
     */
    @PostMapping(value = "insertUser")
    void insertUser(@RequestBody User user);

    /**
     * 查询用户
     * @param id
     * @return
     */
    @GetMapping(value = "selectUser")
    List<User> selectUser(@RequestParam("id") Integer id);

    /**
     * 修改用户
     */
    @PostMapping(value = "modifyUser")
    void modifyUser(@RequestBody User user);
}
