package com.kedu.dao;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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

	public int idCheck(String id) { //id중복검사
		String sql = "select count(*) from members where userId = ?";
		return jdbc.queryForObject(sql, Integer.class, id);
	}
	
	public int login(String id, String pw) { //로그인
		String sql = "select count(*) from members where userId = ? and userPw = ?";
		return jdbc.queryForObject(sql, Integer.class, id, pw);
	}
	
	public String userNameSearch(String userId) { //세선 저장용 닉네임뽑기
		String sql = "select userName from members where userId = ?";
		String name = jdbc.queryForObject(sql, String.class, userId);
		return name;
	}
	
	public int userSecession(String userId) { //회원탈퇴
		String sql = "delete from members where userId = ?";
		return jdbc.update(sql, userId);
	}
	
	public List<MembersDTO> selectAll(String userId){ //마이페이지 출력
		String sql = "select * from members where userId = ?";
		return jdbc.query(sql, new BeanPropertyRowMapper<>(MembersDTO.class), userId);
	}
	
	public int update(MembersDTO dto, String userId) { //마에피이지 업데이트
		String sql = "update members set userPhone = ?, userEmail = ?, userZip = ?, userAddress1 = ?, userAddress2 = ? where userId = ?";
		return jdbc.update(sql, dto.getUserPhone(), dto.getUserEmail(), dto.getUserZip(),
				dto.getUserAddress1(), dto.getUserAddress2(), userId);
	}
}
