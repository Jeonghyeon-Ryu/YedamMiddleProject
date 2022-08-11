<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberInfo.jsp</title>
<style>
.update-info {
	margin : 20px;
}
.update-info{}
.update-info div {
	height:100%;
	margin: 40px 20px;
}
.update-info .update-title{
	margin-left:30px;}
.update-info .update-info{
	padding:40px 20px;
}
.update-info input, button{
	margin:20px 5px; 
	padding :10px; 
	border : 1px solid lightgray;
	border-radius:5px; 
}
.update-info input:hover, button:hover{
	margin:20px 5px; 
	padding :10px; 
	border : 1px solid lightgray;
	border-radius:5px; 
	background:black;
	color:white;
}
.update-info label{
	margin:20px; 
	padding :10px; 
}

.update-info hr{
	color: lightgray;
	width:100%;
	margin : 10px 0;
	border: 0.1px solid lightgray;
}
.update-info-frm p{margin-left:20px;}
</style>
</head>
<body>
	<div class="update-info" id="info">
		<div id="update-title">
	   		<h2 style="float:left">개인 정보</h2>
	    </div>
	    <c:set var="member" value="${member}"/>
	    <div class="update-content" style="clear:both">
		     <form id="update-info-frm" action="updateMemberInfo.do">
			    	<label for="memberId" style="float:left">아이디</label> 
			        	<input type="text" name="memberId" value="${member.id}" readonly>
			        <hr>
			        <label for="memberNm"style="float:left">이름</label>
			        	<input type="text" name="memberNm" value="${member.name}">
			        <hr>
			        <label for="phone1"style="float:left">전화번호</label>
			       		<input type="text" id="phone1" name="phone1" value="${phone1}" maxlength="3" size=4> - 
						<input type="text" id="phone2" name="phone2" value="${phone2}" maxlength="4" size=4> - 
						<input type="text" id="phone3" name="phone3" value="${phone3}" maxlength="4" size=4>
			        <hr>
			        <label for="memberPw" style="float:left">현재 비밀번호</label>
			        	<input type="password" id="memberPw" name="memberPw">
			        	<input type="hidden" id="presentPw" value="${member.pw}">
			        <hr >
			        <label for="new-memberPw" style="float:left">새 비밀번호</label>
			        	<input type="password" id="new-memberPw" name="new-memberPw">
			        <p style="color:red" id="pw-error" class="info-error" style="cleat:both"></p>
			        <hr>
					<c:if test="${!empty msg}">
						<p style="color:red" style="cleat:both">${msg}</p>
					</c:if>
				    <p style="color:red" id="no-pw-error" class="info-error" style="cleat:both"></p>
			    	<input type="hidden" name="job" value="infoUpdate">
				    <input type="button" onclick="location.href='main.do'" value="홈으로">
			        <button onclick="upDatePwChk()" style="float:left" name="role" value="memberPw">수정</button>
				    <input type="button" onclick="location.href='deleteMemberInfo.do'" style="float:right" value="회원정보 탈퇴">
			  </form>
		  </div>
	</div>
</body>
<script>

function pwChk() {
	const pw = document.getElementById("new-memberPw");
	document.getElementById('pw-error').innerText="";
	let regExp = /^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[$`~!@$!%*#^?&\\(\\)\-_=+]).{8,16}$/;
	if (pw.value.length1 < 8 || pw.value.length1 > 16) {
		document.getElementById('pw-error').innerText = "8자리 ~ 16자리 이내로 입력해주세요.";
		pw1.value = "";
		return false;
	} else if (!regExp.test(pw.value)) {
		document.getElementById('pw-error').innerText = "영문,숫자,특수문자를 포함하여 입력하세요.";
		pw1.value = "";
		return false;
	} else {
		document.getElementById("pw-error").innerText="";
		return true;
	}
}

function upDatePwChk(){
	const pw = document.getElementById("new-memberPw");
	if(!pw.value.equals("")){
		pwChk;
		if(pwChk()){
			document.getElementById('update-info-frm').submit();
		}
	}else{
		document.getElementById('update-info-frm').submit();
	}
}

</script>
</html>