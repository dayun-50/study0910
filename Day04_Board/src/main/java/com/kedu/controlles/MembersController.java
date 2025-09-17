package com.kedu.controlles;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kedu.dto.MembersDTO;
import com.kedu.services.MembersService;

@Controller
@RequestMapping("/members")
public class MembersController {
	@Autowired
	private MembersService mServ;
	
	@RequestMapping("/signup") //회원가입
	public String signup(MembersDTO dto) { 
		mServ.signup(dto);
		return "redirect:/";
	}
	
	@RequestMapping("/login") //로그인
	public String login(String userId, String userPw, 
			Model m,HttpSession session) { 
		String userName = mServ.login(userId, userPw);
		if(userName != null) { //있는 ID, PW경우
			session.setAttribute("userName", userName);
			session.setAttribute("userId",userId);
			m.addAttribute("userName", userName);
			return "members/loginComplete";
		}else { //로그인 실패시
			return "redirect:/";
		}
	}
	
	@ExceptionHandler(Exception.class) //예외처리
	public String exceptionHandler(Exception e) {
		e.printStackTrace();

		return "redirect:/error";
	}
}