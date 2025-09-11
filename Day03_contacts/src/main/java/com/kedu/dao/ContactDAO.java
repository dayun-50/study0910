package com.kedu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kedu.dto.ContactDTO;

@Repository
public class ContactDAO {
	
	@Autowired
	private BasicDataSource bds;
	
	public int input(ContactDTO dto) throws Exception{ //전번 입력
		String sql = "insert into contacts values(contacts_seq.nextval,?,?)";
		try(Connection con = bds.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql)){
			pstat.setString(1, dto.getName());
			pstat.setString(2, dto.getPhone());
			
			return pstat.executeUpdate();
		}
	}
}
