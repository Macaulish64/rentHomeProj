package com.rent.service.impl;

import com.rent.dao.UserMapper;
import com.rent.entity.User;
import com.rent.entity.UserExample;
import com.rent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public <List>User getExistUser(UserExample example) {
        return (User) userMapper.selectByExample(example);
    }

    @Override
    public int insertUser(User record) {
        return userMapper.insertSelective(record);
    }

    @Override
    public int updateUser(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

}
