package com.kedu.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kedu.dao.MessagesDAO;
import com.kedu.dto.MessagesDTO;

//서비스전용이랴~
//루트에서 인스턴스생성
@Service
public class MessagesService {
	
	// Business Logic
	
	@Autowired
	private MessagesDAO dao;
	
	public int insert(MessagesDTO dto) {
		return dao.insert(dto);
	}
	
	public List<MessagesDTO> selectAll() {
		return dao.selectAll();
	}
	
	public int delete(String dleSeq) {
		return dao.delete(dleSeq);
	}
	
	public int update(MessagesDTO dto) {
		return dao.update(dto);
	}
	
	public List<MessagesDTO> searchBy(String column, String keyword){
		Map<String,String> param = new HashMap<>();
		param.put("column", column);
		param.put("keyword", keyword);
		return dao.searchBy(param);
	}
	
	public List<MessagesDTO> searchByMultiple(String sender, String message) {
		Map<String,String> param = new HashMap<>();
		param.put("sender", sender);
		param.put("message", message);
		return dao.searchByMultiple(param);
	}
	
}
