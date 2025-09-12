package com.kedu.controlles;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kedu.dao.BoradDAO;
import com.kedu.dto.BoradDTO;

@Controller
@RequestMapping("/borad")
public class BoradController {
	@Autowired
	private BoradDAO dao;
	
	@RequestMapping(value = "/boradList")
	public String boradPage(Model m) throws Exception { //게시판목록
		List<BoradDAO> list = dao.boradList();
		m.addAttribute("list", list);
		return "borard/list";
	}

	@RequestMapping(value = "/write")
	public String post() throws Exception{ //글작성페이지이동
		return "/borard/post";
	}
	
	@RequestMapping(value = "/postInsert")
	public String postInster(BoradDTO dto, HttpSession session, Model m) throws Exception{ //글작성
		String userName = (String) session.getAttribute("userName");
		dao.insterBoard(dto);
		m.addAttribute("userName", userName);
		return "redirect:/boradList";
	}
	
	@RequestMapping(value = "/view")
	public String vies(String seq) throws Exception{
		return "";
	}
}
