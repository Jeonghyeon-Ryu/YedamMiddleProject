<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>qnaDetail.jsp</title>
<link href="${pageContext.request.contextPath}/css/qna.css" rel="stylesheet">

</head>
<body>
<div class="qna-box">
	<div class="qna-detail-title">
		<h3>${qna.title}</h3>
	</div>
	<hr>
	<div class="qna-detail-content">
		<p>${qna.content}</p>
	</div>
</div>
</body>
</html>