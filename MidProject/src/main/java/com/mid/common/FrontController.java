package com.mid.common;

import java.io.IOException;
import java.util.HashMap;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mid.controller.AjaxMemberIdCheck;
import com.mid.controller.LoginFormController;
import com.mid.controller.LoginOutController;
import com.mid.controller.MainController;
import com.mid.controller.MypageController;
import com.mid.controller.memberAgreementController;
import com.mid.controller.memberJoinController;


public class FrontController extends HttpServlet {

	String charset = null;
	HashMap<String, Controller> mappings = null;

	@Override
	public void init(ServletConfig config) throws ServletException {

		charset = config.getInitParameter("charset");
		mappings = new HashMap<String, Controller>();
		mappings.put("/main.do", new MainController());
		mappings.put("/loginForm.do", new LoginFormController());	//로그인폼
		mappings.put("/login.do", new LoginOutController());		//로그인,로그아웃
		mappings.put("/memberJoin.do", new memberJoinController());	//회원가입
		mappings.put("/memberAgreement.do", new memberAgreementController());	//회원가입약관동의
		mappings.put("/memberMypage.do", new MypageController());	//마이페이지
		mappings.put("/ajaxMemberIdCheck.do", new AjaxMemberIdCheck()); // 아이디 중복 체크.
		
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding(charset);

		String url = req.getRequestURI();
		String contextPath = req.getContextPath();
		String path = url.substring(contextPath.length());
		System.out.println(path);

		Controller subControl = mappings.get(path);
		subControl.execute(req, resp);

	}
}
