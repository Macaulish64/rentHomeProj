package com.rent.web;


import com.rent.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	private String register(Model model) {
		System.out.println("sign up !!!");
		logger.info("into");
		return "success";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	@ResponseBody
	private String login(User user) {
		System.out.println("user-nick-name: " + user.getUsernickname());
		System.out.println("user-password: " + user.getPassword());

		return "success";
	}

	@RequestMapping(value = "/personedit/{userid}", method = RequestMethod.GET)
	@ResponseBody
	private String edit() {
		// TODO: fix it
		return "success";
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

	/* test photo */
	@RequestMapping(value="/testpersonimg", method = RequestMethod.GET)
	public @ResponseBody Map list(){
		System.out.printf("!!!\n");
	//	List<String> list;
		Map<String,Object> files=new HashMap<>();
		//files.put("files",list);
		return files;
	}
//	public void test4(@RequestParam("photofile") MultipartFile img) {
//		logger.info("if ok?");
//	}

}
