<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" type="text/css" href="css/businessManage.css">
<!-- <div id="rv-container"> -->
<!-- 	<div class="rv-main"> -->
<!-- 		<div class="rv-main2"> -->
<!-- 			<div class="rv-comp-info"> -->
<!-- 				<p> -->
<%-- 					<span>${accName }</span> --%>
<!-- 				</p> -->
<!-- 				<p> -->
<%-- 					<span>${accAddress }</span> --%>
<!-- 				</p> -->
<!-- 				<p> -->
<%-- 					<span>${accPhone }</span> --%>
<!-- 				</p> -->
<!-- 			</div> -->
<!-- 			<div class="rv-main-conetnt"> -->
<%-- 				<img class="rv-room-img" src="${imgUrl }"> --%>
<!-- 				<div> -->
<!-- 					<div class="rv-room-info"> -->
<%-- 						<input type="text" value="${roomName }" name="roomName" class="" --%>
<%-- 							readonly> <input type="text" value="${price }" --%>
<!-- 							name="roomPrice" class="" readonly> <input type="text" -->
<%-- 							value="${checkIn }" name="checkIn" class="" readonly> <input --%>
<%-- 							type="text" value="${checkOut }" name="checkOut" class="" --%>
<!-- 							readonly> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 				<div class="rv-user-info"> -->
<%-- 					<input type="text" value="${memberName }" name="roomName" class="" --%>
<%-- 						readonly> <input type="text" value="${phone }" --%>
<!-- 						name="roomPrice" class="" readonly> -->
<!-- 				</div> -->
<!-- 				<div> -->
<!-- 					<button id="rv-payment">결제</button> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 	</div> -->
<!-- </div> -->

<div id="rv-container" class="rv-content-box">
	<div id="rv-header-fixed">예약</div>
	<div id="rv-center-page">
		<div id="rv-first" class="rv-content-box">
			<div id="rv-product-name" style="margin-bottom: 20px;">
				<b>상품정보</b>
			</div>
			<div class="rv-comp-title">
				<b>${accName }</b>
			</div>
			<div class="rv-room-name">${roomName }</div>
			<div class="rv-ckin-ckout">
				<span class="rv-checkInOut">${checkIn}~${checkOut }</span>
			</div>
			<div class="rv-price">${price }</div>
		</div>
		<div id="rv-second" class="rv-content-box">
			<div>
				<b>예약자정보</b>
			</div>
			<div class="rv-user-name-phone">이름</div>
			<input type="text" class="rv-member-name" value="${memberName}"
				readonly>
			<div class="rv-user-name-phone">전화번호</div>
			<input type="tel" class="rv-member-phone" value="${phone }" readonly>
		</div>
		<div id="rv-third" class="rv-content-box">
			<div id="rv-user-info">이용자정보</div>
			<input type="checkbox" checked>예약자 정보와 동일합니다
			<div class="rv-user-name-phone">이름</div>
			<input type="text" class="rv-member-name" value="${memberName}">
			<div class="rv-user-name-phone">전화번호</div>
			<input type="tel" class="rv-member-phone" value="${phone }">
		</div>
		<div id="rv-fourth" class="rv-content-box">
			<div>
				<b>금액정보</b>
			</div>
			<div class="rv-total-price">
				<div>
					<b>총 결제 금액</b>
				</div>
				<div id="rv-payment">${price }</div>
			</div>
		</div>
		<div id="rv-fifth" class="rv-content-box">
			<div>
				<b>결제정보</b>
			</div>
			<div class=""></div>
		</div>
	</div>
</div>