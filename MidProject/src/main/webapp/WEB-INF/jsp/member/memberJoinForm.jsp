<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보입력</title>
<link href="${pageContext.request.contextPath}/css/memberAgreement.css" rel="stylesheet">
</head>
<style>
.mInfo-input {
	border-bottom: 1px solid lightgray;
	padding: 10px;
	text-align: left;
	width:100%;
	margin:0;
	display:flex;
	flex-wrap: wrap;
}
#agree-frm{
width:100%}
.mInfo-input input {
	border:1px solid lightgray;
	border-radius:3px;
	}

.mInfo-input p {
	text-align: center;
	font-size: 0.9em;
	color: red;
}
	
.mInfo-input label {
	width: 100px;
}

.identi, .phone {
	border: 1px solid lightgray;
	width: 50px;
}

.joinForm-bnt {
	text-align: center;
}
.agreement-box .big-btn{width:40%}
</style>
<body>
	<div class="agreement-box">
		<div class="mInfo-title">
				<h4>회원가입</h4>
			</div>
			<div>
				<form id="agree-frm" name="mInfo-frm" action="memberJoin.do"
					method="post">
					<div class="mInfo-input">
						<label for="join-id" style="width:60px;">아이디</label> 
						<input type="text" id="join-id" name="join-id">&nbsp;
						<button type="button" id="idCheck" name="idCheck" onclick="javascript:IdCheck();" style="width:70px">중복체크</button>
						<p style="flex-wrap: wrap;" id="idMsg" class="info-error"></p>
					</div>
					<div class="mInfo-input">
						<label for="join-nm" style="width:60px">이름</label> 
						<input type="text" id="join-nm" name="join-nm">
					</div>
					<div class="mInfo-input">
						<label for="identi">주민번호</label> <input type="text" class="identi"
							id="identi" name="identi" size="6" maxlength="10"> - <input
							type="password" class="identi" id="identi2" name="identi2"
							size="7" maxlength="10">
						<p style="display: none;" id="identi-error" class="info-error">
						</p>
					</div>
					<div class="mInfo-input">
						<label for="join-pw">비밀번호</label> <input type="password"
							id="join-pw" name="join-pw">
						<p style="display: none;" id="pw-error" class="info-error"></p>
					</div>
					<div class="mInfo-input">
						<label for="join-pw2">비밀번호 확인</label> <input type="password"
							id="join-pw2" name="join-pw2">
						<p style="display: none;" id="pw2-error" class="info-error"></p>
					</div>
					<div class="mInfo-input">
						<label for="phone1">연락처</label> <input type="text" class="phone"
							id="phone1" name="phone1" maxlength="4" size=4> - <input
							type="text" class="phone" id="phone2" name="phone2" maxlength="4"
							size=4> - <input type="text" class="phone" id="phone3"
							name="phone3" maxlength="4" size=4>
						<p style="display: none;" id="phone-error" class="info-error">
						</p>
					</div>

					<br>
					<div class="joinForm-bnt">
						<button type="button" class="big-btn" onclick="frmChk();">회원가입</button>
						&nbsp;&nbsp;&nbsp;
						<button type="reset" class="big-btn">다시입력</button>
						&nbsp;&nbsp;&nbsp;
					</div>
				</form>
			</div>
		</div>
	<script src="${pageContext.request.contextPath}/js/memberJoinForm.js"></script>
</body>
</html>