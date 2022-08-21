<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<link rel="stylesheet" type="text/css" href="css/businessManage.css">
	<div class="businessManage-container">
		<div class="businessManage-box">
			<div class="business-icon">
				<img src="img/business-100.png" class="far fa-user" />
			</div>
			<div class="serparater">
				<p>사업자 번호 : <span>${businessId }</span></p>
				<p>업체 명 : <span>${business.businessName }</span></p>
				<p>업제 주소 : <span>${business.businessAddress }</span></p>
				<p id="business-error" style="color:red; font-weight:bold; display:block;"></p>
			</div>
			<div class="business-acc-btns">
				<button class="business-acc-insert full-btn">추가</button>
				<button class="business-acc-insert-cancel full-btn" style="display:none; background:#42A5F5;">취소</button>
				<button class="business-acc-delete full-btn">삭제</button>
			</div>
			<input class="business-list-size" type="text" value="${fn:length(resultList) }" style="display:none">
			<c:forEach var="list" items="${resultList }">
				<div class="form-group">
					<img class="business-delete-acc" src="img/cancel-40.png">
					<img class="businessManage-img" src="${list.acc.imgUrl }">
					<div>
						<div class="business-acc">
							<input class="business-accId" type="text" value="${list.acc.accId }" style="display:none">
							<div>
								<input type="text" value="${list.acc.name }" name="accName" class="form-control" readonly>
								<input type="text" value="${list.acc.phone }" name="accPhone" class="form-control" readonly>
								<input type="text" value="${list.acc.address }" name="accAddress" class="form-control" readonly>
								<input type="text" value="${list.acc.imgUrl }" name="accImgUrl" class="form-control" readonly>
							</div>
						</div>
					</div>
					<div class="business-room-btns">
						<button class="business-show-room full-btn">조회</button>
						<button class="business-insert-room full-btn">추가</button>
						<button class="business-update full-btn">수정</button>
						<button class="business-update-reset full-btn" style="display:none; background:#42A5F5;">취소</button>
						<button class="business-delete full-btn">삭제</button>
					</div>
					<c:forEach var="room" items="${list.roomList }">
						<div class="business-room">
							<input class="business-roomId" type="text" value="${room.roomId }" style="display:none">
							<input type="text" value="${room.name }" name="roomName" class="form-control" readonly>
							<input type="text" value="${room.price }" name="roomPrice" class="form-control" readonly>
							<input type="text" value="${room.info }" name="roomInfo" class="form-control" readonly>
							<img class="business-delete-room" src="img/cancel-40.png">
							<img class="business-save-room" src="img/save-40.png">
						</div>
					</c:forEach>
				</div>
			</c:forEach>
		</div>
	</div>
	<template id="business-acc-template">
		<div class="form-group">
			<img class="business-delete-acc" src="img/cancel-40.png">
			<img class="businessManage-img" src="">
			<div>
				<div class="business-acc">
					<input class="business-accId" type="text" value="" style="display:none">
					<div>
						<input type="text" value="" placeholder="숙소 이름" name="accName" class="form-control">
						<input type="text" value="" placeholder="숙소 전화번호" name="accPhone" class="form-control">
						<input type="text" value="" placeholder="숙소 주소" name="accAddress" class="form-control">
						<input type="text" value="" placeholder="숙소 이미지 URL" name="accImgUrl" class="form-control">
					</div>
				</div>
			</div>
			<div class="business-room-btns">
				<button class="business-show-room full-btn">조회</button>
				<button class="business-insert-room full-btn">추가</button>
				<button class="business-update full-btn">수정</button>
				<button class="business-update-reset full-btn" style="display:none; background:#42A5F5;">취소</button>
				<button class="business-delete full-btn">삭제</button>
			</div>
		</div>
	</template>
	<template id="business-room-template">
		<div class="business-room">
			<input class="business-roomId" type="text" value="" style="display:none">
			<input type="text" value="" placeholder="방 이름" name="roomName" class="form-control" readonly>
			<input type="text" value="" placeholder="방 가격" name="roomPrice" class="form-control" readonly>
			<input type="text" value="" placeholder="방 정보" name="roomInfo" class="form-control" readonly>
			<img class="business-delete-room" src="img/cancel-40.png">
			<img class="business-save-room" src="img/save-40.png">
		</div>
	</template>
	<script src="js/businessManage.js"></script>