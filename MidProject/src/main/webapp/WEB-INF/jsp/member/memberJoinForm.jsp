<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보입력</title>
<link href="${pageContext.request.contextPath}/css/modal.css" rel="stylesheet">
</head>
<style>
	#minfo-box{max-width :400px; margin:0 auto; }
	.mInfo-input{border-bottom:1px solid lightgray ; padding : 10px; text-align: left;}
	.mInfo-input input{border: none;}
	.mInfo-input p{text-align:center; font-size : 0.9em; color:red;}
	.mInfo-input label{width : 180px}
	.identi, .phone{border:1px solid lightgray; width : 50px;}
	.joinForm-bnt{text-align:center;}
</style>
<body>
<div id="minfo-box">
<div class="modal-box">
     <div class="modal-title">
		<h4>회원가입</h4>
	</div>	
	<div>
		<form id="mInfo-frm" name="mInfo-frm" action="memberJoin.do" method="post">
			<div class="mInfo-input">
				<label for="memberId">아이디</label> 
				<input type="text"id="memberId" name="memberId">&nbsp;
				<button type="button" id="idCheck" name="idCheck" onclick="javascript:IdCheck();">중복체크</button>
				<p style="display: none;" id="idMsg" class="info-error"></p>
			</div>
			<div class="mInfo-input">
				<label for="memberNm">이름</label> 
				<input type="text" id="memberNm" name="memberNm">
			</div>
			<div class="mInfo-input">
				<label for="identi">주민번호</label> 
				<input type="text" class="identi" id="identi" name="identi" size="6" maxlength="10">
				- <input type="password" class="identi" id="identi2" name="identi2" size="7" maxlength="10">
				<p style="display: none;" id="identi-error" class="info-error"> </p>
			</div>
			<div class="mInfo-input">
				<label for="memberPw">비밀번호</label> 
				<input type="password" id="memberPw" name="memberPw" >
				<p style="display: none;" id="pw-error" class="info-error"> </p>
			</div>
			<div class="mInfo-input">
				<label for="memberPw2">비밀번호 확인</label> 
				<input type="password" id="memberPw2" name="memberPw2" >
				<p style="display: none;" id="pw2-error" class="info-error"> </p>
			</div>
			<div class="mInfo-input">
				<label for="phone1">연락처</label> 
				<input type="text" class="phone" id="phone1" name="phone1" maxlength="4" size=4>
					- <input type="text" class="phone" id="phone2" name="phone2" maxlength="4" size=4>
					- <input type="text" class="phone" id="phone3" name="phone3" maxlength="4" size=4>
				<p style="display: none;" id="phone-error" class="info-error"> </p>
			</div>
		
			<br>
			<div class="joinForm-bnt">
				<button type="button" onclick="frmChk();">회원가입</button>&nbsp;&nbsp;&nbsp;
				<button type="reset">다시입력</button>&nbsp;&nbsp;&nbsp;
				<button type="button" onclick="location.href='main.do'">홈</button>
			</div>
		</form>
	</div>
</div>
<script src="${pageContext.request.contextPath}/js/memberJoinForm.js"></script>
</body>
</html>