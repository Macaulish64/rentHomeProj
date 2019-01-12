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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TestUserMapper extends BaseTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    /* */
    @Test
    public void insert() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        User newUser=new User();
        newUser.setUsernickname("lxlxlx2");
        newUser.setPassword("233333");
        newUser.setUpdatetime(df.format(new Date()));
        int num=userMapper.insertSelective(newUser);
        System.out.println("!!!!!\n");
    }

    /* */
    @Test
    public void queryUserId() {
        UserExample exam = new UserExample();
        List<User> list = userMapper.selectByExample(exam);


        System.out.println(list);
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
    public void querygetexistuser() {
        //    newUser.createCriteria().andUseridEqualTo(Collections.singleton("lxlxlx"));
        UserExample newUser = new UserExample();
        User nowuser;
        newUser.createCriteria().andUsernicknameEqualTo("lxlxlx");
        newUser.createCriteria().andPasswordEqualTo("23333");
        nowuser=userService.getExistUser(newUser);
        logger.debug(nowuser.toString());
    }


}
