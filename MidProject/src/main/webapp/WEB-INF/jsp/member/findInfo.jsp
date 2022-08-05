<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>findInfo.jsp</title>
<link href="${pageContext.request.contextPath}/css/modal.css" rel="stylesheet">
<style>
#findInfo-box{max-width :400px; margin:0 auto; }
</style>
</head>
<body>
<div id="findInfo-box">
	<div class="modal-box">
		<!-- Modal Title -->
		<div class="modal-title">

			<h5>아이디/비밀번호 찾기</h5>
			<div class="modal-close-button"><a href="main.do">
				<img src="img/close-20.png"></a>
			</div>
		</div>
		<div class="modal-content">
			<form id="frm" name="frm" action="findInfo.do">
				<p>아이디 찾기</p>
				<input type="hidden" name="job" value="searchId">
				<div class="searchId">
					<label id="memberNm">이름</label>
					<input type="text" id="memberNm" name="memberNm" >
				</div>
				<div class="searchId">
					<label id="memberPhone">전화번호</label>
					<input type="text" id="memberPhone" name="memberPhone" >
				</div>
				<p id="findId-error" style="display:none"></p>
				<input type="submit" value="아이디 찾기">
			</form>
		</div>
		<c:if test='${!empty list}'>
			<c:forEach var="vo" items="${list}">
				<p>${vo.id}</p>
			</c:forEach>
		</c:if>
		<c:otherwise>
			<p>${error }</p>
		</c:otherwise>
		<div class="modal-content">
			<form id="frm" name="frm" action="findInfo.do">
				<p>비밀번호 찾기</p>
				<input type="hidden" name="job" value="searchPw">
				<div class="searchPw">
					<label id="memberNm">이름</label>
					<input type="text" id="memberNm" name="memberNm" >
				</div>
				<div class="searchPw">
					<label id="memberId">아이디</label>
					<input type="text" id="memberId" name="memberId" >
				</div>
				<div class="findId">
					<label id="memberPhone">전화번호</label>
					<input type="text" id="memberPhone" name="memberPhone" >
				</div>
				<p id="findPw-error" style="display:none"></p>
				<input type="submit" value="비밀번호 찾기">
			</form>
		</div>
	</div>
</div>
</body>
</html>