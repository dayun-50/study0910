package com.kedu.controlles;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kedu.dao.BoradDAO;
import com.kedu.dto.BoradDTO;
import com.kedu.services.BoradService;

@Controller
@RequestMapping("/borad")
public class BoradController {
	@Autowired
	private BoradService bServ;
	
	
	@RequestMapping(value = "/boradList")
	public String boradPage(Model m, HttpSession session) throws Exception { //게시판목록
		List<BoradDAO> list = bServ.boradList();
		String userName = (String)session.getAttribute("userName");
		m.addAttribute("userName", userName);
		m.addAttribute("list", list);
		return "borard/list";
	}

	
	@RequestMapping(value = "/postInsert")
	public String postInster(BoradDTO dto, HttpSession session, Model m) throws Exception{ //글작성
		String userName = (String) session.getAttribute("userName");
		bServ.insterBoard(dto);
		m.addAttribute("userName", userName);
		return "redirect:/borad/boradList";
	}
	
	@RequestMapping(value = "/view") //출력
	public String vies(String seq, Model m, HttpSession session) throws Exception{
		List<BoradDAO> list = bServ.selectView(seq);
		String userName = (String)session.getAttribute("userName");
		m.addAttribute("userName", userName);
		m.addAttribute("list", list);
		return "borard/view";
	}
}
