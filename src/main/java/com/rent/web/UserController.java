package com.rent.web;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    private String register(Model model) {
        System.out.println("sign up !!!");
        logger.info("into");
        return "redirect:/index.html";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody //以json的形式返回对象
    private String login(Model model) {
        System.out.println("sign in !!!");
        logger.info("into");
        return "success";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    private String edit() {
        return "userinfo";
    }

    @RequestMapping("/test")
    @ResponseBody
    public void test1(@RequestParam("idList[]") List<Integer> idList){
        for(Integer i: idList){
            System.out.println(i);
        }
    }
    @RequestMapping(value ="/test2",method = RequestMethod.POST)
    @ResponseBody
    public String test1(){
        System.out.println("!!!!!Response");
        return "redirect:/index.html";
    }
}
