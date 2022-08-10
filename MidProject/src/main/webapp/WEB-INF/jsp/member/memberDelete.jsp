<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form id="newInfo-input" action="updateMemberInfo.do" method="post">
        <h3>회원정보를 삭제를 위해 비밀번호를 재입력해 주세요</h3>
        <label for="memberPw">비밀번호</label> 
        <input type="password" id="memberPw" name="memberPw">
        <p style="color:red;" id="pw-error" class="info-error"></p>
        
        <input type="hidden" name="memberId" value="${id }">
        <input type="hidden" name="job" value="pwUpdate">
        <input type="button" id="updatePw-btn" onclick="upDatePwChk()" value="수정">
     </form>
</body>
</html>