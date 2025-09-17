package com.kedu.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kedu.dto.BoradDTO;

@Repository
public class BoradDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public List<BoradDAO> boradList(){ //게시판 목록출력
		return mybatis.selectList("Borad.selectAll");
	}
	
	public int insterBoard(BoradDTO dto) { //게시판 입력
		return mybatis.insert("Borad.insert", dto);
	}
	
	public List<BoradDAO> selectView(String seq) {
		return mybatis.selectList("Borad.selectView", seq);
	}
}
