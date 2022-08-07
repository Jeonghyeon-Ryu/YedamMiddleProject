
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="wish" role="dialog">
	<div class="wish-box">
		<!-- Modal Title -->
		<div class="wish-title">
			<h2>위시리스트</h2>
			<div class="wish-close-button">
				<img src="img/close-20.png" onclick="location.href='main.do'">
			</div>
		</div>
		<!-- Modal Content -->
		<div class="wish-content">
			<div class="wish-content-list" style="cursor: pointer">
				<a href="" class="wish-aTag"><img class="wish-placeimg"
					src="https://file.mk.co.kr/meet/neds/2022/03/image_readtop_2022_252256_16476552624979285.jpg"></a>
				<div class="wish-textarea">
					<span>여행지 : <input type="hidden"></span><br>
					<span>방 갯수 : <input type="hidden"></span>
				</div>
			</div>
			<hr>
			<div class="wish-content">
				<div class="wish-content-list" style="cursor: pointer">
					<a href="" class="wish-aTag"><img class="wish-placeimg"
						src="https://file.mk.co.kr/meet/neds/2022/03/image_readtop_2022_252256_16476552624979285.jpg"></a>
					<div class="wish-textarea">
						<span>여행지 : <input type="hidden"></span><br> <span>방
							갯수 : <input type="hidden">
						</span>
					</div>
				</div>
			</div>
			<!-- Modal Footer(Optional) -->
		</div>
	</div>
</div>