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
}

