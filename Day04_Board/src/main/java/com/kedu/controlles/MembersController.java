package com.kedu.controlles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kedu.dao.MembersDAO;
import com.kedu.dto.MembersDTO;

@Controller
@RequestMapping("/members")
public class MembersController {
	@Autowired
	private MembersDAO dao;
	
	@RequestMapping(value = "/signPage")
	public String signupPage() throws Exception{ //화원가입 페이지이동
		
		return "members/signup";
	}
	
	@RequestMapping(value = "/signpu")
	public String signup(MembersDTO dto, Model m) throws Exception{ //회원가입
		dto.setUserPw(dao.encrypt(dto.getUserPw()));
		dao.memberInsert(dto);
		
		return "redirect:/";
	}
	
	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception e) { //에러처리
		e.printStackTrace();
		
		return "redirect:/error";
	}
	
}
