package com.kedu.controlles;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class PageController {
	
	@RequestMapping("/signup")
	public String signupPage() { //회원가입 페이지
		return "members/signup";
	}

	@RequestMapping("/home")
	public String homePage() { // home.jsp
		return "redirect:/";
	}
	
	@RequestMapping("/write")
	public String postPage() { // 글작성페이지이동
		return "/borard/post";
	}
	
	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception e) {
		e.printStackTrace();

		return "redirect:/error";
	}
}