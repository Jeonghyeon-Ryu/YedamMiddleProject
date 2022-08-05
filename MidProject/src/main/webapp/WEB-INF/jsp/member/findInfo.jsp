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
#findInfo-box{max-width :400px; margin:0 auto;}

#findInfo-box label{float:left;width : 100px}
#findInfo-box input{
float:left:
  width: 150px;
  border: 1px solid #aaa;
  border-radius: 5px;
  padding: 2px;
  margin: 5px 10px;
}
.search-error-msg{color :red}
#findInfo-box .modal-content{
max-height:none; padding :10px}
#findInfo-box input[type='submit']{float:right;}
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
			<form id="idSearch-frm" name="frm" action="findInfo.do">
				<h3>아이디 찾기</h3>
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
			<div class="searchedId-box" id="searchedId-box1">
			<p class="search-error-msg">${error}</p>
			<c:forEach var="vo" items="${list}">
				<p>${vo.id}</p>
			</c:forEach>
			</div>
			<form id="frm" name="frm" action="findInfo.do">
				<h3>비밀번호 찾기</h3>
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
		<div class="searchedId-box" id="searchedId-box2"></div>
	</div>
</div>
<script>
funtion findById(){
	fetch('../findInfo.do',{	//서블릿호출
		method : 'post',
		headers : {'Content-type':'application/x-www-form-urlencoded'},
		body : 'nm='+name+'&ph='+phone
	})	
	.then(result => result.text())
	.then(result => console.log(result))
	.catch(err => console.log(err))	
}
</script>
</body>
</html>