// 아이디 - 업체 조회
// 템플릿 이용 붙여넣기
// 클릭이벤트
window.addEventListener('load', function() {
	// 업체 추가
	let insertAccBtn = document.querySelector('.business-acc-insert');
	insertAccBtn.addEventListener('click', accInsertFunc);
	// 업체 추가 취소
	let accInsertCancel = document.querySelector('.business-acc-insert-cancel');
	accInsertCancel.addEventListener('click', accInsertCancelFunc);
	// 업체 삭제 (1)
	let deleteAcc = document.querySelector('.business-acc-delete');
	deleteAcc.addEventListener('click', deleteAccFunc)
	// 업체 삭제 (2) - X 버튼
	let deleteAccBtns = document.querySelectorAll('.business-delete-acc');
	for (deleteAccBtn of deleteAccBtns) {
		deleteAccBtn.addEventListener('click', deleteAccActionFunc);
	}
	// 룸 조회 버튼 이벤트
	let showRoombtns = document.querySelectorAll('.business-show-room');
	for (showBtn of showRoombtns) {
		showBtn.addEventListener('click', showRoomFunc)
	}
	// 룸 삭제 (1)
	let deleteBtns = document.querySelectorAll('.business-delete');
	for (deletebtn of deleteBtns) {
		deletebtn.addEventListener('click', deleteBtnFunc)
	}
	// 룸 삭제 (2) - X 버튼
	let deleteRoomBtns = document.querySelectorAll('.business-delete-room');
	for (deleteRoomBtn of deleteRoomBtns) {
		deleteRoomBtn.addEventListener('click', deleteRoomFunc)
	}
	// 룸 추가
	let insertRoomBtns = document.querySelectorAll('.business-insert-room');
	for (insertRoomBtn of insertRoomBtns) {
		insertRoomBtn.addEventListener('click', roomInsertFunc);
	}
	// 업체,룸 수정
	let updateRoomBtns = document.querySelectorAll('.business-update');
	for (updateBtn of updateRoomBtns) {
		updateBtn.addEventListener('click', updateRoomBtnFunc)
	}
	// 업체,룸 수정 취소
	let cancelBtns = document.querySelectorAll('.business-update-reset');
	for (cancelBtn of cancelBtns) {
		cancelBtn.addEventListener('click', updateResetFunc)
	}
})
function updateResetFunc() {
	location.reload();
}
function showRoomFunc(e) {
	let accForm = e.target.parentElement;
	while (!accForm.classList.contains('form-group')) {
		accForm = accForm.parentElement;
	}
	accForm.classList.toggle('active-form-group');
}

function updateRoomBtnFunc(e) {
	let accForm = e.target.parentElement;
	while (!accForm.classList.contains('form-group')) {
		accForm = accForm.parentElement;
	}
	if (!accForm.classList.contains('active-form-group')) {
		accForm.classList.toggle('active-form-group');
	}
	let inputs = accForm.querySelectorAll('input[type="text"]');
	let inputsValue = accForm.querySelectorAll('input[type="text"]').value;

	if (e.target.classList.contains('active-button')) {
		for (input of inputs) {
			input.readOnly = true;
		}
		e.target.classList.toggle('active-button');
		accForm.querySelector('.business-update-reset').style.display = "none";
		updateBusiness(accForm);
	} else {
		for (input of inputs) {
			input.readOnly = false;
		}
		e.target.classList.toggle('active-button');
		accForm.querySelector('.business-update-reset').style.display = "block";
	}
}

function updateBusiness(accForm) {
	let accInfo = accForm.querySelectorAll('.business-acc input');
	let roomInfo = accForm.querySelectorAll('.business-room input');

	fetch('accUpdate.do', {
		method: 'POST',
		headers: { 'Content-type': 'application/x-www-form-urlencoded' },
		body: 'accId=' + accInfo[0].value + '&name=' + accInfo[1].value + '&phone=' + accInfo[2].value + '&address=' + accInfo[3].value + '&imgUrl=' + accInfo[4].value
	}).then(result => result.json())
		.then(result => console.log(result))
		.catch(err => console.log(err));

	fetch('roomUpdate.do', {
		method: 'POST',
		headers: { 'Content-type': 'application/x-www-form-urlencoded' },
		body: 'roomId=' + roomInfo[0].value + '&name=' + roomInfo[1].value + '&price=' + roomInfo[2].value + '&info=' + roomInfo[3].value
	}).then(result => result.json())
		.then(result => console.log(result))
		.catch(err => console.log(err));
}


function deleteBtnFunc(e) {
	let accForm = e.target.parentElement;
	while (!accForm.classList.contains('form-group')) {
		accForm = accForm.parentElement;
	}
	if (!accForm.classList.contains('active-form-group')) {
		accForm.classList.toggle('active-form-group');
	}
	let rooms = accForm.querySelectorAll('.business-delete-room')
	for (room of rooms) {
		room.classList.toggle('active-delete');
	}
	if(accForm.querySelector('.business-save-room').classList.contains('active-delete')){
		accForm.querySelector('.business-save-room').classList.toggle('active-delete');
	}
}


function deleteAccFunc(e) {
	let accForms = document.querySelectorAll('.businessManage-container .form-group');
	for (accForm of accForms) {
		if (!accForm.classList.contains('active-form-group')) {
			accForm.classList.toggle('active-form-group');
		}
		let btn = accForm.querySelector('.business-delete-acc');
		btn.classList.toggle('active-delete');
	}
}

function deleteAccActionFunc(e) {
	let accForm = e.target.parentElement;
	while (!accForm.classList.contains('form-group')) {
		accForm = accForm.parentElement;
	}
	if (accForm.querySelector('.business-accId').value != "") {
		if (confirm('정말로 해당 숙소를 삭제 하시겠습니까 ?')) {
			let accId = accForm.querySelector('.business-accId').value;
			if (accId != "") {
				fetch('accDelete.do', {
					method: 'POST',
					headers: { 'Content-type': 'application/x-www-form-urlencoded' },
					body: 'accId=' + accId
				}).then(result => result.json())
					.then(result => {
						if (result.retCode == "success") {
							alert("숙소 삭제 성공 !")
							location.reload();
							//document.querySelector('#business-error').style.color = "blue";
							//document.querySelector('#business-error').innerText = "☆ 숙소 삭제 성공 !";
						} else {
							alert("숙소 삭제 실패 !")
							document.querySelector('#business-error').style.color = "red";
							document.querySelector('#business-error').innerText = "☆ 숙소 삭제 오류가 발생하였습니다. ( 계속해서 발생하면 문의를 남겨주세요 )";
						}
					})
					.catch(err => console.log(err));
			} else {
				accForm.remove();
			}
		} else {

		}
	} else {
		accForm.remove();
		location.reload();
	}
}
function deleteRoomFunc(e) {
	let roomForm = e.target.parentElement;
	while (!roomForm.classList.contains('business-room')) {
		roomForm = roomForm.parentElement;
	}
	console.log(roomForm);
	if (confirm('정말로 해당 객실을 삭제 하시겠습니까 ?')) {
		let roomId = roomForm.querySelector('.business-roomId').value;
		console.log(roomId);
		if(roomId!=""){
			fetch('roomDelete.do', {
				method: 'POST',
				headers: { 'Content-type': 'application/x-www-form-urlencoded' },
				body: 'roomId=' + roomId
			}).then(result => result.json())
				.then(result => {
					if (result.retCode == "success") {
						alert("객실 삭제 성공 !")
						location.reload();
						//document.querySelector('#business-error').style.color = "blue";
						//document.querySelector('#business-error').innerText = "☆ 객실 삭제 성공 !";
					} else {
						alert("객실 삭제 실패 !")
						document.querySelector('#business-error').style.color = "red";
						document.querySelector('#business-error').innerText = "☆ 객실 삭제 오류가 발생하였습니다. ( 계속해서 발생하면 문의를 남겨주세요 )";
					}
				})
				.catch(err => console.log(err));
		} else {
			roomForm.remove();
			alert("객실 삭제 성공 !");
			location.reload();
		}
	} else {

	}
}

function roomInsertFunc(e) {
	let accForm = e.target.parentElement;
	while (!accForm.classList.contains('form-group')) {
		accForm = accForm.parentElement;
	}
	if (!accForm.classList.contains('active-form-group')) {
		accForm.classList.toggle('active-form-group');
	}

	let room = accForm.querySelectorAll('.business-room')[0];
	let roomTemplate = document.querySelector('#business-room-template');
	if (room == undefined || room.querySelector('input[name="roomName"]').value != "") {
		let cloneRoom = document.importNode(roomTemplate.content, true)
		cloneRoom.querySelector('input[name="roomName"]').readOnly = false;
		cloneRoom.querySelector('input[name="roomPrice"]').readOnly = false;
		cloneRoom.querySelector('input[name="roomInfo"]').readOnly = false;
		cloneRoom.querySelector('.business-save-room').classList.toggle('active-delete');
		document.querySelector('.business-room-btns').after(cloneRoom);
		$('.business-room').on("change", 'input[name="roomPrice"]', checkPrice);
		$('.business-room').on("click", '.business-delete-room', deleteRoomFunc);
		$('.business-room').on("click", ".business-save-room", function(e) {
			let accForm = e.target.parentElement;
			while (!accForm.classList.contains('form-group')) {
				accForm = accForm.parentElement;
			}
			let accId = accForm.querySelector('.business-accId').value;
			let roomName = accForm.querySelector('input[name="roomName"]').value;
			let roomPrice = accForm.querySelector('input[name="roomPrice"]').value;
			let roomInfo = accForm.querySelector('input[name="roomInfo"]').value;
			$.ajax({
				url: "roomInsert.do",
				data: { "accId": accId, "roomName": roomName, "roomPrice": roomPrice, "roomInfo": roomInfo },
				method: "GET",
				success: function(result) {
					result = JSON.parse(result);
					if (result.retCode == "success") {
						alert("객실 추가 성공 !")
						location.reload();
						//document.querySelector('#business-error').style.color = "blue";
						//document.querySelector('#business-error').innerText = "☆ 객실 등록 성공 !";
					} else {
						alert("객실 추가 실패 !")
						document.querySelector('#business-error').style.color = "red";
						document.querySelector('#business-error').innerText = "☆ 객실 등록 오류가 발생하였습니다. ( 계속해서 발생하면 문의를 남겨주세요 )";
					}
				}, error: function(err) {
					console.log(err);
				}
			})
		})
	}
}
function accInsertFunc() {
	let acc = document.querySelectorAll('.form-group')[0];
	if (document.querySelector('.business-accId') == null || acc.querySelector('.business-accId').value != "") {

		let template = document.querySelector('#business-acc-template');
		let acc = document.importNode(template.content, true);
		if (document.querySelector('.business-accId') != null) {
			console.log(document.querySelector('.business-accId'));
			document.querySelectorAll('.form-group')[0].before(acc);
		} else {
			document.querySelector('.business-list-size').after(acc);
		}
		$('.business-room-btns').on("click", ".business-delete-acc", deleteAccActionFunc);
		$('.business-room-btns').on("click", ".business-show-room", showRoomFunc);
		$('.business-room-btns').on("click", ".business-insert-room", roomInsertFunc);
		$('.business-room-btns').on("click", ".business-update", updateRoomBtnFunc);
		$('.business-room-btns').on("click", ".business-update-reset", updateResetFunc);
		$('.business-room-btns').on("click", ".business-delete", deleteBtnFunc);
		let addBtn = document.querySelector('.business-acc-insert');
		addBtn.innerText = "저장";
		addBtn.style.background = "#42A5F5";
		document.querySelector('.business-acc-insert-cancel').style.display = "block";
	} else {
		let addBtn = document.querySelector('.business-acc-insert');
		let addItem = document.querySelectorAll('.form-group')[0];
		let accName = addItem.querySelector('input[name="accName"]')
		let accPhone = addItem.querySelector('input[name="accPhone"]')
		let accAddress = addItem.querySelector('input[name="accAddress"]')
		let accImgUrl = addItem.querySelector('input[name="accImgUrl"]')
		if (accName.value == "") {
			alert('숙소 이름을 입력하세요.');
			accName.focus();
		} else if (accPhone.value == "") {
			alert('숙소 전화번호를 입력하세요.');
			accPhone.focus();
		} else if (accAddress.value == "") {
			alert('숙소 주소를 입력하세요.');
			accAddress.focus();
		} else if (accImgUrl.value == "") {
			alert('숙소 이미지 URL을 입력하세요.');
			accImgUrl.focus();
		} else {
			addBtn.innerText = "추가";
			addBtn.style.background = "#C5C5C5";
			fetch('accInsert.do', {
				method: 'POST',
				headers: { 'Content-type': 'application/x-www-form-urlencoded' },
				body: 'accName=' + accName.value + '&accPhone=' + accPhone.value + '&accAddress=' + accAddress.value + '&accImgUrl=' + accImgUrl.value
			}).then(result => result.json())
				.then(result => {
					if (result.retCode == "success") {
						location.reload();
						document.querySelector('#business-error').style.color = "blue";
						document.querySelector('#business-error').innerText = "☆ 숙소 등록 성공 !";
					} else {
						document.querySelector('#business-error').style.color = "red";
						document.querySelector('#business-error').innerText = "☆ 숙소 등록 오류가 발생하였습니다. ( 계속해서 발생하면 문의를 남겨주세요 )";
					}
				})
				.catch(err => console.log(err));
		}
	}
}

function accInsertCancelFunc() {
	document.querySelector('.businessManage-container>div>div:nth-child(5)').remove();
	document.querySelector('.business-acc-insert-cancel').style.display = "none";
	let addBtn = document.querySelector('.business-acc-insert');
	addBtn.innerText = "추가";
	addBtn.style.background = "#C5C5C5";
}

function checkPrice(e) {
	let checkReg = /^[0-9]+$/;
	let target = e.target;
	if(!checkReg.test(target.value)){
		target.value=null;
		target.focus();
		target.placeholder="방 가격 (숫자만 입력하세요.)";
	}
}