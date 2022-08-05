<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberInfo.jsp</title>
</head>
<body>
	<div class="mypage-info" id="info">
	    <h2>나의 정보</h2>
	    <ul>
	        <li><i class="fa-solid fa-user"></i>  이름<p class="mInfo-update">수정</p></a>
	        	<p>${member.name}</p></li>
	        <li><i class="fa-solid fa-clipboard-list"></i>  전화번호<p class="mInfo-update">수정</p></a>
	        	<p>${member.phone}</p></li>
	    </ul>        
	</div>
	<hr>
</body>
<script>
</script>
</html>