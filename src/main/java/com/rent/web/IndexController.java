package com.rent.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/")
	public String index() {
		System.out.println("home");
		return "index";
	}

	@RequestMapping("/signin")
	public String signin() {
		System.out.println("sign in");
		return "signin";
	}

	@RequestMapping("/signup")
	public String signup() {
		System.out.println("sign up");
		return "signup";
	}

	@RequestMapping("/houselist")
	public String houselist() {
		return "houselist";
	}

	@RequestMapping("/houseinfo")
	public String houseinfo() {
		return "houseinfo";
	}

	@RequestMapping("/demandlist")
	public String demandlist() {
		return "demandlist";
	}

	@RequestMapping("/usredit")
	public String usredit() {
		return "usredit";
	}

	@RequestMapping("/usrinfo")
	public String usrinfo() {
		return "usrinfo";
	}

}
