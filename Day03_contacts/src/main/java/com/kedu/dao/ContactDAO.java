package com.kedu.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kedu.dto.ContactDTO;

@Repository
public class ContactDAO {
	@Autowired
	private JdbcTemplate jdbc;

	public int input(ContactDTO dto) {
		String sql = "insert into contacts values(contacts_seq.nextval,?,?)";
		return jdbc.update(sql, dto.getName(), dto.getPhone());
	}

	public List<ContactDTO> selectAll(){ //람다식
		String sql = "select * from contacts";
		 return jdbc.query(sql, (rs, rowNum) -> {
		        ContactDTO dto = new ContactDTO();
		        dto.setSeq(rs.getInt("seq"));
		        dto.setName(rs.getString("name"));
		        dto.setPhone(rs.getString("contact"));
		        return dto;
		});
	}

	public int update(ContactDTO dto) {
		String sql = "update contacts set name = ? , contact = ? where seq = ?";
		return jdbc.update(sql, dto.getName(), dto.getPhone(), dto.getSeq());
	}
	
	public int delete(String seq) {
		String sql = "delete from contacts where seq = ?";
		return jdbc.update(sql, seq);
	}


}
