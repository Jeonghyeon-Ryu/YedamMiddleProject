<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>findInfo.jsp</title>
	<style>
	#review-container{
		box-sizing: border-box;
		width:100%;
		margin:0 auto;
	}
	#review-container .title {
		padding:20px;
		text-align:center;
		font-weight:bold;
		font-size:1.2rem;
	}
	#review-container form {
		width:80%;
		margin:0 auto;
	}
	#review-container .star-rated {
		display:flex;
		justify-content:center;
		padding-bottom: 10px
	}
	#review-container .star-rated img {
		margin:0 3px;
	}
	#review-container .content{
		width:100%;
		margin:0 auto;
	}
	#review-container textarea{
		display:inline-block;
		width:-webkit-fill-available;
		height:30vh;
		padding:10px;
		resize: none;
		font-size:0.9rem;
	}
	#review-container .review-button{
		display:flex;
		justify-content:center;
	}
	#review-container button {
		display:inline-block;
		margin:10px auto;
		padding: 5px 7px;
	}
	#review-container .star-rated a{
		text-decoration: none;
		color:#bbb;
		font-size:2rem;
		margin-top:-10px;
		overflow:hidden;
		transition:color 0.5s;
	}
	#review-container .active-star-rated {
		color:orange !important;
	}
	</style>
</head>
<body>
	<div id="review-container">
		<div class="title">리뷰 작성하기</div>
		<form action="">
			<div class="acc-id" style="display:none;">${accId }</div>
			<div class="room-id" style="display:none;">${roomId }</div>
			<div class="review-score" style="display:none;">${reviewScore }</div>
		    <div class="star-rated">
				<a class="star-1" href="#1">★</a>
				<a class="star-2" href="#2">★</a>
				<a class="star-3" href="#3">★</a>
				<a class="star-4" href="#4">★</a>
		    	<a class="star-5" href="#5">★</a>
			</div>
			<div class="content">
				<textarea maxlength="200">${reviewContent }</textarea>
			</div>
			<div class="review-button">
				<c:if test="${empty reviewContent }">
					<button class="review-insert" type="button">등록하기</button>
				</c:if>
				<c:if test="${!empty reviewContent }">
					<button class="review-update" type="button">수정하기</button>
					<button class="review-delete" type="button">삭제하기</button>
				</c:if>
			</div>
		</form>
	</div>
	<script>
		window.addEventListener('load',function(){
			let starRated = document.querySelector("#review-container .star-rated");
			starRated.addEventListener('mouseover',starMouseOver);
			let insertButton = document.querySelector("#review-container .review-insert");
			if(insertButton!=null){	// 리뷰 등록하기
				insertButton.addEventListener('click',reviewSubmit);
			}
			let updateButton = document.querySelector("#review-container .review-update");
			if(updateButton!=null){	// 리뷰 수정하기
				updateButton.addEventListener('click',reviewUpdate);
			}
			let deleteButton = document.querySelector("#review-container .review-delete");
			if(deleteButton!=null){	// 리뷰 삭제하기
				deleteButton.addEventListener('click',reviewDelete);
			}
			if(document.querySelector(".review-score").innerText!=""){
				setReviewScore();	// 작성된 리뷰 관리
			}
		})
		function reviewUpdate(){
			let returnValue = getReviewData();
			console.log(returnValue);
			window.opener.getUpdateValue(JSON.stringify(returnValue));
			window.close();
		}
		function reviewDelete(){
			let returnValue = getReviewData();
			window.opener.getDeleteValue(JSON.stringify(returnValue));
			window.close();
		}
		function setReviewScore(){
			let reviewScore = document.querySelector(".review-score").innerText;
			let stars = document.querySelectorAll('a');
			for(let i=0; i < +reviewScore; i++){
				stars[i].classList.toggle("active-star-rated");
			}
		}
		function starMouseOver(e){
			if(e.target.tagName=='A'){
				let stars = document.querySelectorAll('a');
				for(star of stars){
					star.classList.remove("active-star-rated");
				}
				for(star of stars){
					star.classList.toggle("active-star-rated");
					if(star == e.target){
						return;
					}
				}
			}
		}
		function getReviewData() {
			let accId = document.querySelector('.acc-id').innerText;
			let roomId = document.querySelector('.room-id').innerText;
			let stars = document.querySelectorAll('a');
			let starNum = 0;
			for(star of stars){
				if(star.classList.contains("active-star-rated")){
					starNum++;
				}
			}
			let reviewText = document.querySelector('textarea').value;
			if(reviewText.length<10){
				alert('리뷰는 10자 이상 입력해주세요.');
				return;
			} else {
				let returnValue = {
					"accId": accId,
					"roomId": roomId,
					"star": starNum,
					"reviewText": reviewText
				};
				return returnValue;
			}
		}
		function reviewSubmit()	{
			let returnValue = getReviewData();
			window.opener.getInsertValue(JSON.stringify(returnValue));
			window.close();
		}
	</script>
</body>
</html>