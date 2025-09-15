package com.kedu.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kedu.dto.CommentDTO;

@Repository
public class CommentDAO {
	@Autowired
	private JdbcTemplate jdbc;

	public List<CommentDTO> getAllComment(int seq){ //댓글 전체출력
		String sql = "select * from board_comment where prent_seq = ? ORDER BY seq DESC";
		return jdbc.query(sql, new BeanPropertyRowMapper<>(CommentDTO.class),seq);
	}
	
	public int insertComment(CommentDTO dto) { //댓글 입력
		String sql = "insert into board_comment values(board_comment_seq.nextval,?,?,?,?)";
		return jdbc.update(sql, dto.getPrent_seq(), dto.getContent(), dto.getWriter(), new java.sql.Timestamp(System.currentTimeMillis()));
	}
	
	public int deleteComment(int seq) { //댓글 삭제
		String sql = "delete from board_comment where seq = ?";
		return jdbc.update(sql, seq);
	}
	
	public int updateComment(CommentDTO dto) { //댓글수정
		String sql = "update board_comment set content = ? where seq = ?";
		return jdbc.update(sql, dto.getContent(), dto.getSeq());
	}
	
}
