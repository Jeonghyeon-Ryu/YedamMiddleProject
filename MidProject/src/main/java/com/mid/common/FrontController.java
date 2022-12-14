package com.mid.common;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mid.controller.AddContentController;
import com.mid.controller.AjaxBusinessIdCheckController;
import com.mid.controller.AjaxMemberIdCheck;
import com.mid.controller.BusinessJoinController;
import com.mid.controller.BusinessSignupController;
import com.mid.controller.CompDetailController;
import com.mid.controller.DeleteAccController;
import com.mid.controller.DeleteMemberController;
import com.mid.controller.DeleteMemberInfoController;
import com.mid.controller.DeleteRoomController;
import com.mid.controller.ExTourListController;
import com.mid.controller.FindInfoController;
import com.mid.controller.FindInfoFormController;
import com.mid.controller.GetQnaListController;
import com.mid.controller.GetReservationListController;
import com.mid.controller.GetReviewScoreController;
import com.mid.controller.InsertAccController;
import com.mid.controller.InsertReservationController;
import com.mid.controller.InsertRoomController;
import com.mid.controller.KakaoLoginController;
import com.mid.controller.KakaoSignupController;
import com.mid.controller.KakaoSignupFormController;
import com.mid.controller.LoginOutController;
import com.mid.controller.MainController;
import com.mid.controller.MemberAgreementController;
import com.mid.controller.MemberInfoController;
import com.mid.controller.MemberJoinController;
import com.mid.controller.MemberJoinFormController;
import com.mid.controller.MessageController;
import com.mid.controller.MypageController;
import com.mid.controller.NaverLoginController;
import com.mid.controller.NaverSignupFormController;
import com.mid.controller.QnaDetailController;
import com.mid.controller.QnaListController;
import com.mid.controller.ReservationPageController;
import com.mid.controller.ReviewDeleteController;
import com.mid.controller.ReviewInsertController;
import com.mid.controller.ReviewOpenController;
import com.mid.controller.ReviewUpdateController;
import com.mid.controller.SelectAccListController;
import com.mid.controller.SelectAccListCountController;
import com.mid.controller.SendContentController;
import com.mid.controller.SocialLinkController;
import com.mid.controller.UpdateAccController;
import com.mid.controller.UpdateMemberInfoController;
import com.mid.controller.UpdateRoomController;
import com.mid.controller.businessManageFormController;
import com.mid.controller.getWishController;
import com.mid.controller.getWishOneController;
import com.mid.controller.setWishController;

public class FrontController extends HttpServlet {

	String charset = null;
	HashMap<String, Controller> mappings = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		
		charset = config.getInitParameter("charset");
		mappings = new HashMap<String, Controller>();
    
		// 류정현
		mappings.put("/main.do", new MainController());				// 메인 진입
		mappings.put("/insert.do", new InsertController());			// 공공데이터 DB Parsing 관련 1회용	
		mappings.put("/accList.do", new SelectAccListController());	// 숙소 리스트 출력
		mappings.put("/accListCount.do", new SelectAccListCountController());	// 필터 적용 리스트 갯수 확인 
		mappings.put("/kakaoLogin.do", new KakaoLoginController());	// 카카오 로그인( 토큰 발급 + 유저데이터 통합함 )
		mappings.put("/socialLinkLogin.do", new SocialLinkController());	// 카카오 로그인 연동하기
		mappings.put("/kakaoSignupForm.do", new KakaoSignupFormController());	// 카카오 연동 간편 회원가입 폼
		mappings.put("/kakaoSignup.do", new KakaoSignupController());	// 카카오 연동 간편회원가입
		mappings.put("/naverLogin.do", new NaverLoginController());	// 네이버 로그인( 토큰 발급 + 유저데이터 통합함 )
		mappings.put("/naverSignupForm.do", new NaverSignupFormController());	// 네이버 연동 간편 회원가입 폼
		mappings.put("/setWish.do", new setWishController());	// 위시리스트 추가
		mappings.put("/getWish.do", new getWishController());	// 위시리스트 보기
		mappings.put("/getWishOne.do", new getWishOneController());	// 위시리스트 보기
		mappings.put("/businessManage.do", new businessManageFormController());	// 위시리스트 보기
		mappings.put("/accUpdate.do", new UpdateAccController());	// Business 페이지 Acc update
		mappings.put("/roomUpdate.do", new UpdateRoomController());	// Business 페이지 Room update
		mappings.put("/accDelete.do", new DeleteAccController());	// Business 페이지 Acc delete
		mappings.put("/roomDelete.do", new DeleteRoomController());	// Business 페이지 Room delete
		mappings.put("/accInsert.do", new InsertAccController());	// Business 페이지 Acc insert
		mappings.put("/roomInsert.do", new InsertRoomController());	// Business 페이지 Room insert
		mappings.put("/getReservationList.do", new GetReservationListController());	// 예약 리스트 가져오기
		mappings.put("/reviewOpen.do", new ReviewOpenController());	// 리뷰 작성 페이지 열기
		mappings.put("/reviewInsert.do", new ReviewInsertController());	// 리뷰 작성
		mappings.put("/reviewUpdate.do", new ReviewUpdateController());	// 리뷰 수정
		mappings.put("/reviewDelete.do", new ReviewDeleteController());	// 리뷰 삭제
		mappings.put("/getReviewScore.do", new GetReviewScoreController());	// 리뷰 삭제
	
		
		// 최유리
		mappings.put("/login.do", new LoginOutController());		// 로그인,로그아웃
		mappings.put("/memberJoinForm.do", new MemberJoinFormController());	//회원가입폼
		mappings.put("/memberJoin.do", new MemberJoinController());	//회원가입 처리
		mappings.put("/memberAgreement.do", new MemberAgreementController());	//회원가입약관동의
		mappings.put("/memberMypage.do", new MypageController());	// 마이페이지
		mappings.put("/findInfoForm.do", new FindInfoFormController());	//회원정보검색페이지
		mappings.put("/findInfo.do", new FindInfoController());	//회원정보검색
		mappings.put("/memberInfo.do", new MemberInfoController());	// 상세 정보
		mappings.put("/updateMemberInfo.do", new UpdateMemberInfoController());	//정보수정
		mappings.put("/deleteMemberInfo.do", new DeleteMemberInfoController());	//회원탈퇴폼
		mappings.put("/deleteMember.do", new DeleteMemberController());	//회원탈퇴
		mappings.put("/idcheckAjax.do", new AjaxMemberIdCheck()); // 아이디 중복 체크.	
		mappings.put("/qnaList.do", new QnaListController());      //qna페이지로
	    mappings.put("/getQnaList.do", new GetQnaListController());   //선택한 카테고리의 qna 리스트반환
	    mappings.put("/qnaDetail.do", new QnaDetailController());   //상세페이지로
		
	    // 배희열
		mappings.put("/message.do", new MessageController());		// 메세지폼
		mappings.put("/sendContent.do", new SendContentController()); //메세지 전송
		mappings.put("/addContent.do", new AddContentController());	// 숙소 리스트 출력
		mappings.put("/businessJoin.do", new BusinessJoinController()); //사업자 가입
		mappings.put("/ajaxBusinessIdCheck.do", new AjaxBusinessIdCheckController()); //사업자 아이디 중복
		mappings.put("/businessSignup.do", new BusinessSignupController()); //사업자 가입 처리
		
		// 엄정웅
		mappings.put("/compDetail.do", new CompDetailController());	// 상세페이지 출력 
		mappings.put("/exTourList.do", new ExTourListController());	// 숙소 리스트 출력
		mappings.put("/reservationPage.do", new ReservationPageController());
		mappings.put("/insertReservation.do", new InsertReservationController());
		
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
