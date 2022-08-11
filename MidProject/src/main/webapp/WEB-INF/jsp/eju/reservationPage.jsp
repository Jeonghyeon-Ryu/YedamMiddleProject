<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js">
</script><script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.1.8.js"></script>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" type="text/css" href="css/businessManage.css">
<div id="rv-container" class="rv-content-box">
	<div id="rv-header-fixed">예약</div>
	<div id="rv-center-page">
		<div id="rv-memberid" style="display:none">${id }</div>
		<div id="rv-roomId" style="display:none">${roomId }</div>
		<div id="rv-first" class="rv-content-box">
			<div id="rv-product-name" style="margin-bottom: 20px;">
				<b>상품정보</b>
			</div>
			<div class="rv-comp-title">
				<b>${accName }</b>
			</div>
			<div class="rv-room-name">${roomName }</div>
			<div class="rv-ckin-ckout">
				<span class="check-in">${checkIn}</span>~<span class="check-out">${checkOut }</span>
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
			<input type="tel" class="rv-member-phone" value="${memberPhone }" readonly>
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
	<button id="check-module" type="button">결제</button>
</div>
<script>
let memberId = document.querySelector('#rv-memberid').innerText;
let memberName = document.querySelector('.rv-member-name').value;
let memberPhone = document.querySelector('.rv-member-phone').value;
let roomId = document.querySelector('#rv-roomId').innerText;
let checkIn = document.querySelector('.check-in').innerText;
let checkOut = document.querySelector('.check-out').innerText;
let price = document.querySelector('#rv-payment').innerText;
let merchantName = document.querySelector('.rv-comp-title b').innerText+ ' ' + document.querySelector('.rv-room-name').innerText;
console.log(merchantName);
// 방이름 날짜 
$("#check-module").click(function () {
    var IMP = window.IMP;
    IMP.init('imp77170587');
    IMP.request_pay({
        pg: 'html5_inicis',
        pay_method: 'card',
        merchant_uid: 'merchant_' + new Date().getTime(),
        name: '주문명:' + merchantName , // 업체이름 --
        amount: 1000,  // 가격 --
        buyer_email: memberId, // 구매자 이메일 ( 아이디 ) -- 
        buyer_name: memberName,	// 구매자 이름 --
        buyer_tel: memberPhone, // 구매자 핸드폰 번호 --
        m_redirect_url: 'http://localhost:8088/MidProject/'
    }, function (rsp) {
        console.log(rsp);
        // roomId, memberid checkIn,checkout, 결제일, 결제금액
        $.ajax({
			url: "insertReservation.do",
			data: { "roomId" : roomId, "checkIn": checkIn, "checkOut": checkOut, "price": price },
			method: "GET",
			success: function(result){
				result = JSON.parse(result);
				if(result.retCode=="success"){
					location.href="main.do";
					reservationModalOpenAction();
				} else if(result.retCode=="fail"){
					alert('결제실패 ( 계속되면 관리자에게 문의하세요. )');
				}
			}, error : function(err){
				console.log(err);
			}
		})
    });
});
</script>