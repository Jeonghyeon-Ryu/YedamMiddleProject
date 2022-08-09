
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="css/socialLinkLoginForm.css" rel="stylesheet" type="text/css">
	<div class="kakaologin-container">
		<div class="login-box">
			<div class="user-icon">
				<img src="img/kakaologin-100.png" class="far fa-user"/>
			</div>
			<div class="serparater"><p>사업자등록 페이지</p>
			<c:if test="${!empty error }"><p style="color:red; font-weight:bold;">${error }</p></c:if></div>
			<form action="socialLinkLogin.do" class="login">
				<div class="form-group">
					<input type="text" placeholder="사업자번호" name="bmId" class="form-control">
				</div>
				<div class="form-group">
					<input type="text" placeholder="업체명" name="bmName" class="form-control">
				</div>
					<div class="form-group">
					<input type="text" placeholder="업체주소" name="bmAdr" class="form-control">
				</div>
				<div class="form-group">
					<button class="full-btn">사업자 등록</button>
				</div>
			</form>
		</div>
	</div>
	<nav>
	<div class="nav-container">
		<a href="main.do">
			<div>
				<img src="img/nav-home-25.png">
			</div>
			<div>홈으로</div>
		</a> <a id="nav-wishlist">
			<div>
				<img src="img/nav-heart-25.png">
			</div>
			<div>위시리스트</div>
		</a>
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
