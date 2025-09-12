package com.kedu.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kedu.dto.BoradDTO;

@Repository
public class BoradDAO {
	@Autowired
	private JdbcTemplate jdbc;
	
	public List<BoradDAO> boradList(){ //게시판 목록출력
		String sql = "select * from board";
		return jdbc.query(sql, new BeanPropertyRowMapper<>(BoradDAO.class));
	}
	
	public int insterBoard(BoradDTO dto) { //게시판 입력
		String sql = "insert into board values(board_seq.nextval,?,?,?,?)";
		return jdbc.update(sql, dto.getTitle(), dto.getContent(), dto.getWriter(),new java.sql.Timestamp(System.currentTimeMillis()));
	}
}
