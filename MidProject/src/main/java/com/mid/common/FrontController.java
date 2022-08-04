package com.mid.common;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mid.controller.AjaxMemberIdCheck;
import com.mid.controller.CompDetailController;
import com.mid.controller.ExTourListController;
import com.mid.controller.LoginFormController;
import com.mid.controller.LoginOutController;
import com.mid.controller.MainController;
import com.mid.controller.MemberAgreementController;
import com.mid.controller.MemberJoinController;
import com.mid.controller.MypageController;
import com.mid.controller.ReservationPageController;
import com.mid.controller.SelectAccListController;
import com.mid.controller.MemberJoinFormController;
import com.mid.controller.ExTourListController;
import com.mid.controller.MessageController;
import com.mid.controller.SendContentController;
import com.mid.controller.WishListController;

public class FrontController extends HttpServlet {

	String charset = null;
	HashMap<String, Controller> mappings = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		
		charset = config.getInitParameter("charset");
		mappings = new HashMap<String, Controller>();
    
		mappings.put("/main.do", new MainController());				// 메인 진입
		mappings.put("/message.do", new MessageController());		// 메세지
		mappings.put("/loginForm.do", new LoginFormController());	// 로그인폼
		mappings.put("/login.do", new LoginOutController());		// 로그인,로그아웃
		mappings.put("/memberJoinForm.do", new MemberJoinFormController());	//회원가입폼
		mappings.put("/memberJoin.do", new MemberJoinController());	//회원가입 처리
		mappings.put("/memberAgreement.do", new MemberAgreementController());	//회원가입약관동의
		mappings.put("/memberMypage.do", new MypageController());	// 마이페이지
		mappings.put("/idcheckAjax.do", new AjaxMemberIdCheck()); // 아이디 중복 체크.	
		mappings.put("/sendContent.do", new SendContentController()); //메세지 전송
		mappings.put("/compDetail.do", new CompDetailController());	// 
		mappings.put("/wishList.do", new WishListController());		// 위시리스트
		mappings.put("/insert.do", new InsertController());			// 공공데이터 DB Parsing 관련 1회용
		mappings.put("/accList.do", new SelectAccListController());	// 숙소 리스트 출력
		mappings.put("/exTourList.do", new ExTourListController());	// 숙소 리스트 출력
		mappings.put("/reservationPage.do", new ReservationPageController());	// 숙소 리스트 출력

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
