window.addEventListener('load', () => {
	document.querySelector('#nav-mypage').addEventListener('click',mypageModalOpenAction);
	document.querySelector('#mypage-modal .modal-close-button').addEventListener('click',modalCloseAction);
})

function mypageModalOpenAction(e) {
	let modal = document.querySelector('#mypage-modal');
	let main = document.querySelector('main');
	modal.classList.toggle('modal-active');
	main.classList.toggle('modal-active-background');
}

