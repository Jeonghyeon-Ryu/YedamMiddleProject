<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.math.BigInteger"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.security.SecureRandom"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String clientId = "KBVX39Y4TiVNOKxAvsL2";//애플리케이션 클라이언트 아이디값";
	String redirectURI = URLEncoder.encode("http://192.168.0.123:8088/MidProject/naverLogin.do", "UTF-8");
	SecureRandom random = new SecureRandom();
	String state = new BigInteger(130, random).toString();
	String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
	apiURL += "&client_id=" + clientId;
	apiURL += "&redirect_uri=" + redirectURI;
	apiURL += "&state=" + state;
	session.setAttribute("state", state);
 %>
<link rel="stylesheet" type="text/css" href="css/reservationModal.css">
<nav>
	<div class="nav-container">
		<a href="main.do">
			<div>
				<img src="img/nav-home-25.png">
			</div>
			<div>홈으로</div>
		</a> 
		<c:if test="${!empty id }">
			<a id="nav-wishlist">
				<div>
					<img src="img/nav-heart-25.png">
				</div>
				<div>위시리스트</div>
			</a>
		</c:if>
		<c:if test="${empty id }">
			<a id="nav-login">
				<div>
					<img src="img/nav-enter-25.png">
				</div>
				<div>로그인</div>
			</a>
		</c:if>
		<c:if test="${!empty id }">
			<a id="nav-reservation">
				<div>
					<img src="img/hotel.png" width="25px">
				</div>
				<div>여행</div>
			</a>
			<a href="message.do">
				<div>
					<img src="img/nav-message-25.png">
				</div>
				<div>메세지</div>
			</a>
			<a id="nav-mypage">
				<div>
					<img src="img/nav-profile-25.png">
				</div>
				<div>프로필</div>
			</a>
			<script src="js/mypage.js"></script>
			<script src="js/reservationModal.js"></script>
		</c:if>
	</div>
</nav>
<div id="wishlist-modal" class="modal modal-overlay" role="dialog">
	<div class="large-modal-box">
		<!-- Modal Title -->
		<div class="modal-title">
			<h5>위시리스트</h5>
			<div class="modal-close-button">
				<img src="img/close-20.png">
			</div>
		</div>
		<!-- Modal Content -->
		<div class="modal-content">
		
		</div>
	</div>
</div>
<template id="wish-template" style="display:none">
	<div class="wish-container">
		<div class="wish-img">
			<img src="">
		</div>	
		<div class="wish-content">
			<div class="wish-title">이름 : <strong></strong></div>
			<div class="wish-address">주소 : <span></span></div>
		</div>
	</div>
</template>
<div id="reservation-modal" class="modal modal-overlay" role="dialog">
	<div class="large-modal-box">
		<!-- Modal Title -->
		<div class="modal-title">
			<h5>예약내역</h5>
			<div class="modal-close-button">
				<img src="img/close-20.png">
			</div>
		</div>
		<!-- Modal Content -->
		<div class="modal-content">
			<div class="row row-cols-1 row-cols-md-2 g-4">
			</div>
		</div>
		<template id="reservation-template">
			<div class="col">
				<div class="card">
					<img src="" class="card-img-top" style="width:100%; height:300px;" alt="...">
					<div class="card-body">
						<h5 class="card-title"></h5>
						<p class="card-text">방 종류 : <span></span></p>
						<p class="card-text">주소 : <span></span></p>
						<p class="card-text">체크인 : <span></span></p>
						<p class="card-text">이용날짜 : <span></span></p>
						<p class="card-text">업체전화 : <span></span></p>
						<p class="card-text">결제금액 : <span></span></p>
						<p class="card-text acc-id" style="display:none;"><span></span></p>
						<p class="card-text room-id" style="display:none;"><span></span></p>
						<button type="button">후기작성
							<span></span>
					        <span></span>
					        <span></span>
					        <span></span>
						</button>
					</div>
				</div>
			</div>
		</template>
	</div>
</div>
<template id="ex-template">
	<div id="exTourList-content">
	<hr>
		<div class="exTourList-content-list" style="cursor: pointer">
		<div id="ex-main">
			<a href=""><img class="exTourList-placeImg"src=""></a>
		</div>
			<div id="ex-list">		
			<div id="ex-title">업체</div>
			<div id="ex-address">주소</div>
			<div id="ex-checkin">체크인</div>
			<div id="ex-checkout">체크아웃</div>
			<div id="ex-name">이용자 이름</div>
			<div id="ex-phone">전화번호</div>
			<div id="ex-price">결제금액</div>
		</div>
		</div>
	</div>
</template>
<div id="login-modal" class="modal modal-overlay" role="dialog">
	<div class="login-modal-box">
		<!-- Modal Title -->
		<div class="modal-content">
			<div class="kakaologin-container">
				<div class="login-box">
					<div class="user-icon">
						<img src="img/kakaologin-100.png" class="far fa-user"/>
					</div>
					<div class="modal-close-button">
						<img src="img/close-20.png">
					</div>
					<div class="serparater"><p>로그인페이지 입니다.</p>
					<p style="color:red; font-weight:bold; display:block;" id="login-error-msg"></p></div>
						<form class="login">
							<div class="form-group">
								<input type="text" placeholder="아이디" name="memberId" id="memberId" class="form-control" autofocus>
							</div>
							<div class="form-group">
								<input type="password" placeholder="비밀번호" name="memberPw" id="memberPw" class="form-control">
							</div>
							<div class="form-group">
								<button class="full-btn" onclick="mainLogin()">로그인</button>
							</div>
						</form>
					<div class="serparater">아이디/비밀번호가 없거나 잊어버리셨나요?</div>
					<div class="social-login">
						<a href="findInfoForm.do">아이디/비밀번호 찾기</a>
						<a href="memberAgreement.do">회원가입</a>
					</div>
					<div class="serparater">소셜 간편 로그인 및 회원가입</div>
					<div id="login-sns">
						<button type="button" id="kakao-login-bnt" onclick="location.href='https://kauth.kakao.com/oauth/authorize?client_id=858c8fa25fe1eb7607a39eb252e16d9a&redirect_uri=http://192.168.0.123:8088/MidProject/kakaoLogin.do?cmd=callback&response_type=code'" class="btn-kakao">
							<img src="img/kakao_login_medium_narrow.png">
						</button>
						<br>
						<button type="button" id="naver-login-bnt" onclick="location.href='<%=apiURL %>'" class="btn-naver">
							<img src="img/naverlogin.png" width="180px">
						</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<div id="mypage-modal" class="modal modal-overlay" role="dialog">
	<div class="large-modal-box">
		<!-- Modal Title -->
		<div class="modal-title">
			<h5>프로필</h5>
			<div class="modal-close-button">
				<img src="img/close-20.png">
			</div>
		</div>
		<!-- Modal Content -->
		<div class="large-modal-content">
			<div id="profile-photo">
				<img src='https://ifh.cc/g/9xPMF4.webp' border='0'height="48" width="48">

				<form action="login.do">
					<button type="submit" id="mypage-logout">로그아웃</button>
				</form>
			</div>

			<div id="progile-comment">
				<h3>${id }</h3>
			</div>

			<div class="mypage-info" id="info">
				<h2>나의 정보</h2>
				<ul>
					<li><a href="memberInfo.do"><i class="fa-solid fa-user"></i> 개인정보<span>></span></a></li>
				</ul>
			</div>
			<hr>
			<div class="mypage-center" id="customer-center">
				<h2>고객센터</h2>
				<ul>
					<li><a href="qnaList.do"><i class="fa-solid fa-circle-question"></i>
							FAQ<span>></span></a></li>
				</ul>
			</div>
			<hr>
			<div class="mypage-center" id="customer-center">
				<h2>사업자</h2>
				<ul>
				<c:if test="${businessId<0}">
					<li><a href="businessJoin.do"><i class="fa-solid fa-circle-question"></i>
							사업자등록<span>></span></a></li>
				</c:if>
				<c:if test="${businessId>=0}">
					<li><a href="businessManage.do"><i class="fa-solid fa-circle-question"></i>
							사업관리<span>></span></a></li>
				</c:if>
				</ul>
			</div>
		</div>
	</div>
</div>

<c:if test="${empty id }"><script src="js/loginModal.js"></script></c:if>