<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" type="text/css" href="css/socialLinkLoginForm.css">
	<div class="kakaologin-container">
		<div class="login-box">
			<div class="user-icon">
				<img src="img/kakaologin-100.png" class="far fa-user" />
			</div>
			<form action="kakaoSignup.do" class="login">
				<input type="text" value="${naverId}" name="naverId" style="display:none">
				<div class="form-group">
					<c:if test="${!empty kakaoId }"><input type="text" value="${kakaoId }" name="id" class="form-control" readonly></c:if>
					<c:if test="${empty kakaoId }"><input type="text" placeholder="아이디" name="id" class="form-control"></c:if>
				</div>
				<div class="form-group">
					<input type="password" placeholder="비밀번호" name="pw" class="form-control">
				</div>
				<div class="form-group">
					<input type="password" placeholder="비밀번호 확인" name="pw-confirm" class="form-control">
				</div>
				<div class="form-group">
					<input type="text" placeholder="이름" name="name" class="form-control">
				</div>
				<div class="form-group">
					<input type="text" placeholder="생년월일" name="birth" class="form-control">
				</div>
				<div class="form-group">
					<input type="tel" placeholder="010-0000-0000" name="phone" class="form-control">
				</div>
				<div class="form-group">
					<button class="full-btn">회원가입 완료</button>
				</div>
			</form>
		</div>
	</div>
