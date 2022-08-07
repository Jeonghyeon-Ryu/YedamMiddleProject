<%@page import="java.math.BigInteger"%>
<%@page import="java.security.SecureRandom"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보입력</title>
<link href="${pageContext.request.contextPath}/css/modal.css" rel="stylesheet">
<script src="https://kit.fontawesome.com/9f16a06d13.js" crossorigin="anonymous"></script>
</head>
<style>
.loginError{color: red; font-size:0.8em;}
#login-box{padding : 10px; max-width :400px; margin:0 auto; text-align:center;}
#login-box input, button{margin: 5px;}
#login-btn{width: 50%; color:white; background:black;}
#login-sns a{text-decoration: none; color:black;}
#login-other-btn{font-size:0.8em;}
</style>
<%
    String clientId = "KBVX39Y4TiVNOKxAvsL2";//애플리케이션 클라이언트 아이디값";
    String redirectURI = URLEncoder.encode("http://localhost:8088/MidProject/naverLogin.do", "UTF-8");
    SecureRandom random = new SecureRandom();
    String state = new BigInteger(130, random).toString();
    String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
    apiURL += "&client_id=" + clientId;
    apiURL += "&redirect_uri=" + redirectURI;
    apiURL += "&state=" + state;
    session.setAttribute("state", state);
 %>
<body>
<div id="login-box">
	<div class="modal-box">
		<!-- Modal Title -->
		<div class="modal-title">

			<h5>로그인 또는 회원가입</h5>
			<div class="modal-close-button"><a href="main.do">
				<img src="img/close-20.png"></a>
			</div>
		</div>
		<div class="modal-content">
			<form id="login-frm" name="login-frm" action="login.do">
				<div class="loginId">
					<label for="memberId"><i class="fa-solid fa-user"></i></label> 
					<input type="text" id="memberId" name="memberId" placeholder="아이디" autofocus>
				</div>
				<div class="loginPw">
					<label for="memberPw"><i class="fa-solid fa-lock"></i></label> 
					<input type="password" id="memberPw"
						name="memberPw" placeholder="비밀번호">
				</div>
				<span class="loginError">${error}</span><br>
				<input id="login-btn" type="submit" value="로그인">
			</form>
			<div id="login-other-btn">
				<a href="findInfoForm.do">아이디/비밀번호 찾기</a> 
				<a href="memberAgreement.do">회원가입</a>
			</div>
			<hr>
			<div id="login-sns">
				<button type="button" id="kakao-login-bnt" onclick="location.href='https://kauth.kakao.com/oauth/authorize?client_id=858c8fa25fe1eb7607a39eb252e16d9a&redirect_uri=http://localhost:8088/MidProject/kakaoLogin.do?cmd=callback&response_type=code'" class="btn-kakao">
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
</body>
</html>
