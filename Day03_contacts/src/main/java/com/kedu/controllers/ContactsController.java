package com.kedu.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kedu.dao.ContactDAO;
import com.kedu.dto.ContactDTO;

@Controller
@RequestMapping("/contacts")
public class ContactsController {
	
	@Autowired
	private ContactDAO dao;
	
	@RequestMapping(value = "/inputPage")
	public String inputPgae() throws Exception { //페이지 이동
		
		return "/contact/input";
	}
	
	@RequestMapping(value = "/input")
	public String input(ContactDTO dto) throws Exception { //연락처 등록
		dao.input(dto);
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/outputPage")
	public String output(Model m) throws Exception { //출력
		List<ContactDTO> list = dao.selectAll();
		m.addAttribute("list", list);
		
		return "/contact/output";
	}
	
	@RequestMapping(value = "/update")
	public String update(ContactDTO dto) throws Exception { //업데이트
		dao.update(dto);
		
		return "redirect:/contacts/outputPage";
	}
	
	@RequestMapping(value = "/delete")
	public String delete(String seq) throws Exception { //삭제
		dao.delete(seq);
		
		return "redirect:/contacts/outputPage";
	}
	
	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception e) { //에러처리
		e.printStackTrace();
		
		return "redirect:/error";
	}
	
}
