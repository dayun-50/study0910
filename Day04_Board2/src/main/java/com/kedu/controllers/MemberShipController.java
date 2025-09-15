package com.kedu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import com.kedu.dao.MemberShipDAO;
import com.kedu.dto.MemberShipDTO;

@Controller
@RequestMapping("/membership")
public class MemberShipController {

    @Autowired
    private MemberShipDAO dao;

    // 회원가입 폼
    @GetMapping("/register")
    public String registerForm() {
        return "membership/register"; // /WEB-INF/views/membership/register.jsp
    }

    // 회원가입 처리
    @PostMapping("/register")
    public String registerSubmit(MemberShipDTO member) {
        dao.insertMember(member);
        return "redirect:/membership/home"; // 회원가입 후 home.jsp로 이동
    }


    // 로그아웃
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/membership/home"; // 로그아웃 후 home.jsp
    }

    // ==============================
    // GET /membership/home → home.jsp 표시
    // ==============================
    @GetMapping("/home")
    public String home(HttpSession session, Model model) {
        Object user = session.getAttribute("user");
        if (user != null) {
            model.addAttribute("user", user);
        }
        return "home"; // /WEB-INF/views/home.jsp
    }

    // ==============================
    // POST /membership/home → home.jsp 로그인 처리
    // ==============================
    @PostMapping("/home")
    public String loginFromHome(@RequestParam String id,
                                @RequestParam String pw,
                                HttpSession session,
                                Model model) {
        MemberShipDTO member = dao.selectMember(id, pw);
        if (member != null) {
            session.setAttribute("user", member);
            model.addAttribute("user", member);
        } else {
            model.addAttribute("error", "아이디 또는 비밀번호가 잘못되었습니다.");
        }
        return "home"; // /WEB-INF/views/home.jsp
    }
    
 // ==============================
    // GET /membership/mypage → mypage.jsp 표시
    // ==============================
    @GetMapping("/mypage")
    public String mypage(HttpSession session, Model model) {
        MemberShipDTO user = (MemberShipDTO) session.getAttribute("user");
        if (user == null) {
            return "redirect:/membership/home"; // 로그인 안 되어 있으면 home으로
        }
        model.addAttribute("user", user);
        return "membership/mypage"; // /WEB-INF/views/membership/mypage.jsp
    }

    // ==============================
    // POST /membership/update → 회원정보 수정 처리
    // ==============================
    @PostMapping("/update")
    public String updateMember(MemberShipDTO member,
                               @RequestParam(required = false) String passwordCheck,
                               HttpSession session,
                               Model model) {

        // 비밀번호가 입력되어 있으면 확인 체크
        if (member.getPw() != null && !member.getPw().isEmpty()) {
            if (!member.getPw().equals(passwordCheck)) {
                model.addAttribute("error", "비밀번호가 일치하지 않습니다.");
                model.addAttribute("user", member);
                return "membership/mypage"; // 불일치 시 다시 mypage.jsp
            }
        }

        // DAO에서 업데이트
        dao.updateMember(member);

        // DB에서 최신 정보 가져와 세션 갱신
        MemberShipDTO updatedUser = dao.selectMemberById(member.getId());
        session.setAttribute("user", updatedUser);
        model.addAttribute("user", updatedUser);

        return "membership/mypage";
    }
    
 // 회원탈퇴
    @GetMapping("/delete")
    public String deleteMember(HttpSession session, Model model) {
        MemberShipDTO user = (MemberShipDTO) session.getAttribute("user");
        if(user != null) {
            dao.deleteMember(user.getId());   // DB에서 삭제
            model.addAttribute("user", user); // JSP에서 메시지용
            session.invalidate();             // 세션 종료
        }
        return "membership/delete";           // 탈퇴 완료 페이지로 이동
    }
}
