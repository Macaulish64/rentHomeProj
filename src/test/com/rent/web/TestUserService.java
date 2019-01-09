package com.rent.web;

import com.rent.BaseTest;
import com.rent.entity.User;
import com.rent.service.UserService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class TestUserService extends BaseTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    /* */
    @Test
    public void quert() {
        User nowUser=userService.selectUserById(1);
        System.out.println("!!!"+nowUser.toString());
        logger.info(nowUser.toString());
    }

}
