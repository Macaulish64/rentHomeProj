package com.rent.web;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.rent.common.CommonEnum;
import com.rent.entity.House;
import com.rent.entity.User;
import com.rent.entity.UserExample;
import com.rent.service.HouseService;
import com.rent.service.RentTransactionService;
import com.rent.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("user")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserService userService;

	@Autowired
	private HouseService houseService;

	@Autowired
	private RentTransactionService rentTransactionService;

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

	@RequestMapping(value = "/personedit/{userid}", method = RequestMethod.POST)
	@ResponseBody
	public String personedit(@PathVariable("userid") int userid,
							 @RequestParam("phonenumber") String phonenumber) {
		logger.info("=======================================================");
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
	public String changepassword(@PathVariable("userid") int userid,
					 			HttpServletRequest request) {
		logger.info("=======================================================");
		logger.info("change Password");
		String oldpassword=request.getParameter("oldpassword");
		String newpassword=request.getParameter("newpassword");
		logger.info(oldpassword);
		logger.info(newpassword);
		Map<String,Object> map=new HashMap<String,Object>();
		map=userService.updateUserPassword(userid,oldpassword,newpassword);
		//User nowuser=userService.selectUserById(userid);
		//logger.info(nowuser.toString());
		String json=JSON.toJSONString(map);
		return json;
		//return userService.selectUserById(userid);
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

	@RequestMapping(value="/ownerhouselist/{userid}",method=RequestMethod.GET)
	@ResponseBody
	public String getOwnerHouseList(@PathVariable("userid") int userid,
									HttpServletRequest request) {
		List<House> houselist;
		Map<String,List> map=new HashMap<>();
		List<Integer> publishuserlist=new ArrayList<>();
		publishuserlist.add(userid);
		map.put("publishUserId",publishuserlist);
		houselist=houseService.queryHouse(map,0,1);
		for(House nowhouse : houselist) {//其内部实质上还是调用了迭代器遍历方式，这种循环方式还有其他限制，不建议使用。
			System.out.println(nowhouse.toString());
		}
		String json= JSON.toJSONString(houselist, SerializerFeature.WriteMapNullValue);
		return json;
	}

	@RequestMapping(value = "regist",method = RequestMethod.POST)
	@ResponseBody
	public String userregist(HttpServletRequest request)
	{
		User newuser = new User();
		String userNickName = request.getParameter("usernickname");

		Map<String,Object> map =new HashMap<String, Object>();
		UserExample example = new UserExample();
		example.or().andUsernicknameIn(Collections.singletonList(userNickName));
		User testuser = userService.getExistUser(example);
		if (testuser!=null)
		{
			map.put("rescode", CommonEnum.REQUEST_FAILED.getCode());
			map.put("resmsg",CommonEnum.REQUEST_FAILED.getMsg());
			return JSON.toJSONString(map);
		}

		String password = request.getParameter("password");
		int userType=0,cardType=0;
		String userName = request.getParameter("username");
		String idNumber = request.getParameter("idnumber");
		String phoneNumber = request.getParameter("phonenumber");
		String registCity = request.getParameter("registcity");

		try{
			userType = Integer.parseInt(request.getParameter("useryype"));
		}catch(NumberFormatException e) { }
		try{
			cardType = Integer.parseInt(request.getParameter("cardtype"));
		}catch(NumberFormatException e) { }

		newuser.setUsernickname(userNickName);
		newuser.setPassword(password);
		newuser.setUsername(userName);
		newuser.setUsertype(userType);
		newuser.setIdnumber(idNumber);
		newuser.setCardtype(cardType);
		newuser.setRegistcity(registCity);
		newuser.setPhonenumber(phoneNumber);

		map = userService.insertUser(newuser);
		return JSON.toJSONString(map);
	}

	@RequestMapping(value = "landlordstatistics/{userid}",method = RequestMethod.GET)
	@ResponseBody
	public String landlordstatistics(@PathVariable("userid") int userid,
									 HttpServletRequest request)
	{
		String startMonth = request.getParameter("startmonth");
		String endMonth = request.getParameter("endmonth");
		int op = 0;
		Map<String,Object> map = rentTransactionService.countTransaction(userid,op,startMonth,endMonth);
		String json= JSON.toJSONString(map, SerializerFeature.WriteMapNullValue);
		System.out.println(json);
		return json;
	}

	@RequestMapping(value = "statisticsroomer/{userid}",method = RequestMethod.GET)
	@ResponseBody
	public String statisticsroomer(@PathVariable("userid") int userid,
								   HttpServletRequest request)
	{
		String startMonth = request.getParameter("startmonth");
		String endMonth = request.getParameter("endmonth");
		int op = 1;
		Map<String,Object> map = rentTransactionService.countTransaction(userid,op,startMonth,endMonth);
		String json= JSON.toJSONString(map, SerializerFeature.WriteMapNullValue);
		System.out.println(json);
		return json;
	}
}
