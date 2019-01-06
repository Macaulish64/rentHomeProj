package com.rent.service;


import com.rent.entity.User;
import com.rent.entity.UserExample;

import java.util.List;

public interface  UserService {
    /*判断是否在用户名已注册,example里加上andUsernicknameEqualTo或andPhonenumberEqualTo
    或登录系统,example里加上andUsernicknameEqualTo和andPasswordEqualTo*/
    List<User> getExistUser(UserExample example);

    //插入新用户
    int insertUser(User record);

    //在得知用户标识的情况下，修改用户信息
    int updateUser(User record);

    //查找用户，从start项到end项，从0开始
    List<User> queryUser(UserExample example,int start,int end);

    //计数
    int countUser(UserExample example);
}
