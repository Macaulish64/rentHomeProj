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

	@RequestMapping("/transaction")
	public String transaction() {
		return "templates/transaction/transaction";
	}

	@RequestMapping("/checktransaction")
	public String checktransaction() {
		return "templates/transaction/checktransaction";
	}

	@RequestMapping("/demandlist")
	public String demandlist() {
		return "templates/demandlist";
	}

	@RequestMapping("/demandinfo")
	public String demandinfo() {
		return "templates/demandinfo";
	}

	@RequestMapping("/irent")
	public String irent() {
		return "templates/post/irent";
	}

	@RequestMapping("/irentout")
	public String irentout() {
		return "templates/post/irentout";
	}

	@RequestMapping("/editrentout")
	public String editirentout() {
		return "templates/post/editrentout";
	}

	@RequestMapping("/personview")
	public String personview() {
		System.out.printf("Into person view");
		return "templates/personinfo/personviewbase";
	}

	@RequestMapping("/personedit")
	public String personedit() {
		return "templates/personinfo/personedit";
	}

	@RequestMapping("/personimg")
	public String personimg() {
		return "templates/personinfo/personimg";
	}

	@RequestMapping("/personsecurity")
	public String personsecurity() {
		return "templates/personinfo/personsecurity";
	}

	@RequestMapping("/roomer")
	public String roomer() {
		return "templates/roomer/statistics";
	}

	@RequestMapping("/roomerdemandlist")
	public String roomerdemandlist() {
		return "templates/roomer/demands";
	}

	@RequestMapping("/roomerdeal")
	public String roomerstar() {
		return "templates/roomer/deal";
	}

	@RequestMapping("/roomerappointment")
	public String roomerappointment() {
		return "templates/roomer/appointment";
	}

	@RequestMapping("/roomerstatistics")
	public String roomerstatistics() {
		return "templates/roomer/statistics";
	}

	@RequestMapping("/landlord")
	public String landlord() {
		return "templates/landlord/statistics";
	}

	@RequestMapping("/landlordhouselist")
	public String landlordhouselist() {
		return "templates/landlord/houses";
	}

	@RequestMapping("/landlordappointment")
	public String landlordappointment() {
		return "templates/landlord/appointment";
	}

	@RequestMapping("/landlorddeal")
	public String landlorddeal() {
		return "templates/landlord/deal";
	}

	@RequestMapping("/landlordstatistics")
	public String landlordstatistics() {
		return "templates/landlord/statistics";
	}

	@RequestMapping("/temp1")
	public String temp1() {
		return "templates/temps/template1";
	}

	@RequestMapping("/temp2")
	public String temp2() {
		return "templates/temps/template2";
	}

	@RequestMapping("/temp3")
	public String temp3() {
		return "templates/temps/template3";
	}

	@RequestMapping("/adminindex")
	public String adminindex() {
		System.out.printf("Into admin");
		return "adminview/statistics";
	}

	@RequestMapping("/adminusrlist")
	public String adminusrlist() {
		return "adminview/ausrlist";
	}

	@RequestMapping("/adminhouselist")
	public String adminhouselist() {
		return "adminview/ahouselist";
	}

	@RequestMapping("/admindemandlist")
	public String admindemandlist() {
		return "adminview/ademandlist";
	}

	@RequestMapping("/admintransactionlist")
	public String admintransaction() {
		return "adminview/atransactionlist";
	}

	@RequestMapping("/adminstatistics")
	public String adminstatistics() {
		return "adminview/statistics";
	}
}
