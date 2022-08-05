<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberMypage.jsp</title>
<script src="https://kit.fontawesome.com/9f16a06d13.js" crossorigin="anonymous"></script>
<link href="${pageContext.request.contextPath}/css/mypage.css" rel="stylesheet">

</head>
<body>
<div id="mypage-box">
	<div id="profile-photo">
	    <img src() height="48" width="48"> 
	    
	    <form action="login.do">
	        <button type="submit" id="mypage-logout">로그아웃</button>
	    </form>     
	</div>
	
	<div id="progile-comment">      
	    <h3>${id }</h3>
	</div>
	
	<div class="mypage-info" id="info">
	    <h2>나의 정보</h2>
	    <ul>
	        <li><a href="#"><i class="fa-solid fa-user"></i>  개인정보<span>></span></a></li>
	        <li><a href="#"><i class="fa-solid fa-clipboard-list"></i>  예약내역<span>></span></a></li>
	        <li><a href="#"><i class="fa-solid fa-file-pen"></i>  후기관리<span>></span></a></li>
	    </ul>        
	</div>
	<hr>
	<div class="mypage-center" id="customer-center">
	    <h2>고객센터</h2>
	    <ul>
	        <li><a href="#"><i class="fa-solid fa-circle-question"></i>  QnA<span>></span></a></li>
	        <li><a href="#"><i class="fa-solid fa-headset"></i>  1:1 문의<span>></span></a></li>
	    </ul>
	</div>
</div>
</body>
</html>