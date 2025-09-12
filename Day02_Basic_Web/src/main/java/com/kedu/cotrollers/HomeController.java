package com.kedu.cotrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.kedu.dto.MessagesDTO;

@Controller
public class HomeController {

//	@Autowired
//	private Gson gson;

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

	@ResponseBody //포어드,리다이렉트 둘다 ㄴㄴ 값을 그대로보냄ㅇㅇ
	@RequestMapping(value = "/ajax", produces="application/json;")
	//	public String ajax() {
	//		MessagesDTO dto = new MessagesDTO(1,"a","뭘봐");
	//		
	//		return gson.toJson(dto);
	//	}

	public MessagesDTO ajax() {
		MessagesDTO dto = new MessagesDTO(1,"a","뭘봐");

		return dto;
	}

}
