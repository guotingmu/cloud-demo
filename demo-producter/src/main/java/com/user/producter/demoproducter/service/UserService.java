package com.user.producter.demoproducter.service;

import com.user.producter.demoproducter.entity.User;

import java.util.List;

public interface UserService {

    /**
     * 新增用户
     * @param user
     */
    void insertUser(User user);

    /**
     * 查询用户
     * @param user
     * @return
     */
    List<User> selectUser(User user);

    /**
     * 修改用户
     */
    void modifyUser(User user);
}
