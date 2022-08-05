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
.loginError{color: red; font-size:0.9em;}
.modal-box{padding : 10px; max-width :400px; margin:0 auto; text-align:center;}
</style>
<body>
	<div class="modal-box">
		<!-- Modal Title -->
		<div class="modal-title">

			<h5>로그인 또는 회원가입</h5>
			<div class="modal-close-button"><a href="main.do">
				<img src="img/close-20.png"></a>
			</div>
		</div>
		<div class="modal-content">
			<form id="frm" name="frm" action="login.do">
				<div class="loginId">
					<i for="memberId" class="fa-solid fa-user"></i> <input type="text" id="memberId"
						name="memberId" placeholder="아이디" autofocus required>
				</div>
				<div class="loginPw">
					<i class="fa-solid fa-lock"></i> <input type="password" id="memberPw"
						name="memberPw" placeholder="비밀번호" required>
				</div>
				<span class="loginError">${error}</span><br>
				<input type="submit" value="로그인">
			</form>
			<div>
				<a href="findInfo.html">아이디/비밀번호 찾기</a>
				<a href="memberAgreement.do">회원가입</a>
			</div>
			<hr>
			<button type="button" id="kakao-login-bnt" class="btn-kakao">
				<span> <a href="#"> <i class="icon_login_kakao"></i>카카오로 로그인</a>
				</span>
			</button><br>
			<button type="button" id="naver-login-bnt" class="btn-naver">
				<span> <a href="#"><i class="icon_login_naver"></i> 네이버로 로그인</a>
				</span>
			</button>
		</div>
	</div>
<script type="text/javascript">
	
</script>
</body>
</html>
