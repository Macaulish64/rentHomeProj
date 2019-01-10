package com.rent.Dao;

import com.rent.BaseTest;
import com.rent.dao.UserMapper;
import com.rent.entity.User;
import com.rent.entity.UserExample;
import com.rent.service.UserService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class TestUserMapper extends BaseTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

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
    public void queryuser() {
        UserExample newUser = new UserExample();
    //    newUser.createCriteria().andUseridEqualTo(Collections.singleton("lxlxlx"));
        newUser.or().andUsernicknameEqualTo("lxlxlx");
        List<User> userList = userMapper.selectByExample(newUser);
        for(User nowUser : userList) {
            System.out.println(nowUser.toString());
        }
    }

    @Test
    public void queryGetExistuser() {
        User nowuser=new User();
        nowuser.setUsernickname("lxlxlx");
        nowuser.setPassword("23333");
        Map<String,Object> map=userService.checkUserLogin(nowuser);
        logger.debug(nowuser.toString());
    }


}
