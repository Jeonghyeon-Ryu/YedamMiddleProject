<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="exTourList" role="dialog">
	<div class="exTourList-box">
		<!-- Modal Title -->
		<div class="exTourList-title">
			<h2>예약내역</h2>
			<div class="exTourList-close-button">
				<img src="img/close-20.png">
			</div>
		</div>
		<!-- Modal Content -->
		<div class="exTourList-content">
			<div class="exTourList-content-list" style="cursor: pointer">
				<a href=""><img class="exTourList-placeimg"
					src="https://file.mk.co.kr/meet/neds/2022/03/image_readtop_2022_252256_16476552624979285.jpg"
					style="max-width: 100%; height: auto;"></a>
				<div class="textarea">
					<span>업체명</span>
				</div>
				<div>
					<span>객실 이름</span>
				</div>
				<div>
					<span>날짜</span>
				</div>
				<div>
					<span>체크인/체크아웃</span>
				</div>
			</div>
			<div class="content-list" style="cursor: pointer">
				<a href=""><img class="exTourList-placeimg"
					src="https://file.mk.co.kr/meet/neds/2022/03/image_readtop_2022_252256_16476552624979285.jpg"
					style="max-width: 100%; height: auto;"></a>
				<div class="exTourList-textarea">
					<span>예약한 곳</span><br> <span>날짜</span>
				</div>
			</div>
			<hr>
		</div>
		<!-- Modal Footer(Optional) -->
		<div class="exTourList-footer"></div>
	</div>
</div>