package com.kedu.dao;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kedu.dto.MembersDTO;

@Repository
public class MembersDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
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
	
	public int insertMembers(MembersDTO dto) { // 회원가입
		return mybatis.insert("Members.insert", dto);
	}
	
	public String loginMembers(Map<String,String> param) { // 로그인
		return mybatis.selectOne("Members.loginGetNickname", param);
	}
}