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
					<img class="business-delete-acc" src="img/cancel-40.png">
					<img class="businessManage-img" src="${list.acc.imgUrl }">
					<div>
						<div class="business-acc">
							<input class="business-accId" type="text" value="${list.acc.accId }" style="display:none">
							<input type="text" value="${list.acc.name }" name="accName" class="form-control" readonly>
							<input type="text" value="${list.acc.phone }" name="accPhone" class="form-control" readonly>
							<input type="text" value="${list.acc.address }" name="accAddress" class="form-control" readonly>
							<input type="text" value="${list.acc.imgUrl }" name="accImgUrl" class="form-control" readonly>
						</div>
						<div>
							<button class="business-show-room full-btn">조회</button>
							<button class="business-insert-room full-btn">추가</button>
							<button class="business-update full-btn">수정</button>
							<button class="business-update-reset full-btn" style="display:none; background:#42A5F5;">취소</button>
							<button class="business-delete full-btn">삭제</button>
						</div>
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
	<script>
		let showRoombtns = document.querySelectorAll('.business-show-room');
		for(showBtn of showRoombtns){
			showBtn.addEventListener('click',function(e){
				let accForm = e.target.parentElement;
				while(!accForm.classList.contains('form-group')){
					accForm=accForm.parentElement;
				}
				accForm.classList.toggle('active-form-group');
			})
		}
		
		
		let updateRoomBtns = document.querySelectorAll('.business-update');
		for(updateBtn of updateRoomBtns){
			updateBtn.addEventListener('click',function(e){
				let accForm = e.target.parentElement;
				while(!accForm.classList.contains('form-group')){
					accForm=accForm.parentElement;
				}
				if(!accForm.classList.contains('active-form-group')){
					accForm.classList.toggle('active-form-group');
				}
				let inputs = accForm.querySelectorAll('input[type="text"]');
				let inputsValue = accForm.querySelectorAll('input[type="text"]').value;
				
				if(e.target.classList.contains('active-button')){
					for(input of inputs) {
						input.readOnly=true;
					}
					e.target.classList.toggle('active-button');
					accForm.querySelector('.business-update-reset').style.display="none";
					updateBusiness(accForm);
				} else {
					for(input of inputs) {
						input.readOnly=false;
					}
					e.target.classList.toggle('active-button');
					accForm.querySelector('.business-update-reset').style.display="block";
				}
			})
		} 
		function updateBusiness(accForm) {
			let accInfo = accForm.querySelectorAll('.business-acc input');
			let roomInfo = accForm.querySelectorAll('.business-room input');
			
			fetch('accUpdate.do', {
				method: 'POST',
				headers: { 'Content-type': 'application/x-www-form-urlencoded' },
				body: 'accId='+ accInfo[0].value +'&name=' + accInfo[1].value + '&phone=' + accInfo[2].value + '&address=' + accInfo[3].value + '&imgUrl=' + accInfo[4].value
			}).then(result => result.json())
				.then(result => console.log(result))
				.catch(err => console.log(err));
			
			fetch('roomUpdate.do', {
				method: 'POST',
				headers: { 'Content-type': 'application/x-www-form-urlencoded' },
				body: 'roomId='+ roomInfo[0].value +'&name=' + roomInfo[1].value + '&price=' + roomInfo[2].value + '&info=' + roomInfo[3].value
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
		
		let deleteBtns = document.querySelectorAll('.business-delete');
		for(deletebtn of deleteBtns) {
			deletebtn.addEventListener('click',function(e){
				let accForm = e.target.parentElement;
				while(!accForm.classList.contains('form-group')){
					accForm=accForm.parentElement;
				}
				if(!accForm.classList.contains('active-form-group')){
					accForm.classList.toggle('active-form-group');
				}
				let acc = accForm.querySelector('.business-delete-acc');
				acc.classList.toggle('active-delete');
				console.log(acc);
				let rooms = accForm.querySelectorAll('.business-delete-room')
				for(room of rooms){
					room.classList.toggle('active-delete');
					console.log(room);
				}
			})
		}
		
		let deleteAccBtns = document.querySelectorAll('.business-delete-acc');
		for(deleteAccBtn of deleteAccBtns){
			deleteAccBtn.addEventListener('click', function(e){
				let accForm = e.target.parentElement;
				while(!accForm.classList.contains('form-group')){
					accForm=accForm.parentElement;
				}
				if(confirm('정말로 해당 숙소를 삭제 하시겠습니까 ?')){
					let accId = accForm.querySelector('.business-accId').value;
					fetch('roomDelete.do', {
						method: 'POST',
						headers: { 'Content-type': 'application/x-www-form-urlencoded' },
						body: 'accId=' + accId
					}).then(result => result.json())
						.then(result => {
							console.log(result);
							location.reload();})
						.catch(err => console.log(err));
				} else {
					
				}
			})
		}
		let deleteRoomBtns = document.querySelectorAll('.business-delete-room');
		for(deleteRoomBtn of deleteRoomBtns){
			deleteRoomBtn.addEventListener('click', function(e){
				let accForm = e.target.parentElement;
				while(!accForm.classList.contains('form-group')){
					accForm=accForm.parentElement;
				}
				if(confirm('정말로 해당 객실을 삭제 하시겠습니까 ?')){
					let roomId = accForm.querySelector('.business-roomId').value;
					fetch('roomDelete.do', {
						method: 'POST',
						headers: { 'Content-type': 'application/x-www-form-urlencoded' },
						body: 'roomId=' + roomId
					}).then(result => result.json())
						.then(result => {
							console.log(result);
							location.reload();})
						.catch(err => console.log(err));
				} else {
					
				}
			})
		}
		let insertRoomBtns = document.querySelectorAll('.business-insert-room');
		for(insertRoomBtn of insertRoomBtns){
			insertRoomBtn.addEventListener('click', function(e){
				let accForm = e.target.parentElement;
				while(!accForm.classList.contains('form-group')){
					accForm=accForm.parentElement;
				}
				if(!accForm.classList.contains('active-form-group')){
					accForm.classList.toggle('active-form-group');
				}
				let room= accForm.querySelector('.business-room');
				console.log(room);
				let cloneRoom = room.cloneNode(true);
				cloneRoom.querySelector('input[name="roomName"]').value=null;
				cloneRoom.querySelector('input[name="roomName"]').readOnly=false;
				cloneRoom.querySelector('input[name="roomPrice"]').value=null;
				cloneRoom.querySelector('input[name="roomPrice"]').readOnly=false;
				cloneRoom.querySelector('input[name="roomInfo"]').value=null;
				cloneRoom.querySelector('input[name="roomInfo"]').readOnly=false;
				cloneRoom.querySelector('.business-save-room').classList.toggle('active-delete');
				room.after(cloneRoom);
				$('.business-room').on("click",".business-save-room",function(e){
					console.log("click save");
				})
			})
		}
	</script>