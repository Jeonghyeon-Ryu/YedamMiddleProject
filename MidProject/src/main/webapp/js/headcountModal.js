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
function headcountModalCloseAction(e) {
	searchBoxRemoveClass();
	let modal = e.target.parentElement;
	while(!modal.classList.contains('modal')){
		modal= modal.parentElement
	}
	let body = document.querySelector('body');
	modal.classList.toggle('modal-active');	// 메인 overflow:hidden (스크롤방지)
	body.classList.toggle('modal-active-background');
}

// + 이벤트
function headcountModalPlusAction(e) {
	let headcountButtonContainer = e.target.parentElement.parentElement;
	let headcountSpan = headcountButtonContainer.querySelector('button + span')
	headcountSpan.innerHTML = +headcountSpan.innerHTML + 1;
}
// - 이벤트
function headcountModalMinusAction(e) {
	let headcountButtonContainer = e.target.parentElement.parentElement;
	let headcountSpan = headcountButtonContainer.querySelector('button + span')
	if(+headcountSpan.innerHTML > 0) {
		headcountSpan.innerHTML = +headcountSpan.innerHTML - 1;
	}
}