package com.kedu.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kedu.dto.MessagesDTO;

@Repository
public class MessagesDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public int insert(MessagesDTO dto) {
		mybatis.insert("Messages.insert", dto);
		return dto.getSeq();
	}
	
	public int delete(String dleSeq) {
		return mybatis.delete("Messages.delete",dleSeq);
	}
	
	public int update(MessagesDTO dto) {
		return mybatis.update("Messages.update", dto);
	}
	
	public List<MessagesDTO> selectAll(){
		return mybatis.selectList("Messages.selectAll");
	}
	
	public List<MessagesDTO> searchBy(Map<String,String> param){
		return mybatis.selectList("Messages.selectBy", param);
	}
	
	public List<MessagesDTO> searchByMultiple(Map<String,String> param){
		return mybatis.selectList("Messages.searchByMultiple", param);
	}
		
	public MessagesDTO selectBySeq(int seq) {
		return mybatis.selectOne("Messages.selectBytSeq", seq);	
	}
	
	public int selectCount() {
		return mybatis.selectOne("Messages.selectCount");
	}
	
	//하나의 값이면 스트링이나 인트나 하면되고 여러가지종류면 오브젝트
	//허나 오브젝트로쓴다면 타입안정성이 떨어지는편이라 일회성으로 맵을 만들어서 매퍼을쓰는건 추천안함
	public Map<String, Object> selecWithJoin(){
		return mybatis.selectOne("Messages.selecWithJoin");
	}
	
//	@Autowired
//	private BasicDataSource bds;
//	
//	@Autowired
//	private JdbcTemplate jdbc;
//	
//	//입력
//	public int insert(MessagesDTO dto) {
//		String sql = "insert into messages values(messages_seq.nextval,?,?)";
//		return jdbc.update(sql, dto.getSender(), dto.getMessage());
//	}
//	
//	//출력
//	public List<MessagesDTO> selectAll() {
//		String sql = "select * from messages";
//		return jdbc.query(sql, new BeanPropertyRowMapper<>(MessagesDTO.class));
//		//테이블과 dto 컬럼명이 무조건 다!!! 같을때만 가능한 한줄.
//		
//		
//		//테이블과 dto 컬럼명이 다르다면 이런 귀찮은 일을 해야한다~
////		return jdbc.query(sql, new RowMapper<MessagesDTO>() { //익명 클레스방식
////			@Override
////			public MessagesDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
////				MessagesDTO dto = new MessagesDTO();
////				dto.setSeq(rs.getInt("seq"));
////				dto.setSender(rs.getString("sender"));
////				dto.setMessage(rs.getString("message"));
////				return dto;
////			}
////		});
//	}
//	
//	//리스트말고 그냥 객체 하나만 뽑기
//	public int count() {
//		String sql = "select count(*) from messages";
//		return jdbc.queryForObject(sql, Integer.class); //인트형값이라서 integer
//	}
//	
//	//삭제
//	public int delete(String delSeq) {
//		String sql = "delete from messages where seq = ?";
//		return jdbc.update(sql, delSeq);
//	}
//	
//	//업데이트
//	public int update(MessagesDTO dto) {
//		String sql = "update messages set sender = ?, message = ? where seq = ?";
//		return jdbc.update(sql, dto.getSender(), dto.getMessage(), dto.getSeq());
//	}
	
	
	
}
