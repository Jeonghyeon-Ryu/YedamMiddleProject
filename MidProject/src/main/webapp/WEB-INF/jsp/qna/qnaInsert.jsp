<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>QnA 페이지 등록</h3>
	<form action="qnaInsert.do" method="post">
		<label for="qna-title">제목</label>
		<input type="text" id="qna-title" name="qna-title" autofocus required><br>
		<label for="qna-content">내용</label>
		<textarea id="qna-content" name="qna-content"></textarea><br>
		<input type="submit" value="회원가입">
	</form>
</body>
</html>