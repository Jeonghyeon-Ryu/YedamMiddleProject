window.addEventListener('load', () => {
	document.querySelector('#nav-login').addEventListener('click',loginModalOpenAction);
	document.querySelector('#login-modal .modal-close-button').addEventListener('click',modalCloseAction);
})




function loginModalOpenAction(e) {
	closeAllModal();
	let modal = document.querySelector('#login-modal');
	let body = document.querySelector('body');
	modal.classList.toggle('modal-active');
	body.classList.toggle('modal-active-background');
}
