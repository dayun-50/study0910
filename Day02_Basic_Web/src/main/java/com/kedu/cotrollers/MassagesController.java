package com.kedu.cotrollers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
	public String inputProc(MessagesDTO dto) throws Exception {
		dao.insert(dto);
		
		return "redirect:/";
	}
	
	@RequestMapping("/output")
	public String toOutput(Model m) throws Exception {
		ArrayList<MessagesDTO> list = dao.selectAll();
		m.addAttribute("list", list); // == request.setAttribute;
		
		return "massages/output";
	}
	
	@RequestMapping("/delete")
	public String delete(String dleSeq) throws Exception {
		dao.delete(dleSeq);
		
		return "redirect:/massages/output";
	}
	
	@RequestMapping("/update")
	public String update(MessagesDTO dto) throws Exception {
		dao.update(dto);
		
		return "redirect:/massages/output";
	}
	
	//예외처리 메서드
	//디스패처한테 throws 한 예외처리를 디스패처가 다시 이 메서드로 넘겨줌
	//@ExceptionHandler(Exception.class) : 현제 클래스안에서 일어난 오류처리를 다 처리함
	//@ExceptionHandler(nullPointerException.class) : null값에 이러난 오류만 처리
	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception e) {
		e.printStackTrace();
		
		return "redirect:/error";
	}
	
	
	
}
