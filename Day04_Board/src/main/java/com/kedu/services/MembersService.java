package com.kedu.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kedu.dao.MembersDAO;
import com.kedu.dto.MembersDTO;

@Service
public class MembersService {
	@Autowired
	private MembersDAO dao;
	
	public int signup(MembersDTO dto) { //회원가입
		dto.setUserPw(dao.encrypt(dto.getUserPw())); //암호화
		return dao.insertMembers(dto);
	}
	
	public String login(String userId, String userPw) { //로그인
		userPw = dao.encrypt(userPw);
		Map<String,String> param = new HashMap<>();
		param.put("userId", userId);
		param.put("userPw", userPw);
		return dao.loginMembers(param);
	}
}