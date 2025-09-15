package com.kedu.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kedu.dto.BoardDTO;
import com.kedu.dto.FilesDTO;

@Repository
public class BoardDAO {

    @Autowired
    private JdbcTemplate jdbc;

    // 게시글 전체 조회
    public List<BoardDTO> getAllBoards() {
        String sql = "SELECT * FROM board ORDER BY seq DESC";
        return jdbc.query(sql, (rs, rowNum) -> {
            BoardDTO board = new BoardDTO();
            board.setSeq(rs.getInt("seq"));
            board.setTitle(rs.getString("title"));
            board.setContent(rs.getString("content"));
            board.setWriter(rs.getString("writer"));
            board.setRegDate(rs.getTimestamp("regdate"));
            return board;
        });
    }

    // 새 게시글 작성
    public int insertBoard(BoardDTO board) {
        String sql = "INSERT INTO board(seq, title, content, writer, regdate) " +
                     "VALUES(board_seq.nextval, ?, ?, ?, sysdate)";
        return jdbc.update(sql, board.getTitle(), board.getContent(), board.getWriter());
    }

    // 게시글 삭제 (작성자 확인 포함)
    public int deleteBoard(int seq, String writer) {
        String sql = "DELETE FROM board WHERE seq=? AND writer=?";
        return jdbc.update(sql, seq, writer); // 본인 글만 삭제 가능
    }

    // 게시글 단일 조회
    public BoardDTO getBoard(int seq) {
        String sql = "SELECT * FROM board WHERE seq=?";
        return jdbc.queryForObject(sql, (rs, rowNum) -> {
            BoardDTO board = new BoardDTO();
            board.setSeq(rs.getInt("seq"));
            board.setTitle(rs.getString("title"));
            board.setContent(rs.getString("content"));
            board.setWriter(rs.getString("writer"));
            board.setRegDate(rs.getTimestamp("regdate"));
            return board;
        }, seq);
    }

    // 게시글 수정 (작성자 확인 포함)
    public int updateBoard(BoardDTO board, String writer) {
        String sql = "UPDATE board SET title=?, content=? WHERE seq=? AND writer=?";
        return jdbc.update(sql, board.getTitle(), board.getContent(), board.getSeq(), writer); 
        // 본인 글만 수정 가능
    }
    
    //파일 업로드
    public int insertFile(FilesDTO dto) {
    	String sql = "insert into files values(files_seq.nextvla,?,?,?,?)";
    	return jdbc.update(sql, dto.getWriter(), dto.getOriname(), dto.getSysname(),dto.getSeq());
    }
    
    
}
