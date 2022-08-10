<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자주 묻는 질문 qna</title>
<style>
.qna-box{
padding: 20px;
width:90%; margin:0 auto;}
.qna-box .qna-content{
	position:relative;height:100%;max-width:768px;text-align:center;
	margin:auto;}
.qna-box .qna-category{
	display:inline-block;width:30%;background-color: white; text-align:left;
	padding:5px; border-radius:5px; margin:3px; background: rgb(236, 236, 236);}
.qna-box .qna-category:hover{
	font-weight: bold; background: lightgray;}
.qna-box #qna-list-items p{width:90%;border-bottom:1px solid lightgray;}
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
		<div class="qna-list">
		</div>
	</div>
	<div id="qna-list-items"></div>
</div>
<script>
function qnaList(result){
	let listBody = document.getElementById('qna-list-items');
	listBody.childNodes.remove;//?왜계속 추가되는거야ㅠ
	for (let i=0; i<result.length ; i++){
		let p = document.createElement('p');
		p.innerText = result[i].title;
		listBody.append(p);
	}
}
function showQnAList(e){
	let click = event.target;
  	let clickNm = click.innerText;
	
	fetch('getQnaList.do',{
		method:'post',
		headers:{'Content-type':'application/x-www-form-urlencoded'},
		body:'dategoryNm=' + clickNm
	})
	.then(result => result.json())	//json형태로 받아옴
	.then(qnaList)					//결과를 매개변수로 함수호출
	.catch(err=>console.log(err))
}
showQnAList;
function qnaDetail(e){
	console.log(this);
	let title = this.innerText;
}
</script>
</body>
</html>