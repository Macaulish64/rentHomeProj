package com.rent.web;


import com.rent.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    private String register(User user, Model model) {
    	  logger.info(user.getPhonenumber());
    	  logger.info(user.getUsernickname());
        logger.info("into");
        return "redirect:/index.jsp";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    private String login(User user, Model model) {
        logger.info(user.getUsernickname());
        logger.info(user.getPassword());
        logger.info("into");
        return "redirect:/index.jsp";
    }
}
