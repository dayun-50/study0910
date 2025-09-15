package com.kedu.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.kedu.dto.MemberShipDTO;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Repository
public class MemberShipDAO {

    @Autowired
    private JdbcTemplate jdbc;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    // 회원가입
    public int insertMember(MemberShipDTO member) {
        String hashedPw = encoder.encode(member.getPw());
        String sql = "INSERT INTO members(seq, id, pw, name, phone, email, zipcode, address, detail_address) " +
                     "VALUES(members_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?)";
        return jdbc.update(sql, member.getId(), hashedPw, member.getName(),
                           member.getPhone(), member.getEmail(),
                           member.getZipcode(), member.getAddress(), member.getDetailAddress());
    }

    // ID 중복 확인
    public int countById(String id) {
        String sql = "SELECT COUNT(*) FROM members WHERE id = ?";
        return jdbc.queryForObject(sql, Integer.class, id);
    }

    // 로그인
    public MemberShipDTO selectMember(String id, String rawPw) {
        try {
            String sql = "SELECT * FROM members WHERE id = ?";
            MemberShipDTO member = jdbc.queryForObject(sql,
                (rs, rowNum) -> {
                    MemberShipDTO m = new MemberShipDTO();
                    m.setSeq(rs.getInt("seq"));
                    m.setId(rs.getString("id"));
                    m.setPw(rs.getString("pw")); // 해시된 비밀번호
                    m.setName(rs.getString("name"));
                    m.setPhone(rs.getString("phone"));
                    m.setEmail(rs.getString("email"));
                    m.setZipcode(rs.getString("zipcode"));
                    m.setAddress(rs.getString("address"));
                    m.setDetailAddress(rs.getString("detail_address"));
                    return m;
                },
                id
            );

            if (encoder.matches(rawPw, member.getPw())) {
                return member; // 로그인 성공
            } else {
                return null; // 비밀번호 불일치
            }

        } catch (Exception e) {
            return null; // ID가 없거나 조회 실패
        }
    }
 // 회원정보 수정
    public int updateMember(MemberShipDTO member) {
        // 비밀번호가 입력되면 새 비밀번호로 업데이트, 아니면 그대로 둠
        String sql;
        Object[] params;

        if (member.getPw() != null && !member.getPw().isEmpty()) {
            String hashedPw = encoder.encode(member.getPw());
            sql = "UPDATE members SET name = ?, phone = ?, email = ?, zipcode = ?, address = ?, detail_address = ?, pw = ? WHERE id = ?";
            params = new Object[] {
                member.getName(), member.getPhone(), member.getEmail(),
                member.getZipcode(), member.getAddress(), member.getDetailAddress(),
                hashedPw, member.getId()
            };
        } else {
            sql = "UPDATE members SET name = ?, phone = ?, email = ?, zipcode = ?, address = ?, detail_address = ? WHERE id = ?";
            params = new Object[] {
                member.getName(), member.getPhone(), member.getEmail(),
                member.getZipcode(), member.getAddress(), member.getDetailAddress(),
                member.getId()
            };
        }

        return jdbc.update(sql, params);
    }
    
 // ID로 회원 정보 조회 (mypage 화면용, 비밀번호는 빈 문자열)
    public MemberShipDTO selectMemberById(String id) {
        String sql = "SELECT * FROM members WHERE id = ?";
        return jdbc.queryForObject(sql, (rs, rowNum) -> {
            MemberShipDTO m = new MemberShipDTO();
            m.setSeq(rs.getInt("seq"));
            m.setId(rs.getString("id"));
            m.setName(rs.getString("name"));
            m.setPhone(rs.getString("phone"));
            m.setEmail(rs.getString("email"));
            m.setZipcode(rs.getString("zipcode"));
            m.setAddress(rs.getString("address"));
            m.setDetailAddress(rs.getString("detail_address"));
            m.setPw(""); // 화면에 비밀번호 표시하지 않음
            return m;
        }, id);
    }
 // 회원탈퇴
    public int deleteMember(String id) {
        String sql = "DELETE FROM members WHERE id = ?";
        return jdbc.update(sql, id);
    }
}
