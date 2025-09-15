package com.kedu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kedu.dao.CommentDAO;
import com.kedu.dto.CommentDTO;

@Controller
@RequestMapping("/comment")
public class CommentController {
	@Autowired
	private CommentDAO dao;

	@RequestMapping(value = "/commentInsert")
	public String commentInsert(CommentDTO dto) { //댓글입력
		dao.insertComment(dto);
		return "redirect:/board/view/"+dto.getPrent_seq();
	}
	
	@RequestMapping(value="/dle")
	public String commentDelete(int seq, int prent_seq) { //댓글 삭제
		dao.deleteComment(seq);
		return "redirect:/board/view/"+prent_seq;
	}
	
	@RequestMapping(value = "/up")
	public String commentUpdate(CommentDTO dto) { //댓글 수정
		dao.updateComment(dto);
		return "redirect:/board/view/"+dto.getPrent_seq();
	}
	
	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception e) { // 에러처리
		e.printStackTrace();
		return "redirect:/error";
	}
}
