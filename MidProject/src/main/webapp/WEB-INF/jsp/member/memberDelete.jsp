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
		<h2>���� Ż���Ͻðڽ��ϱ�?</h2>
        <h3>ȸ�������� ������ ���� ��й�ȣ�� ���Է��� �ּ���</h3>
        <label for="memberPw">��й�ȣ</label> 
        <input type="password" id="pwChk" name="pwChk">
        <p style="color:red;" id="pw-error" class="info-error"></p>
        
        <input type="hidden" name="memberPw" value="${presentPw }">
        <input type="hidden" name="memberId" value="${id }">
        <input type="button" id="deletInfo-btn" onclick="upDatePwChk()" value="ȸ��Ż��">
        <input type="button" id="home-btn" onclick="location.href='main.do'" value="Ȩ����">
     </form>
</body>
</html>