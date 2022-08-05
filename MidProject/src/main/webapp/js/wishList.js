window.addEventListener('load', () => {
	document.querySelector('#nav-wishlist').addEventListener('click',wishlistModalOpenAction);
	document.querySelector('#wishlist-modal .modal-close-button').addEventListener('click',modalCloseAction);
})

function wishlistModalOpenAction(e) {
	let modal = document.querySelector('#wishlist-modal');
	let main = document.querySelector('main');
	modal.classList.toggle('modal-active');
	main.classList.toggle('modal-active-background');
}

