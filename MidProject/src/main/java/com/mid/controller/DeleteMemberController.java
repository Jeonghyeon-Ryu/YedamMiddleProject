package com.mid.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mid.common.Controller;
import com.mid.common.SHA256;
import com.mid.common.Utils;
import com.mid.service.MemberService;
import com.mid.vo.Member;

public class DeleteMemberController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberService service = MemberService.getInstance();
		Member member = new Member();
		String id = req.getParameter("id");
		String pw = req.getParameter("memberPw");
		member = service.getMember(id);
		pw = SHA256.encodeSha256(pw);
		
		//비밀번호가 맞지 않을경우 그냥 리턴
		if(!pw.equals(member.getPw())) {
			Utils.forward(req, resp, "deleteMemberInfo.do");
		}else {
			req.setAttribute("msg", "success");
			Utils.forward(req, resp, "deleteMemberInfo.do");
		}
	}

}
