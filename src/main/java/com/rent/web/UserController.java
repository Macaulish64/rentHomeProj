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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.util.*;

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

	@RequestMapping(value="/testpersonimg", method = RequestMethod.POST)
	@ResponseBody
	public void addphoto(MultipartHttpServletRequest request) {
		Iterator<String> itr = request.getFileNames();
		MultipartFile mpf;
		mpf=request.getFile(itr.next());
		String fileName = mpf.getOriginalFilename();
		File file = new File(request.getServletContext()
				.getRealPath("/img/file"), fileName);
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		System.out.println(request.getServletContext()
				.getRealPath("/img/file"));
		System.out.println("tttwwwoooo\n");
		try {
			mpf.transferTo(file);
		}
		catch (IOException e) {

		}
		System.out.println("tttwwwoooo\n");
	}

}
