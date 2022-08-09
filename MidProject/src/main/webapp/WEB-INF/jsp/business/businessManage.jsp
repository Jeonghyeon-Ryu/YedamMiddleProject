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
				<p>사업자 번호 : <span>${business.businessId }</span></p>
				<p>업체 명 : <span>${business.businessName }</span></p>
				<p>업제 주소 : <span>${business.businessAddress }</span></p>
			</div>
			<c:forEach var="list" items="${resultList }">
				<div class="form-group">
					<img class="businessManage-img" src="${list.acc.imgUrl }">
					<div>
						<div class="business-acc">
							<input type="text" value="${list.acc.accId }" style="display:none">
							<input type="text" value="${list.acc.name }" name="accName" class="form-control" readonly>
							<input type="text" value="${list.acc.phone }" name="accPhone" class="form-control" readonly>
							<input type="text" value="${list.acc.address }" name="accAddress" class="form-control" readonly>
							<input type="text" value="${list.acc.imgUrl }" name="accImgUrl" class="form-control" readonly>
						</div>
						<div>
							<button class="business-show-room full-btn">조회</button>
							<button class="business-update full-btn">수정</button>
							<button class="business-update-reset full-btn" style="display:none; background:#42A5F5;">취소</button>
							<button class="business-delete full-btn">삭제</button>
						</div>
					</div>
					<c:forEach var="room" items="${list.roomList }">
						<div class="business-room">
							<input type="text" value="${room.roomId }" style="display:none">
							<input type="text" value="${room.name }" name="roomName" class="form-control" readonly>
							<input type="text" value="${room.price }" name="roomPrice" class="form-control" readonly>
							<input type="text" value="${room.info }" name="roomInfo" class="form-control" readonly>
						</div>
					</c:forEach>
				</div>
			</c:forEach>
		</div>
	</div>
	<script>
		let showRoombtn = document.querySelectorAll('.business-show-room');
		for(showBtn of showRoombtn){
			showBtn.addEventListener('click',function(e){
				let accForm = e.target.parentElement;
				while(!accForm.classList.contains('form-group')){
					accForm=accForm.parentElement;
				}
				accForm.classList.toggle('active-form-group');
			})
		}
		
		let updateRoomBtn = document.querySelectorAll('.business-update');
		for(updateBtn of updateRoomBtn){
			updateBtn.addEventListener('click',function(e){
				let accForm = e.target.parentElement;
				while(!accForm.classList.contains('form-group')){
					accForm=accForm.parentElement;
				}
				let inputs = accForm.querySelectorAll('input[type="text"]');
				let inputsValue = accForm.querySelectorAll('input[type="text"]').value;
				
				if(e.target.classList.contains('active-button')){
					for(input of inputs) {
						input.readOnly=true;
					}
					e.target.classList.toggle('active-button');
					accForm.querySelector('.business-update-reset').style.display="none";
					updateBusiness();
				} else {
					for(input of inputs) {
						input.readOnly=false;
					}
					e.target.classList.toggle('active-button');
					accForm.querySelector('.business-update-reset').style.display="block";
				}
			})
		} 
		function updateBusiness() {
			let accInfo = document.querySelectorAll('.business-acc input');
			let roomInfo = document.querySelectorAll('.business-room input');
			
			fetch('accUpdate.do', {
				method: 'POST',
				headers: { 'Content-type': 'application/x-www-form-urlencoded' },
				body: 'accId='+ accInfo[0].value +'&name=' + accInfo[1].value + '&phone=' + accInfo[2].value + '&address=' + accInfo[3].value + '&imgUrl=' + accInfo[4].value
			}).then(result => result.json())
				.then(result => console.log(result))
				.catch(err => console.log(err));
		}
		let cancelBtns = document.querySelectorAll('.business-update-reset');
		for(cancelBtn of cancelBtns) {
			cancelBtn.addEventListener('click',function(){
				location.reload();
			})
		}
		let deleteRoomBtn = document.querySelectorAll('.business-delete');
	</script>