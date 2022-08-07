package com.mid.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mid.common.Controller;
import com.mid.common.Utils;
import com.mid.service.MemberService;
import com.mid.vo.Member;

public class SocialLinkController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 입력한 아이디, 비밀번호 확인 -> 로그인성공시 해당 아이디에 kakaoId 추가 -> 일치하지 않으면 오류 출력
		String id = req.getParameter("id");
		String pw = req.getParameter("password");
		String kakaoId = req.getParameter("kakaoId");
		String naverId = req.getParameter("naverId");
		
		MemberService service = MemberService.getInstance();
		Member member = service.getMember(id);
		if(member==null) {
			// 로그인 실패
			req.setAttribute("error", "아이디 또는 비밀번호가 일치하지 않습니다.");
			Utils.forward(req, resp, "member/socialLinkLoginForm.tiles");
		} else if(kakaoId != null) {
			// 로그인 성공
			member.setKakaoId(kakaoId);
			service.updateKakao(member);
			req.getSession().setAttribute("id", id);
			resp.sendRedirect("main.do");
		} else if(naverId != null) {
			// 로그인 성공
			member.setNaverId(naverId);
			service.updateNaver(member);
			req.getSession().setAttribute("id", id);
			resp.sendRedirect("main.do");
		}
		
	}

}
