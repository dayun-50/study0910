package com.kedu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kedu.dto.MessagesDTO;

@Repository
public class MessagesDAO {
	
	@Autowired
	private BasicDataSource bds;
	
	//입력
	public int insert(MessagesDTO dto) throws Exception {
		String sql = "insert into messages values(messages_seq.nextval,?,?)";
		try(Connection con = bds.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql)){
			pstat.setString(1, dto.getSender());
			pstat.setString(2, dto.getMessage());
			
			return pstat.executeUpdate();
		}
	}
	
	//출력
	public ArrayList<MessagesDTO> selectAll() throws Exception {
		String sql = "select * from messages";
		try(Connection con = bds.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);
				ResultSet rs = pstat.executeQuery()){
			
			ArrayList<MessagesDTO> list = new ArrayList<>();
			while(rs.next()) {
				int seq = rs.getInt("seq");
				String sender = rs.getString("sender");
				String message = rs.getString("message");
				
				list.add(new MessagesDTO(seq, sender, message));
			}
			return list;
		}
	}
	
	//삭제
	public int delete(String seq) throws Exception {
		String sql = "delete from messages where seq = ?";
		try(Connection con = bds.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);){
			pstat.setString(1, seq);
			
			return pstat.executeUpdate();
		}
	}
	
	//업데이트
	public int update(MessagesDTO dto) throws Exception {
		String sql = "update messages set sender = ?, message = ? where seq = ?";
		try(Connection con = bds.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);){
			pstat.setString(1, dto.getSender());
			pstat.setString(2, dto.getMessage());
			pstat.setInt(3, dto.getSeq());
			
			return pstat.executeUpdate();
		}
	}
	
}
