
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
			<form action="businessSignup.do" class="login">
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
	