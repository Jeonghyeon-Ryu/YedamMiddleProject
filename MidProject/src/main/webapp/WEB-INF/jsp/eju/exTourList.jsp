<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="exTourList" role="dialog">
	<div class="exTourList-box">
		<!-- Modal Title -->
		<div class="exTourList-title">
			<div class="exTourList-close-button">
				<img src="img/close-20.png">
			</div>
		</div>
		<!-- Modal Content -->
		<div id="exTourList-content">
			예약일자
			<hr>
			<div class="exTourList-content-list" style="cursor: pointer">

				<div id="ex-main">
					<a href=""><img class="exTourList-placeimg"
						src=""></a>
				</div>
				<div id="ex-comp-title">업체</div>
				<div id="ex-room-name">방이름</div>
				<div id="ex-checkin-checkout">체크인 체크아웃</div>
				<div id="ex-name">이용자 이름</div>
				<div id="ex-phone">전화번호</div>
				<div id="ex-price">결제금액</div>
			</div>
		</div>
		<!-- Modal Footer(Optional) -->
		<div class="exTourList-footer"></div>
	</div>
</div>
