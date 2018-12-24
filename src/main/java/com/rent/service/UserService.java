package com.rent.service;

import com.rent.entity.User;

public interface  UserService {
    //判断是否在数据库中已存在重复的用户
    User getExistUser(User user);



}
