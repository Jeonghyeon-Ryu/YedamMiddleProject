window.addEventListener('load', () => {
	document.querySelector('#nav-reservation').addEventListener('click', reservationModalOpenAction);
	document.querySelector('#reservation-modal .modal-close-button').addEventListener('click', modalCloseAction);
})

function reservationModalOpenAction(e) {
	closeAllModal();
	let modal = document.querySelector('#reservation-modal');
	let body = document.querySelector('body');
	modal.classList.toggle('modal-active');
	body.classList.toggle('modal-active-background');
	clearReservationList()
}
function getReservationList(){
	let reservationTemplate = document.querySelector('#reservation-template');
	fetch('getReservationList.do')
		.then(result => result.json())
		.then(result => {
			for (item of result) {
				console.log(item);
				let cloneNode = document.importNode(reservationTemplate.content, true);
				cloneNode.querySelector('.card-title').innerText = item.accommodation.name;
				cloneNode.querySelectorAll('.card-text span')[0].innerText = item.room.name
				cloneNode.querySelectorAll('.card-text span')[1].innerText = item.accommodation.address;
				cloneNode.querySelectorAll('.card-text span')[2].innerText = item.reservation.reservationTime;
				cloneNode.querySelectorAll('.card-text span')[3].innerText = item.reservation.reservationDay + ' 일';
				cloneNode.querySelectorAll('.card-text span')[4].innerText = item.accommodation.phone;
				cloneNode.querySelectorAll('.card-text span')[5].innerText = item.reservation.paymentCost;
				cloneNode.querySelectorAll('.card-text span')[6].innerText = item.accommodation.accId;
				cloneNode.querySelectorAll('.card-text span')[7].innerText = item.room.roomId;
				if(item.review!=undefined){
					cloneNode.querySelector('.card-body button').innerHTML='후기관리<span></span><span></span><span></span><span></span>';
				}
				cloneNode.querySelector('.card-img-top').src = item.accommodation.imgUrl;
				document.querySelector('#reservation-modal .row').append(cloneNode);
				$('#reservation-modal .modal-content').on("click","button",function(e){
					let cardBody = e.target.parentElement;
					let accId = cardBody.querySelector('.acc-id span').innerText;
					let roomId = cardBody.querySelector('.room-id span').innerText;
					let reviewWindow = window.open('reviewOpen.do?accId='+accId+'&roomId='+roomId,'후기작성','width=500, height=600, menubar=no, toolbar=no');
					reviewWindow.focus();
				})
			}
		}).catch(err => console.log(err));
}
function clearReservationList(){
	window.scrollTo(0,0);
	document.querySelector('#reservation-modal .modal-content').remove();
	let div = document.createElement('div');
	div.setAttribute('class','modal-content');
	let row = document.createElement('div');
	row.setAttribute('class','row row-cols-1 row-cols-md-2 g-4');
	div.append(row);
	document.querySelector('#reservation-modal .modal-title').after(div);
	getReservationList();
}

function getInsertValue(returnValue){
	returnValue = JSON.parse(returnValue);
	fetch('reviewInsert.do', {
		method:'POST',
		headers: { 'Content-type': 'application/x-www-form-urlencoded' },
		body: 'accId='+returnValue.accId+'&roomId='+returnValue.roomId+'&star='+returnValue.star+'&reviewText='+returnValue.reviewText
	}).then(result => result.json())
	.then(result => {
		if(result.retCode=='success'){
			let reviewButton = document.querySelector('#reservation-modal .modal-content button');
			reviewButton.innerHTML='후기관리<span></span><span></span><span></span><span></span>';
			alert("리뷰 작성 완료");
		}
	})
	.catch(err => console.log(err));
}

function getUpdateValue(returnValue){
	returnValue = JSON.parse(returnValue);
	fetch('reviewUpdate.do', {
		method:'POST',
		headers: { 'Content-type': 'application/x-www-form-urlencoded' },
		body: 'accId='+returnValue.accId+'&roomId='+returnValue.roomId+'&star='+returnValue.star+'&reviewText='+returnValue.reviewText
	}).then(result => result.json())
	.then(result => {
		console.log(result);
		if(result.retCode=='success'){
			alert("리뷰 수정 완료");
		}
	})
	.catch(err => console.log(err));
}

function getDeleteValue(returnValue){
	returnValue = JSON.parse(returnValue);
	fetch('reviewDelete.do', {
		method:'POST',
		headers: { 'Content-type': 'application/x-www-form-urlencoded' },
		body: 'accId='+returnValue.accId+'&roomId='+returnValue.roomId+'&star='+returnValue.star+'&reviewText='+returnValue.reviewText
	}).then(result => result.json())
	.then(result => {
		console.log(result);
		if(result.retCode=='success'){
			let reviewButton = document.querySelector('#reservation-modal .modal-content button');
			reviewButton.innerHTML='후기작성<span></span><span></span><span></span><span></span>';
			alert("리뷰 삭제 완료");
		}
	})
	.catch(err => console.log(err));
}