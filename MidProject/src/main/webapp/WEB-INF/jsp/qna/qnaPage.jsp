<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자주 묻는 질문 qna</title>
<link href="${pageContext.request.contextPath}/css/qna.css" rel="stylesheet">
</head>
<body>
<div class="qna-box">
	<div class="qna-title">
		<h2>자주 묻는 질문</h2>
		<div class="close-button"><a href="main.do"><img src="img/close-20.png"></a>
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
		<hr>
		<form action="qnaDetail.do">
			<div class="qna-list-items">
				<p class="qna-detail-bnt"></p>
			</div>
		</form>
	</div>
</div>
<script>
showQnAList();

function showQnAList(e){
	let click = event.target;
  	let clickNm = click.innerText;
	
	fetch('getQnaList.do',{
		method:'post',
		headers:{'Content-type':'application/x-www-form-urlencoded'},
		body:'dategoryNm=' + clickNm
	})
	.then(result => result.json())	//json형태로 받아옴
	.then(qnaList)					//결과를 매개변수로 리스트 출력함수 호출
	.catch(err=>console.log(err))
}

function qnaList(result){
	let listBody = document.querySelector('.qna-list-items');
	while(listBody.hasChildNodes()){	//현재 리스트 삭제
		listBody.removeChild(listBody.firstChild)
	}
	for (let i=0; i<result.length ; i++){	//클릭한 카테고리의 목록 출력
		let b = document.createElement('button');
		b.classList.add('qna-detail-bnt');
		b.innerText = result[i].title;
		b.value = result[i].qnaId;
		b.name = 'qnaId';
		listBody.append(b);
	}
}

</script>
</body>
</html>