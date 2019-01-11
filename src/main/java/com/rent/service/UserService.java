package com.rent.service;


import com.rent.entity.User;
import com.rent.entity.UserExample;

import java.util.List;
import java.util.Map;

public interface  UserService {
    //判断是否在用户名已注册,example里加上andUsernicknameEqualTo或andPhonenumberEqualTo
    User getExistUser(UserExample example);

    //插入新用户
    public Map<String,Object> insertUser(User record);

    //在得知用户标识的情况下，修改用户信息
    public Map<String,Object> updateUser(User record);

    //修改密码
    public Map<String,Object> updateUserPassword(int Userid,String oldpassword,String newPassword);

    //修改手机号
    public Map<String,Object> updateUserPhonenumber(int Userid,String phonenum);

    //在已知用户标识的情况下，查找用户
    User selectUserById(int userId);

    //查找用户，从start项到end项，从0开始

    public List<User> queryUser(Map<String,List> map,int start,int end);

    //计数
    public int queryUserNum(Map<String,List> map);

    public Map<String,Object> checkUserLogin(User record);
}
