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

public class MemberInfoController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		String id = (String) session.getAttribute("id");
		MemberService service = MemberService.getInstance();
		
		Member vo = new Member();
		vo = service.getMember(id);
		req.setAttribute("error", "정보가 없습니다.");
		req.setAttribute("member",vo);
		Utils.forward(req, resp, "/WEB-INF/jsp/member/findInfo.jsp");

	}

}
