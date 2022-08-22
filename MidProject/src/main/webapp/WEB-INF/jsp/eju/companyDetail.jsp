<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="company-container">
	<div>
		<h2 id="company-title">객실 상세</h2>
	</div>
	<div id="company-img-div">
		<img id="company-img" src="${imgUrl }">
	</div>
	<div>
		<div class=company-top>
			<div>
				<div class="comp-title">${accName }</div>
				<div class="star-rated">
					<a class="star-1" href="#1">★</a>
					<a class="star-2" href="#2">★</a>
					<a class="star-3" href="#3">★</a>
					<a class="star-4" href="#4">★</a>
			    	<a class="star-5" href="#5">★</a>
				</div>
				<div class="comp-info">
					<span class="comp-addrs">주소 : ${accAddress }</span>
				</div>
				<div class="comp-info">
					<span class="comp-phone">전화번호 : ${accPhone }</span>
				</div>
				<a href="#detail-review">
					<div class="comp-review">
						<c:if test="${empty reviewId }">전체후기(0)</c:if>
						<c:if test="${!empty reviewId }">전체후기(${reviewId })</c:if>
					</div>
				</a>
			</div>
			<div>
				<img src="img/call-50.png" />
			</div>
		</div>
		<div>
			<div>
				<span class="comp-room">객실안내/예약</span>
			</div>
			<c:if test="${empty checkIn || checkOut }"></c:if>
			<c:if test="${!empty checkIn || checkOut }">${checkIn}~${checkOut }</c:if>
			<div>
				<b>객실명 : ${roomName}</b>
			</div>
			<br>
			<div>
				<img src="${imgUrl }">
			</div>
			<div id="comp-price">
				<div>
					<c:if test="${reservationDate!=0 }"><b>가격 : ${reservationDate}박 ${price }원</b></c:if>
					<c:if test="${reservationDate==0 }"><b>가격 : 1박 ${price }원</b></c:if>
				</div>
				<div>
					<button id="rv-button" onclick="mycall('${accId }','${checkIn}','${checkOut }')">예약하기</button>
				</div>
			</div>
		</div>
		<div>
			<hr>
			<div>
				<div id="detail-review" class="comp-room-review">
					<c:if test="${empty reviewId }">전체후기(0)</c:if>
					<c:if test="${!empty reviewId }">전체후기(${reviewId })</c:if>
				</div>
			</div>
		</div>
		<div class="comp-photo-review">
			포토리뷰만 보기<input type="checkbox">
		</div>
		<hr>
		<div id="review-div">
			<div>
				<c:forEach var="rvInfo" items="${rvInfo }">
					<hr>
					<div class="star-rated">
						<img src="img/star-empty-20.png" class="first-star"> <img
							src="img/star-empty-20.png" class="second-star"> <img
							src="img/star-empty-20.png" class="third-star"> <img
							src="img/star-empty-20.png" class="fourth-star"> <img
							src="img/star-empty-20.png" class="fifth-star">
					</div>
					<c:out value="${rvInfo.memberId}" />
					<c:out value="${rvInfo.reviewDate}" />
					<span>객실명 </span> | <c:out value="${roomName}" />
					<p>
						<c:out value="${rvInfo.reviewContent}" />
					</p>
				</c:forEach>
			</div>
		</div>
	</div>
	<div class='member-id' style="display:none;">${id }</div>
</div>
<script src="js/companyDetail.js"></script>