<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
#deletInfo-btn{width:20px;}
#home-btn{width:30px;}
</style>
</head>
<body>
	<form id="newInfo-input" action="deleteMember.do" method="post">
		<h2>정말 탈퇴하시겠습니까?</h2>
        <h3>회원정보를 삭제를 위해 비밀번호를 재입력해 주세요</h3>
        <label for="memberPw">비밀번호</label> 
        <input type="password" id="pwChk" name="pwChk">
        <p style="color:red;" id="pw-error" class="info-error"></p>
        
        <input type="hidden" name="memberPw" value="${presentPw }">
        <input type="hidden" name="memberId" value="${id }">
        <input type="button" id="deletInfo-btn" onclick="upDatePwChk()" value="회원탈퇴">
        <input type="button" id="home-btn" onclick="location.href='main.do'" value="홈으로">
     </form>
</body>
</html>