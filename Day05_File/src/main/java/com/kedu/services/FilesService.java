package com.kedu.services;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kedu.dao.FilesDAO;
import com.kedu.dto.FilesDTO;

@Service
public class FilesService {
	
	@Autowired
	private FilesDAO dao;
	
	public List<FilesDTO> selectAll(){
		return dao.selectAll();
	}
	
	public int insertFile(FilesDTO dto) throws Exception{
		return dao.insertFile(dto);
	}
	
}


