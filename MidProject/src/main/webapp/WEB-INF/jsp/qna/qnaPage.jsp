<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자주 묻는 질문 qna</title>
<style>
.qna-box .qna-content{
	height:100%;
	position:relative;
	max-width:768px;
	margin:auto;
	padding-top:48px;
	background-color:lightgray;
}
.qna-box .qna-category{
	display:inline;
	background-color: white;
}
</style>
</head>
<body>
<div class="qna-box">
	<div class="qna-title">
		<h2>자주 묻는 질문</h2>
		<div class="modal-close-button"><a href="main.do">
			<img src="img/close-20.png"></a>
		</div>
	</div>
	<div class="qna-content">
		<div class="qna-category-list">
			<div class="qna-category" onclick="showQnAList()">전체</div>
			<div class="qna-category" onclick="showQnAList()">상품/서비스</div>
			<div class="qna-category" onclick="showQnAList()">예약/결제/영수증</div>		
			<div class="qna-category" onclick="showQnAList()">변경/취소/환불</div>
			<div class="qna-category" onclick="showQnAList()">쿠폰/할인</div>
			<div class="qna-category" onclick="showQnAList()">코인/포인트</div>
			<div class="qna-category" onclick="showQnAList()">후기/댓글</div>
			<div class="qna-category" onclick="showQnAList()">회원/개인정보</div>
			<div class="qna-category" onclick="showQnAList()">믿고쓰는 여기서자바</div>
		</div>
		<div class="qna-list"></div>
	</div>
	<div class="qna-list-items">
		<c:forEach var="vo" items="${list}">
				<tr>
					<td><a href="boardDetail.do?id=${vo.seq}">${vo.seq}</a></td>
					<td>${vo.title}</td>
					<td>${vo.writer}</td>
					<td>${vo.date}</td>
					<td>${vo.visitCnt}</td>
				</tr>
		</c:forEach>
	</div>
</div>
<script>

function showQnAList(e){
	let click = event.target;
  	let clickNm = click.innerText;
	console.log(clickNm);
	
	let qnaAjx = new XMLHttpRequest(); //send
	qnaAjx.open('post', 'GetQnAListController.do');
	qnaAjx.setRequestHeader('Content-type','application/x-www-form-urlencoded');
	qnaAjx.send('dategoryNm=' + clickNm);
	qnaAjx.onload = function() {

        delBtn.parentElement.parentElement.remove();
        alert("삭제되었습니다");

     }

}
showQnAList();
</script>
</body>
</html>