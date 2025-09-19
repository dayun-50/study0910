package com.kedu.controllers;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class HomeController {
	
	@RequestMapping(value = "/")
	public String home(Locale locale, Model model) {
		return "home";
	}
	
	@RequestMapping("/memberonly")
	public String memberOnly() {
		return "/exams/memberonly";
	}
	
	@RequestMapping("/alluser")
	public String allUser() {
		return "/exams/alluser";
	}
	
	@RequestMapping("/error")
	public String error() {
		return "error";
	}
}
