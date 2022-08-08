<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberInfo.jsp</title>
<style>
.update-info div {
	height:100%;
	margin: 40px 20px;
}
.update-info .update-title{margin:30%}
.update-info .update-info{
	padding:40px 20px;
}
.update-info label,.update-info input{margin-left:20px;}
.update-info ul{list-style:none;}
.update-info hr{
	color: lightgray;
	margin: 20px;
	border: 0.1px solid lightgray;}
</style>
</head>
<body>
	<div class="update-info" id="info">
		<div id="update-title">
	   		<h2>개인 정보</h2>
	    </div>
	    <c:set var="member" value="${member}"/>
	    <div class="update-content">
		     <form id="update-info-frm" action="updateMemberInfo.do">
			    	<label for="memberId">아이디</label><br>
			        	<input type="text" name="memberId" value="${member.id}" readonly>
			        <hr>
			        <label for="memberNm">이름</label><br>
			        	<input type="text" name="memberNm" value="${member.name}">
			        <hr>
			        <label for="phone1">전화번호</label><br>
			       		<input type="text" id="phone1" name="phone1" value="${phone1}" maxlength="3" size=4> - 
						<input type="text" id="phone2" name="phone2" value="${phone2}" maxlength="4" size=4> - 
						<input type="text" id="phone3" name="phone3" value="${phone3}" maxlength="4" size=4>
			        <hr>
			        <label for="memberPw">현재 비밀번호</label><br>
			        	<input type="password" id="memberPw" name="memberPw">
				        <input type="hidden" name="present-pwChk" value="${member.pw}">
			        <hr>
			        <label for="new-memberPw">새 비밀번호</label><br>
			        	<input type="password" id="new-memberPw" name="new-memberPw">
			        	<p style="display: none;" id="pw-error" class="info-error"></p>
			        <hr>
			        <label for="new-memberPw2">비밀번호 확인</label><br>
			        	<input type="password" id="new-memberPw2" name="new-memberPw2">
			       		<p style="display: none;" id="pw2-error" class="info-error"></p>
			            
			    <input type="hidden" name="job" value="infoUpdate">
			    <input type="submit" onclick="upDatePwChk()" value="수정">
			    <input type="button" onclick="location.href='mypage.do'" value="뒤로가기">
			  </form>
			  <p style="display: none;" id="no-pw-error" class="info-error">
			  <c:if test="${!empty msg}">
			  	<p>${msg}</p>
			  </c:if>
		  </div>
	</div>
	<hr>
</body>
<script>
let pw1 = document.getElementById("new-memberPw");
let pw2 = document.getElementById("new-memberPw2");
pw1.onchange = pwChk();
pw2.onchange = pw2Chk();

/* 현재 비밀번호 또는 새 비밀번호 중 하나만 입력된 경우 false*/
function pw0Chk(){
	let pw = document.getElementById("memberPw");
	if((pw&&pw1)||(!pw&&!pw1)){
		return true;
	}else{
		document.getElementById("no-pw-error").style.display = 'flex';
		document.getElementById('no-pw-error').innerText = "비밀번호를 입력해주세요.";
		return false;
	}
}
function pwChk() {
	let regExp = /^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[$`~!@$!%*#^?&\\(\\)\-_=+]).{8,16}$/;
	document.getElementById("pw2-error").style.color = 'red';
	if (pw1.value.length1 < 8 || pw1.value.length1 > 16) {
		document.getElementById("pw-error").style.display = 'flex';
		document.getElementById('pw-error').innerText = "8자리 ~ 16자리 이내로 입력해주세요.";
		pw1.value = "";
		return false;
	} else if (!regExp.test(pw1.value)) {
		document.getElementById("pw-error").style.display = 'flex';
		document.getElementById('pw-error').innerText = "영문,숫자,특수문자를 포함하여 입력하세요.";
		pw1.value = "";
		return false;
	} else {
		document.getElementById("pw-error").style.display = 'none';
		return true;
	}
}


function pw2Chk() {
	if (pw1.value != pw2.value) {
		document.getElementById("pw2-error").style.display = 'flex';
		document.getElementById('pw2-error').innerText = '비밀번호가 일치하지 않습니다.';
		document.getElementById("pw2-error").style.color = 'red';
		pw2.value = "";
		return false;
	} else {
		document.getElementById("pw2-error").style.display = 'none';
		return true;
	}
}
function upDatePwChk(){
	pw2Chk;
	pw0Chk;
	if(pw0Chk()&&pw2Chk()){
		document.getElementById('update-info-frm').submit();
	}
}
</script>
</html>