package com.rent.Dao;

import com.rent.BaseTest;
import com.rent.entity.User;
import com.rent.dao.UserDao;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class TestUserDao extends BaseTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserDao userDao;

    /* */
    @Test
    public void addUser() {
        User newUser=new User();
        newUser.setuSerNickName("lxlxlx");
        newUser.setPasserId("233333");
        int num=userDao.addUser(newUser);
        System.out.println("!!!!!\n");
    }

    /* */
    @Test
    public void queryUserId() {


    }


}
