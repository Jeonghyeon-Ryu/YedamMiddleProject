window.addEventListener('load',() => {
	let headcountModalCloseButton = document.querySelector('#headcount-modal .modal-close-button');
	headcountModalCloseButton.addEventListener('click', headcountModalCloseAction);
	let headcountModalPlusButton = document.querySelectorAll('#headcount-modal button img[src="img/headcount-plus-32.png"]');
	for(plusBtn of headcountModalPlusButton){
		plusBtn.addEventListener('click',headcountModalPlusAction);
	}
	let headcountModalMinusButton = document.querySelectorAll('#headcount-modal button img[src="img/headcount-minus-32.png"]');
	for(plusBtn of headcountModalMinusButton){
		plusBtn.addEventListener('click',headcountModalMinusAction);
	}
})
// 닫기
function headcountModalCloseAction() {
	searchBoxRemoveClass();
	let modal = event.target.parentElement;
	while(!modal.classList.contains('modal')){
		modal= modal.parentElement
		console.log(modal);
	}
	let main = document.querySelector('main');
	modal.classList.toggle('modal-active');	// 메인 overflow:hidden (스크롤방지)
	main.classList.toggle('modal-active-background');
}

// + 이벤트
function headcountModalPlusAction(event) {
	let headcountButtonContainer = event.target.parentElement.parentElement;
	let headCountSpan = headcountButtonContainer.querySelector('button + span')
	console.log(headcountButtonContainer);
	
	console.log(headCountSpan)
}
// - 이벤트
function headcountModalMinusAction(event) {
	
}