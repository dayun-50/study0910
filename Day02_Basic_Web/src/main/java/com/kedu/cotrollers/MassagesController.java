package com.kedu.cotrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kedu.dao.MessagesDAO;
import com.kedu.dto.MessagesDTO;

@Controller
@RequestMapping("/massages")
public class MassagesController {
	
	@Autowired
	private MessagesDAO dao;
	
	@RequestMapping("/input")
	public String toInput() {
		
		return "massages/input";
	}
	
//	@RequestMapping("/inputproc")
//	public String inputProc(String sender, String message) {
////		public String inputProc(HttpServletRequest request) {		
////		String sender = request.getParameter("sender");
////		String message = request.getParameter("message");
//		
//		System.out.println(sender + ":" + message);
//		return "redirect:/";
//	}
	
	@RequestMapping("/inputproc")
	public String inputProc(MessagesDTO dto) {
		try {
			dao.insert(dto);
		}catch(Exception e) {
			e.printStackTrace();
			return "redirect:/error";
		}
		return "redirect:/";
	}
	
	@RequestMapping("/output")
	public String toOutput() {
		
		return "massages/output";
	}
	
	
}
