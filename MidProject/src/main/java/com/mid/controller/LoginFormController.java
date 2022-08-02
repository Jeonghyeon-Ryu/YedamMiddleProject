package com.mid.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mid.common.Controller;
import com.mid.common.Utils;


public class LoginFormController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//로그인 상태일시
		HttpSession session = req.getSession(false); 
		if (session != null && session.getAttribute("id") != null) {// 로그인 한 상태
			Utils.forward(req, resp, "/WEB-INF/jsp/member/memberMypage.jsp");
		}
		Utils.forward(req, resp, "/WEB-INF/jsp/member/memberLoginForm.jsp");
	}

}
