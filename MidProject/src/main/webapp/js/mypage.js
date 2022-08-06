window.addEventListener('load', () => {
	document.querySelector('#nav-mypage').addEventListener('click',mypageModalOpenAction);
	document.querySelector('#mypage-modal .modal-close-button').addEventListener('click',modalCloseAction);
})

function mypageModalOpenAction(e) {
	closeAllModal();
	let modal = document.querySelector('#mypage-modal');
	let body = document.querySelector('body');
	modal.classList.toggle('modal-active');
	body.classList.toggle('modal-active-background');
}

