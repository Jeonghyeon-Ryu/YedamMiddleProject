<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="company-container">
	<h2 id="company-title">객실 상세</h2>
	<div id="company-img-div">
		<span><img id="company-img" src="${imgUrl }" alt="11"
			style="max-width: 50%; height: auto;"></span>
	</div>
	<div>
		<hr>
		<div class="comp-title">${accName }</div>

		<p></p>

		<div id="Appstar-rated" class="star-rated">
			<span id="spanstar-ratedFirst" title="5">☆</span> <span
				id="spanstar-ratedsecond" title="4">☆</span> <span
				id="spanstar-ratedthird" title="3">☆</span> <span
				id="spanstar-ratedFourth" title="2">☆</span> <span
				id="spanstar-ratedFifth" title="1">☆</span>
		</div>
		<div class="comp-review">
			<c:if test="${empty reviewId }">전체후기(0)</c:if>
			<c:if test="${!empty reviewId }">전체후기(${reviewId })</c:if>
		</div>
		<span>
			<button class="comp-call-icon">전화</button>
		</span>
		<p></p>
		<hr>
		<p></p>
		<div>
			<span class="comp-room">객실안내/예약 : <br>${roonName } <span><img
					id="room-img" src="${imgUrl }" alt="11"
					style="max-width: 50%; height: auto;"></span> <br>${price } <input
				type="submit" value="예약하기">
			</span> <br>
			<!-- <div><span>숙소정보 : ${info }</span></div> -->
		</div>
		<p></p>
		<div>
			<span class="comp-addrs">주소 : ${accAddress }</span>
		</div>
		<p></p>
		<div>
			<span class="comp-phone">전화번호 : ${accPhone }<input
				type="hidden"></span>
		</div>
		<div>
			<span class="comp-map">지도 : </span>
		</div>
		<p></p>
		<hr>
		<p></p>
		<div>
			<div id="Appstar-rated" class="star-rated">
				<span id="spanstar-ratedFirst" title="5">☆</span> <span
					id="spanstar-ratedsecond" title="4">☆</span> <span
					id="spanstar-ratedthird" title="3">☆</span> <span
					id="spanstar-ratedFourth" title="2">☆</span> <span
					id="spanstar-ratedFifth" title="1">☆</span>
			</div>
			<div>
				<span class="comp-room-review"> <c:if
						test="${empty reviewId }">전체후기(0)</c:if> <c:if
						test="${!empty reviewId }">전체후기(${reviewId })</c:if></span>

			</div>
		</div>
		<div class="comp-photo-review">
			포토리뷰만 보기<input type="checkbox">
		</div>
		<p></p>
		<hr>
		<hr>
		<p></p>
		<div id="review-div">
			<div>
				
				<c:forEach var="rvInfo" items="${rvInfo }">
				<hr>
					<div id="Appstar-rated" class="star-rated">
						<span id="spanstar-ratedFirst" title="5">☆</span> <span
							id="spanstar-ratedsecond" title="4">☆</span> <span
							id="spanstar-ratedthird" title="3">☆</span> <span
							id="spanstar-ratedFourth" title="2">☆</span> <span
							id="spanstar-ratedFifth" title="1">☆</span>
					</div>
					<c:out value="${rvInfo.memberId}" />
					<c:out value="${rvInfo.reviewDate}" />
					<br>
					<span>객실명 </span> | <c:out value="${roomName}" />
					<p>
						<c:out value="${rvInfo.reviewContent}" />
					</p>

				</c:forEach>
			</div>
		</div>
	</div>