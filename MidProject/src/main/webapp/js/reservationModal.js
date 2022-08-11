window.addEventListener('load', () => {
	document.querySelector('#nav-reservation').addEventListener('click',reservationModalOpenAction);
	document.querySelector('#reservation-modal .modal-close-button').addEventListener('click',modalCloseAction);
})

function reservationModalOpenAction(e) {
	closeAllModal();
	let modal = document.querySelector('#reservation-modal');
	let body = document.querySelector('body');
	modal.classList.toggle('modal-active');
	body.classList.toggle('modal-active-background');
	let reservationTemplate = document.querySelector('#reservation-template');
	fetch('getReservationList.do')
		.then(result => result.json())
		.then(result => {
			for(item of result){
				let cloneNode = document.importNode(reservationTemplate.content,true);
				cloneNode.querySelector('.card-title').innerText = item.accommodation.name;
				cloneNode.querySelectorAll('.card-text span')[0].innerText = item.room.name
				cloneNode.querySelectorAll('.card-text span')[1].innerText = item.accommodation.address;
				cloneNode.querySelectorAll('.card-text span')[2].innerText = item.reservation.reservationTime;
				cloneNode.querySelectorAll('.card-text span')[3].innerText = item.accommodation.phone;
				cloneNode.querySelectorAll('.card-text span')[4].innerText = item.reservation.paymentCost;
				cloneNode.querySelector('.card-img-top').src = item.accommodation.imgUrl;
				document.querySelector('#reservation-modal .row').append(cloneNode);
			}
		}).catch(err => console.log(err));
	}

