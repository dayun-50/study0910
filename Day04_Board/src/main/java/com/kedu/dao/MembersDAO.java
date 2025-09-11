package com.kedu.dao;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kedu.dto.MembersDTO;

@Repository
public class MembersDAO {
	@Autowired
	private JdbcTemplate jdbc;
	
	public static String encrypt(String text) { //SHA 암호화
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			byte[] bytes = text.getBytes(StandardCharsets.UTF_8);
			byte[] digest = md.digest(bytes);

			StringBuilder builder = new StringBuilder();
			for (byte b : digest) {
				builder.append(String.format("%02x", b));
			}
			return builder.toString();

		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("SHA-512 암호화 실패", e);
		}
	}
	
	public int memberInsert(MembersDTO dto) { //회원가입
		String sql = "insert into members values(members_seq.nextval,?,?,?,?,?,?,?,?)";
		return jdbc.update(sql, dto.getUserId(), dto.getUserPw(), dto.getUserName(),
				dto.getUserPhone(), dto.getUserEmail(), dto.getUserZip(),
				dto.getUserAddress1(),dto.getUserAddress2());
	}
}
