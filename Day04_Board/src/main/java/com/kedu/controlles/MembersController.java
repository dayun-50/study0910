package com.kedu.controlles;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public String signup(MembersDTO dto, Model m) throws Exception{ // 회원가입
		dto.setUserPw(dao.encrypt(dto.getUserPw()));
		dao.memberInsert(dto);
		return "redirect:/";
	}

	@ResponseBody
	@RequestMapping(value = "/idcheck")
	public int idcheck(String id) throws Exception { // id중복검사
		return dao.idCheck(id);
	}

	@RequestMapping(value = "/login")
	public String login(String id, String pw, HttpSession session, Model m)  throws Exception { // 로그인
		int result = dao.login(id, dao.encrypt(pw));
		if(result >0) {
			String userName = dao.userNameSearch(id);
			m.addAttribute("userName", userName);
			session.setAttribute("userName", userName);
			session.setAttribute("userId", id);
			return "members/loginComplete";
		}else {
			return "redirect:/error";
		}
	}
	
	@RequestMapping(value = "/main")
	public String mainPage(HttpSession session, Model m) throws Exception {
		String userId = (String) session.getAttribute("userId");
		String userName = dao.userNameSearch(userId);
		m.addAttribute("userName", userName);
		return "members/loginComplete";
	}
	
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) throws Exception { // 로그아웃
		session.removeAttribute("userId");
		session.removeAttribute("userName");
		return "redirect:/";
	}
	
	@RequestMapping(value = "/delete")
	public String secession(HttpSession session) throws Exception{ // 회원탍퇴
		 String userId = (String) session.getAttribute("userId");
		 dao.userSecession(userId);
		 session.removeAttribute("userId");
		 session.removeAttribute("userName");
		 return "redirect:/";
	}
	
	@RequestMapping(value = "/mypage")
	public String mypage(HttpSession session, Model m) throws Exception{ // 마이페이지
		String userId = (String) session.getAttribute("userId");
		List<MembersDTO> list = dao.selectAll(userId);
		m.addAttribute("list", list);
		return "members/myPage";
	}
	
	@RequestMapping(value = "/update")
	public String userUpdate(HttpSession session, MembersDTO dto) throws Exception { // 마이페이지 수정
		String userId = (String) session.getAttribute("userId");
		System.out.println(dto);
		dao.update(dto, userId);
		return "redirect:/members/mypage";
	}

	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception e) { // 에러처리
		e.printStackTrace();
		return "redirect:/error";
	}

}
