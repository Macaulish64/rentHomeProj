package com.rent.web;


import com.rent.entity.User;
import com.rent.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    private String register(User user) {
       User hasUser = UserService.getExistUser(user);




    }

}
