package com.rent.web;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.rent.entity.User;
import com.rent.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserService userService;

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
		Map<String,Object> map=userService.checkUserLogin(user);
		return JSON.toJSONString(map);
	}


	@RequestMapping(value = "/personedit/{userid}", method = RequestMethod.GET)
	@ResponseBody
	public String personedit(@PathVariable("userid") int userid,
							 @RequestParam("phonenumber") String phonenumber) {
		logger.info("Person Edit phonenumber\n");
		Map<String,Object> map=new HashMap<String,Object>();
		map=userService.updateUserPhonenumber(userid,phonenumber);
		String json=JSON.toJSONString(map, SerializerFeature.WriteMapNullValue);
		return json;
	}

	@RequestMapping(value = "/personinfo/{userid}", method = RequestMethod.GET)
	@ResponseBody
	public String personview(@PathVariable("userid") int userid) {
		logger.info("!!!!are you ok?\n");
		logger.info("userid="+userid);
		User nowUser=userService.selectUserById(userid);
		System.out.println("!!!"+nowUser.toString());
		String json=JSON.toJSONString(nowUser, SerializerFeature.WriteMapNullValue);
		return json;
	}

	@RequestMapping(value = "/changepassword/{userid}", method = RequestMethod.POST)
	@ResponseBody
	public User changepassword(@PathVariable("userid") int userid,
					 @RequestParam("oldpassword") String oldpassword,
					 @RequestParam("newpassword") String newpassword) {
		// TODO: fix it
		//return userService.changepassword(userid,oldpassword,newpassword);
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

	@RequestMapping(value ="/test4",method = RequestMethod.GET)
	@ResponseBody
	public String test4(){
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
