package com.rent.web;


import com.rent.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/register", headers = "application/json", method = RequestMethod.POST)
    @ResponseBody
    private String register(Model model) {
        System.out.println("sign up !!!");
        logger.info("into");
        return "redirect:/index.jsp";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    private String login(Model model) {
        System.out.println("sign in !!!");
        logger.info("into");
        return "redirect:/index.jsp";
    }
}
