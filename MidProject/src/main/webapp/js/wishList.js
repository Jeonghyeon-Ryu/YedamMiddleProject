window.addEventListener('load', () => {
	document.querySelector('#nav-wishlist').addEventListener('click',wishlistModalOpenAction);
	document.querySelector('#wishlist-modal .modal-close-button').addEventListener('click',modalCloseAction);
})

function wishlistModalOpenAction(e) {
	closeAllModal();
	let modal = document.querySelector('#wishlist-modal');
	let body = document.querySelector('body');
	modal.classList.toggle('modal-active');
	body.classList.toggle('modal-active-background');
}

