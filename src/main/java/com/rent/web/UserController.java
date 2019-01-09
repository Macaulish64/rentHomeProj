package com.rent.web;


import com.rent.entity.User;
import com.rent.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public String register(Model model) {
		System.out.println("sign up !!!");
		logger.info("into");
		return "success";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	@ResponseBody
	public String login(User user) {
		System.out.println("user-nick-name: " + user.getUsernickname());
		System.out.println("user-password: " + user.getPassword());

		return "success";
	}

	@RequestMapping(value = "/personedit", method = RequestMethod.GET)
	@ResponseBody
	public User edit() {
		// TODO: fix it
		logger.info("!!!!are you ok?\n");
		User nowUser=userService.selectUserById(1);
		System.out.println("!!!"+nowUser.toString());
		logger.info(nowUser.toString());
		return nowUser;
	}

	@RequestMapping(value = "/personedit/{userid}", method = RequestMethod.GET)
	@ResponseBody
	public User edit(@PathVariable("userid") int userid) {
		// TODO: fix it
		return userService.selectUserById(userid);
	}


	@RequestMapping("/test")
	@ResponseBody
	public void test1(@RequestParam("idList[]") List<Integer> idList){
		for(Integer i: idList){
			System.out.println(i);
		}
	}
	@RequestMapping("/test3")
	@ResponseBody
	public void test3(@RequestParam("prideList[]") List<Integer> idList){
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

	@RequestMapping(valuse="/personimg/change")
	@
}
