package com.mid.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mid.common.Controller;
import com.mid.common.Utils;
import com.mid.service.MemberService;
import com.mid.vo.Member;

public class LoginOutController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 로그아웃
		HttpSession session = req.getSession(false); // 없으면 null리턴
		if (session != null && session.getAttribute("id") != null) {// 로그인 한 상태
			System.out.println("logout.");
			session.invalidate(); // 세션삭제
			resp.sendRedirect("main.do");
			return;
		}

		// 로그인
		String id = req.getParameter("memberId");
		String pw = req.getParameter("memberPw");

		MemberService service = MemberService.getInstance();
		Member vo = service.getMember(id);

		// 로그인 실패 : id가 없거나 pw가 맞지 않는 경우 
		if (vo == null || !vo.getPw().equals(pw)) {
			req.setAttribute("error", "아이디 또는 비밀번호를 잘못 입력했습니다.<br>"
					+ "입력하신 내용을 다시 확인해주세요.");
			Utils.forward(req, resp, "loginForm.do");
		} else {
			System.out.println("login.");
			session.setAttribute("id", id);
			
			resp.sendRedirect("memberMypage.do");//마이페이지로 가던가.. 홈으로 가던가..
		}
	}

}
