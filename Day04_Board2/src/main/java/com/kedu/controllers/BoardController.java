package com.kedu.controllers;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.kedu.dao.BoardDAO;
import com.kedu.dao.CommentDAO;
import com.kedu.dto.BoardDTO;
import com.kedu.dto.CommentDTO;
import com.kedu.dto.FilesDTO;
import com.kedu.dto.MemberShipDTO;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardDAO dao;
	@Autowired
	private CommentDAO cDao;

	// 게시판 목록
	@GetMapping("/list")
	public String boardList(Model model, HttpSession session) {
		List<BoardDTO> boards = dao.getAllBoards();
		model.addAttribute("boards", boards);

		MemberShipDTO user = (MemberShipDTO) session.getAttribute("user");
		model.addAttribute("user", user); // JSP에서 작성자 버튼 노출용
		return "board/list"; // /WEB-INF/views/board/list.jsp
	}

	// 게시글 작성 폼
	@GetMapping("/write")
	public String writeForm(HttpSession session) {
		MemberShipDTO user = (MemberShipDTO) session.getAttribute("user");
		if (user == null) {
			return "redirect:/membership/home"; // 로그인 안 됐으면 홈으로
		}
		return "board/write"; // /WEB-INF/views/board/write.jsp
	}

	// 게시글 작성 처리
	@PostMapping("/write")
	public String writeSubmit(BoardDTO board, HttpSession session, MultipartFile[] files) throws Exception {
		MemberShipDTO user = (MemberShipDTO) session.getAttribute("user");
		if (user == null) {
			return "redirect:/membership/home";
		}
		board.setWriter(user.getId()); // 작성자 세팅
		dao.insertBoard(board);

		String realPath = session.getServletContext().getRealPath("upload");
		File realPathFile = new File(realPath);
		if(!realPathFile.exists()) {realPathFile.mkdir();}
		for(MultipartFile file : files) {
			if(!file.isEmpty()) {
				String oriName = file.getOriginalFilename();
				String sysName = UUID.randomUUID() + "_" + oriName;

				file.transferTo(new File(realPath+"/"+sysName));
				dao.insertFile(new FilesDTO(0,"test", oriName, sysName, board.getSeq()));
			}
		}


		return "redirect:/board/list";
	}

	// 게시글 삭제도 마찬가지로:
	@GetMapping("/delete/{seq}")
	public String deleteBoard(@PathVariable int seq, HttpSession session) {
		MemberShipDTO user = (MemberShipDTO) session.getAttribute("user");
		if (user != null) {
			int deleted = dao.deleteBoard(seq, user.getId());
			if (deleted == 0) {
				// 삭제 권한 없음
				return "redirect:/board/list?error=권한없음";
			}
		}
		return "redirect:/board/list";
	}

	// 게시글 상세 보기
	@GetMapping("/view/{seq}")
	public String viewBoard(@PathVariable int seq, Model m, HttpSession session) {
		BoardDTO board = dao.getBoard(seq);
		m.addAttribute("board", board);
		List<CommentDTO> list = cDao.getAllComment(seq);
		m.addAttribute("list", list);

		MemberShipDTO user = (MemberShipDTO) session.getAttribute("user");
		m.addAttribute("user", user); // JSP에서 수정/삭제 버튼 노출용
		return "board/view"; // /WEB-INF/views/board/view.jsp
	}

	// 수정 폼 보여주기
	@GetMapping("/edit/{seq}")
	public String editForm(@PathVariable int seq, Model model, HttpSession session) {
		MemberShipDTO user = (MemberShipDTO) session.getAttribute("user");
		if (user == null) {
			return "redirect:/membership/home";
		}

		BoardDTO board = dao.getBoard(seq);
		if (!board.getWriter().equals(user.getId())) {
			return "redirect:/board/list"; // 작성자 아니면 접근 금지
		}

		model.addAttribute("board", board);
		return "board/edit"; // edit.jsp
	}

	// BoardController.java
	@PostMapping("/edit/{seq}")
	public String editSubmit(@PathVariable int seq, BoardDTO board, HttpSession session) {
		board.setSeq(seq);
		MemberShipDTO user = (MemberShipDTO) session.getAttribute("user");
		if (user != null) {
			int updated = dao.updateBoard(board, user.getId()); // writer 인자 추가
			if (updated == 0) {
				// 수정 권한 없음
				return "redirect:/board/list?error=권한없음";
			}
		}
		return "redirect:/board/list";
	}




}
