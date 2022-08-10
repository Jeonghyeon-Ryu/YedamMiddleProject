<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" type="text/css" href="css/businessManage.css">
   <div class="businessManage-container">
      <div class="businessManage-box">
         <div class="business-icon">
            <img src="img/business-100.png" class="far fa-user" />
         </div>
          <div class="serparater">
            <p><span>${accName }</span></p>
            <p><span>${accAddress }</span></p>
            <p><span>${accPhone }</span></p>
         </div>
            <div class="form-group">
               <img class="businessManage-img" src="${imgUrl }">
               <div>
                  <div class="business-acc">
                     <input type="text" value="${roomName }" name="accName" class="form-control" readonly>
                     <input type="text" value="${price }" name="accPhone" class="form-control" readonly>
                     <input type="text" value="${checkIn }" name="accAddress" class="form-control" readonly>
                     <input type="text" value="${checkOut }" name="accImgUrl" class="form-control" readonly>
                  </div>
               </div>
                  <div class="business-room">
                     <input type="text" value="${memberName }" name="roomName" class="form-control" readonly>
                     <input type="text" value="${phone }" name="roomPrice" class="form-control" readonly>
                  </div>
                  <div>
                     <button id="business-delete" class="full-btn">결제</button>
                  </div>
            </div>
      </div>
   </div>
   
   <!-- <div id="rv-container"> -->
<!-- 	<div class="rv-first"> -->
<!-- 		<div>상품정보</div> -->
<!-- 		<div class="rv-comp-title"></div> -->
<!-- 		<div class="rv-room-name"></div> -->
<!-- 		<div class="rv-ckin-ckout"></div> -->
<!-- 		<div class="rv-price"></div> -->
<!-- 	</div> -->
<!-- 	<div class="rv-second"> -->
<!-- 		<div>예약자정보</div> -->
<!-- 		<div class="rv-member-name">성명</div> -->
<!-- 		<input type="text"> -->
<!-- 		<div class="rv-member-phone">휴대폰 번호</div> -->
<!-- 		<input type="tel"> -->
<!-- 	</div> -->
<!-- 	<div class="rv-third"> -->
<!-- 		<div>이용자정보</div> -->
<!-- 		<input type="checkbox" checked>예약자 정보와 동일합니다 -->
<!-- 		<div class="rv-real-user"></div> -->
<!-- 		<div class="rv-real-user-phone"></div> -->
<!-- 	</div> -->
<!-- 	<div class="rv-fourth"> -->
<!-- 		<div>총 결제 금액</div> -->
<!-- 		<div class="rv-total-price">총 예약 금액</div> -->
<!-- 		<div class=""></div> -->
<!-- 	</div> -->
<!-- 	<div class="rv-fifth"> -->
<!-- 		<div>결제정보</div> -->
<!-- 		<div class=""></div> -->
<!-- 	</div> -->
<!-- </div> -->