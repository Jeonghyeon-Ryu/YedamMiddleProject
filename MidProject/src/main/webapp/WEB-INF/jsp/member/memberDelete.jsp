<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>deleteMember</title>
<style>
#deletInfo-btn{width:20px;}
#home-btn{width:30px;}
</style>
</head>
<body>

<c:if test=${!deleteMsg eq "page"}>
	<form id="newInfo-input" action="deleteMember.do" method="post">
		<h2>���� Ż���Ͻðڽ��ϱ�?</h2>
        <h3>ȸ�������� ������ ���� ��й�ȣ�� ���Է��� �ּ���</h3>
        <label for="memberPw">��й�ȣ</label> 
        <input type="password" id="memberPw" name="memberPw">
        <p style="color:red;" id="pw-error" class="info-error"></p>
        <input type="hidden" name="memberId" value="${id }">
        <input type="button" id="deletInfo-btn" value="ȸ��Ż��">
        <input type="button" id="home-btn" onclick="location.href='main.do'" value="Ȩ����">
     </form>
</c:if>
<c:if test=${msg eq "success" }>
	<h3>Ż�� �Ϸ�Ǿ����ϴ�.</h3>
	<h3>�̿��� �ּż� �����մϴ�.</h3>
</c:if>
</body>
</html>