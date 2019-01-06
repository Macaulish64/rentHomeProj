package com.rent.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/")
	public String index() {
		System.out.println("home");
		return "templates/index";
	}

	@RequestMapping("/signin")
	public String signin() {
		System.out.println("sign in");
		return "templates/signin";
	}

	@RequestMapping("/signup")
	public String signup() {
		System.out.println("sign up");
		return "templates/signup";
	}

	@RequestMapping("/houselist")
	public String houselist() {
		return "templates/houselist";
	}

	@RequestMapping("/houseinfo")
	public String houseinfo() {
		return "templates/houseinfo";
	}

	@RequestMapping("/demandlist")
	public String demandlist() {
		return "templates/demandlist";
	}

	@RequestMapping("/usredit")
	public String usredit() {
		return "templates/usredit";
	}

	@RequestMapping("/usrinfo")
	public String usrinfo() {
		return "templates/usrinfo";
	}

	@RequestMapping("/personview")
	public String personview() {
		System.out.printf("Into admin");
		return "templates/personviewbase";
	}

	@RequestMapping("/adminindex")
	public String adminindex() {
		System.out.printf("Into admin");
		return "adminview/adminindex";
	}

}
