
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" type="text/css" href="css/kakaoLinkLoginForm.css">
	<div class="kakaologin-container">
		<div class="login-box">
			<div class="user-icon">
				<img src="img/kakaologin-100.png" class="far fa-user"/>
			</div>
			<div class="serparater"><p>첫 Social 연동 로그인 시도입니다.</p><p>연동을 위해 로그인을 해주세요.</p>
			<c:if test="${!empty error }"><p style="color:red; font-weight:bold;">${error }</p></c:if></div>
			<form action="kakaoLinkLogin.do" class="login">
				<input type="text" name="kakaoId" value="${kakaoId }" style="display:none">
				<div class="form-group">
					<input type="text" placeholder="아이디" name="id" class="form-control">
				</div>
				<div class="form-group">
					<input type="password" placeholder="비밀번호" name="pw" class="form-control">
				</div>
				<div class="form-group">
					<button class="full-btn">로그인</button>
				</div>
			</form>
			<div class="serparater">아이디/비밀번호가 없거나 잊어버리셨나요?</div>
			<div class="social-login">
				<a href="kakaoSignupForm.do?kakaoId=${kakaoId }">
					간편 회원가입
				</a>
				<a href="">
					아이디/비밀번호 찾기
				</a>
			</div>
		</div>
	</div>
