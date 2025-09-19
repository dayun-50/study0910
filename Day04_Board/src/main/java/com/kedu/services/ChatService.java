package com.kedu.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kedu.dao.ChatDAO;
import com.kedu.dto.ChatDTO;

@Service
public class ChatService {
	
	@Autowired
	private ChatDAO dao;
	
	public int insert(ChatDTO dto) {
		return dao.insert(dto);
	}
	
	public List<ChatDTO> selectAll(){
		return dao.selectAll();
	}
}
