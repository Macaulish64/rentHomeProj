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

}
