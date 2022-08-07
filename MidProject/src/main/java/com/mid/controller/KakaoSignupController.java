package com.mid.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mid.common.Controller;
import com.mid.common.SHA256;
import com.mid.service.MemberService;
import com.mid.vo.Member;

public class KakaoSignupController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		String birth = req.getParameter("birth");
		String phone = req.getParameter("phone");
		String kakaoId = req.getParameter("kakaoId");
		String naverId = req.getParameter("naverId");
		
		pw = SHA256.encodeSha256(pw);
		
		Member member = new Member();
		member.setId(id);
		member.setPw(pw);
		member.setName(name);
		member.setKakaoId(id);
		// 생일 저장 생각해봐야함 
		member.setPhone(phone);
		
		MemberService service = MemberService.getInstance();
		if(kakaoId!=null) {
			member.setKakaoId(kakaoId);
			service.signupKakao(member);
		} else if(naverId!=null) {
			member.setNaverId(naverId);
			service.signupNaver(member);
		}
		
				
	}
}
