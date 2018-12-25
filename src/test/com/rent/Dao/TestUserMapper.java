package com.rent.Dao;

import com.rent.BaseTest;
import com.rent.dao.UserMapper;
import com.rent.entity.User;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class TestUserMapper extends BaseTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserMapper userMapper;

    /* */
    @Test
    public void insert() {
        User newUser=new User();
        newUser.set("lxlxlx");
        newUser.setPasserId("233333");
        int num=userDao.addUser(newUser);
        System.out.println("!!!!!\n");
    }

    /* */
    @Test
    public void queryUserId() {


    }


}
