package com.kedu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kedu.dao.ContactDAO;
import com.kedu.dto.ContactDTO;

@Controller
@RequestMapping("/contacts")
public class ContactsController {
	
	@Autowired
	private ContactDAO dao;
	
	@RequestMapping(value = "/inputPage")
	public String inputPgae() { //페이지 이동
		
		return "/contact/input";
	}
	
	@RequestMapping(value = "/input")
	public String input(ContactDTO dto) { //연락처 등록
		try {
			dao.input(dto);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/";
	}
	
	
}
