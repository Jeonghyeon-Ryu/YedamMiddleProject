<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
.delete-info {
	width:80%;
	max-width:600px;
	margin : 50px auto;
	text-align:center;
}
.delete-info input, button{
	margin:20px 5px; 
	padding :10px; 
	border : 1px solid lightgray;
	border-radius:5px; 
}
.delete-info input[type='submit']:hover{
	margin:20px 5px; 
	padding :10px; 
	border : 1px solid lightgray;
	border-radius:5px; 
	background:darkred;
	color:white;
}
.delete-info label{
	margin:20px; 
	padding :10px; 
}
span{
color:red;}
</style>
<div class="delete-info">
	<form id="newInfo-input" action="deleteMember.do" method="post">
		<h2>${id}�� ���� <span>Ż��</span>�Ͻðڽ��ϱ�?</h2>
        <h5>ȸ�������� ������ ���� ��й�ȣ�� ���Է��� �ּ���</h5>
        <label for="memberPw">��й�ȣ</label><input type="password" id="delete-pw" name="delete-pw">
        <input type="hidden" name="memberId" value="${id }">
        <input type="submit" id="deletInfo-btn" value="ȸ��Ż��">
        <c:if test="${!empty deleteMsg}">
			<h3>${deleteMsg}</h3>
		</c:if>
     </form>
</div>