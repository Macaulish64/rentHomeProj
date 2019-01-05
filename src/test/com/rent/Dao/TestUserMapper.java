package com.rent.Dao;

import com.rent.BaseTest;
import com.rent.dao.UserMapper;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TestUserMapper extends BaseTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserMapper userMapper;

    /* */
    @Test
    public void insert() {
        User newUser=new User();
        newUser.setUsernickname("lxlxlx2");
        newUser.setPassword("233333");
        int num=userMapper.insert(newUser);
        System.out.println("!!!!!\n");
    }

    /* */
    @Test
    public void queryUserId() {


    }

    /* */
    @Test
    public void queryhouse() {
        UserExample newUser = new UserExample();
    //    newUser.createCriteria().andUseridEqualTo(Collections.singleton("lxlxlx"));
        newUser.createCriteria().andUsernicknameEqualTo("lxlxlx");
        List<User> userList = userMapper.selectByExample(newUser);
        for(User nowUser : userList) {
            System.out.println(nowUser.toString());
        }
    }


}
