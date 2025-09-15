package com.kedu.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kedu.dao.MemberShipDAO;

@Controller
public class HomeController {

    @Autowired
    private MemberShipDAO dao; // DAO가 @Repository로 등록되어 있어야 함

    // 루트 홈 페이지
    @GetMapping("/")
    public String home() {
        return "home"; // /WEB-INF/views/home.jsp
    }

    // ID 중복체크 AJAX
    @GetMapping("/checkId")
    @ResponseBody
    public Map<String,Object> checkId(@RequestParam("id") String id){
        Map<String,Object> result = new HashMap<>();
        int count = dao.countById(id);
        if(count == 0){
            result.put("status","available");
            result.put("message","사용 가능한 아이디입니다.");
        } else {
            result.put("status","taken");
            result.put("message","이미 사용 중인 아이디입니다.");
        }
        return result; // 스프링이 자동으로 JSON 변환
    }
}
