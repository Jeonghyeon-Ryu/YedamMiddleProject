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
        <h3>ȸ�������� ������ ���� ��й�ȣ�� ���Է��� �ּ���</h3>
        <label for="memberPw">��й�ȣ</label> 
        <input type="password" id="memberPw" name="memberPw">
        <p style="color:red;" id="pw-error" class="info-error"></p>
        
        <input type="hidden" name="memberId" value="${id }">
        <input type="hidden" name="job" value="pwUpdate">
        <input type="button" id="updatePw-btn" onclick="upDatePwChk()" value="����">
     </form>
</body>
</html>