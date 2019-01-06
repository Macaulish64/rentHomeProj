package com.rent.service;


import com.rent.entity.User;
import com.rent.entity.UserExample;

public interface  UserService {
    //判断是否在数据库中已存在重复的用户、登录系统
    <List>User getExistUser(UserExample example);

    //插入新用户
    int insertUser(User record);

    //得知用户标识，修改用户信息
    int updateUser(User record);

    //查找用户，从start项到end项
    <List>User queryUser(UserExample example,int start,int end);

}
