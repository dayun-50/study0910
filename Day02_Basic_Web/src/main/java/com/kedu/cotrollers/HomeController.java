package com.kedu.cotrollers;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	//@RequestMapping(value = "/", method = RequestMethod.POST)
	//@RequestMapping(value = "/") >요건 어떤거든 받겠다 라는뜻이래
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		
		
		return "home";
		//디폴드값이 포어드로 넘어간데
		//return "redirect:/home"; <이러면 리다이렉트로 들어간다
		//클라이언트에게 다시 요구한다 > 현제 상황에서는 home 이라는 컨트롤러 경로가없기에
		//home.jsp를 찾지못하고 404에러발생
		//쉽게말하면 리퀘스트맵핑에 존재하는 리다이랙트경로는 ㄱㅊ은데 없으면 못쓴다고 계산하라고
	}
	
}
