package com.kedu.cotrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kedu.dto.MessagesDTO;
import com.kedu.services.MessagesService;

@Controller
@RequestMapping("/massages")
public class MassagesController {

	@Autowired
	private MessagesService mServ; //원래 풀네임으로하는게 정석인데 그냥 불편하니 일단 줄여서 ㅇㅇ

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
		mServ.insert(dto);

		return "redirect:/";
	}

	@RequestMapping("/output")
	public String toOutput(Model m) throws Exception {
		List<MessagesDTO> list = mServ.selectAll();
		m.addAttribute("list", list); // == request.setAttribute;

		return "massages/output";
	}

	@RequestMapping("/delete")
	public String delete(String dleSeq) throws Exception {
		mServ.delete(dleSeq);

		return "redirect:/massages/output";
	}

	@RequestMapping("/update")
	public String update(MessagesDTO dto) throws Exception {
		mServ.update(dto);

		return "redirect:/massages/output";
	}

	@RequestMapping("/searchby")
	public String searchBy(String column, String keyword) throws Exception{
		List<MessagesDTO> list = mServ.searchBy(column, keyword);
		for(MessagesDTO dto : list) {
			System.out.println(dto.getSeq() +":"+ dto.getSender() +":"+ dto.getMessage());
		}
		return "redirect:/";
	}


	@RequestMapping("searchByMultiple")
	public String searchByMultiple(String sender, String message) throws Exception {
		List<MessagesDTO> list = mServ.searchByMultiple(sender, message);
		for(MessagesDTO dto : list) {
			System.out.println(dto.getSeq() +":"+ dto.getSender() +":"+ dto.getMessage());
		}
		System.out.println("=====");
		return "redirect:/";
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
