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
	let headcountModal = document.querySelector('#headcount-modal');
	headcountModal.addEventListener('click',headcountModalClickEvent);
	let headcountConfirm = document.querySelector('#headcount-modal .headcount-confirm');
	headcountConfirm.addEventListener('click',headcountModalConfirmEvent);
	let headcountReset = document.querySelector('#headcount-modal .headcount-reset');
	headcountReset.addEventListener('click',headcountModalResetEvent);
})
function headcountModalResetEvent(e){
	let spans = document.querySelectorAll('.headcount-updown-button span');
	for(span of spans){
		span.innerText=0;
	}
}
function headcountModalConfirmEvent(e){
	headcountModalCloseAction(e);
}
// 그 외 영역 클릭 처리
function headcountModalClickEvent(e) {
	searchBoxRemoveClass();
	if (e.target.classList.contains("modal-overlay")) {
		let body = document.querySelector('body');
		e.target.classList.toggle('modal-active');
		body.classList.toggle('modal-active-background');
	}
	// 그 외 영역 클릭 시 필터 초기화 필요. ( 리셋버튼 Func 재사용 )
}
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