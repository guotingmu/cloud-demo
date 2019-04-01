package com.user.producter.demoproducter.service.serviceImpl;

import com.user.producter.demoproducter.dao.UserMapper;
import com.user.producter.demoproducter.entity.User;
import com.user.producter.demoproducter.entity.UserExample;
import com.user.producter.demoproducter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public void insertUser(User user) {
        userMapper.insertSelective(user);
    }

    @Override
    public List<User> selectUser(User user) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        if (user.getId() != null){
            criteria.andIdEqualTo(user.getId());
        }
        List<User> userList = userMapper.selectByExample(userExample);
        return userList;
    }

    @Override
    public void modifyUser(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }
}
