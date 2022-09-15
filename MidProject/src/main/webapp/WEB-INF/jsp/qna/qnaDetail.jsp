<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>qnaDetail.jsp</title>
<link href="${pageContext.request.contextPath}/css/qna.css"
	rel="stylesheet">
</head>
<body>
	<div class="qna-box">
		<div class="close-button" style="float: right">
			<a href="qnaList.do"><img src="img/close-20.png"></a>
		</div>
		<div class="qna-detail-title" style="clear: both">
			<h3>${qna.title}</h3>
		</div>
		<hr>
		<div class="qna-detail-content" style="margin: 20px">
			<p>${qna.content}</p>
		</div>
	</div>
</body>
</html>