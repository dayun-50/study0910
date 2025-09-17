package com.kedu.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kedu.dao.BoradDAO;
import com.kedu.dto.BoradDTO;

@Service
public class BoradService {
	@Autowired
	private BoradDAO dao;
	
	public List<BoradDAO> boradList(){
		return dao.boradList();
	}
	
	public int insterBoard(BoradDTO dto) {
		return dao.insterBoard(dto);
	}
	
	public List<BoradDAO> selectView(String seq) {
		return dao.selectView(seq);
	}
}
