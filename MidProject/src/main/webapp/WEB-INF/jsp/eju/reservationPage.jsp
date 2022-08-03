<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div id="reservation-container">
	<h2 id="reservation-title">예약 내역</h2>
	<div id="reservation-img-div">
		<span><img id="reservation-img"
			src="https://file.mk.co.kr/meet/neds/2022/03/image_readtop_2022_252256_16476552624979285.jpg"
			alt="11" style="max-width: 50%; height: auto;"></span>
	</div>
	<div>
		<hr>
		<div>
			업체명
			<button>
				전화 : <input type="hidden">
			</button>
			<div>
				<span>도로명 주소 : <input type="hidden"></span>
			</div>
		</div>
		<p></p>
		<hr>
		<div>
			<span>체크인 : <input type="hidden"></span> <span>체크아웃<input
				type="hidden"></span>
		</div>
		<hr>
		<div>
			<span>예약번호 : <input type="hidden"></span>
		</div>
		<div>
			<span>객실정보 : <input type="hidden"></span>
		</div>
		<div>
			<span>예약일자 : <input type="hidden"></span>
		</div>
		<hr>
		<div>
			<h3>지도</h3>
			<!--The div element for the map -->
			<div id="reservation-map"></div>