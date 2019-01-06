package com.rent.service.impl;

import com.rent.dao.UserMapper;
import com.rent.entity.User;
import com.rent.entity.UserExample;
import com.rent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public User getExistUser(UserExample example) {
        return userMapper.selectByExample(example).get(0);
    }

    @Override
    public int insertUser(User record) {
        return userMapper.insertSelective(record);
    }

    @Override
    public int updateUser(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public User selectUserById(int userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public List<User> queryUser(UserExample example, int start, int end) {
        return  userMapper.selectByExample(example).subList(start,end);
    }

    @Override
    public int countUser(UserExample example) {
        return userMapper.countByExample(example);
    }
}
