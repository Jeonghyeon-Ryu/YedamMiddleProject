window.addEventListener('load', () => {
	let filterButton = document.querySelector('.filter-button');
	filterButton.addEventListener('click', modalOpenAction);
	let modalCloseButton = document.querySelector('#modal .modal-close-button');
	modalCloseButton.addEventListener('click', modalCloseAction);
	let modal = document.querySelector('#modal');
	modal.addEventListener('click', modalClickEvent);

})
// 모든 모달 닫기
function closeAllModal() {
	let modals = document.querySelectorAll('.modal');
	for(modal of modals){
		if(modal.classList.contains('modal-active')){
			modal.classList.toggle('modal-active');
		}
	}
	let body = document.querySelector('body');
	if(body.classList.contains('modal-active-background')){
		body.classList.toggle('modal-active-background');		
	}
}
function modalOpenAction(e) {
	closeAllModal();
	let modal = document.querySelector('#modal');
	let body = document.querySelector('body');
	modal.classList.toggle('modal-active');
	body.classList.toggle('modal-active-background');
}
// 필터 모달 X 버튼 이벤트
function modalCloseAction(e) {
	let modal = e.target.parentElement;
	while(!modal.classList.contains('modal')){
		modal= modal.parentElement
		console.log(modal);
	}
	let body = document.querySelector('body');
	modal.classList.toggle('modal-active');
	body.classList.toggle('modal-active-background');
	
}
// 그 외 영역 클릭 처리
function modalClickEvent(e) {
	if (e.target.classList.contains("modal-overlay")) {
		let body = document.querySelector('body');
		e.target.classList.toggle('modal-active');
		body.classList.toggle('modal-active-background');
	}
	// 그 외 영역 클릭 시 필터 초기화 필요. ( 리셋버튼 Func 재사용 )
}

            // 모달 확인버튼 이벤트 처리
            // 모달 리셋버튼 이벤트 처리
           