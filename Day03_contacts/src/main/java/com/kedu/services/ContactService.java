package com.kedu.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kedu.dao.ContactDAO;
import com.kedu.dto.ContactDTO;

@Service
public class ContactService {
	@Autowired
	private ContactDAO dao;
	
	public int input(ContactDTO dto) {
		return dao.input(dto);
	}
	
	public List<ContactDTO> selectAll(){
		return dao.selectAll();
	}
	
	public int update(ContactDTO dto) {
		return dao.update(dto);
	}
	
	public int delete(String seq) {
		return dao.delete(seq);
	}
	
}
