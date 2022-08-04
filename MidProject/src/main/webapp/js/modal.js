window.addEventListener('load', function() {
	let filterButton = document.querySelector('.filter-button');
	filterButton.addEventListener('click', modalOpenAction);
	let modalCloseButton = document.querySelector('#modal .modal-close-button');
	modalCloseButton.addEventListener('click', modalCloseAction);
	let modal = document.querySelector('#modal');
	modal.addEventListener('click', modalClickEvent);

})

function modalOpenAction(e) {
	let modal = document.querySelector('#modal');
	modal.classList.toggle('modal-active');
}
// 모달 X 버튼 이벤트
function modalCloseAction(e) {
	if (e.target.parentElement.getAttribute("class") == 'modal-close-button') {
		let modal = e.target.parentElement.parentElement.parentElement.parentElement;
		modal.classList.toggle('modal-active');
	}
}
// 그 외 영역 클릭 처리
function modalClickEvent(e) {
	if (e.target.classList.contains("modal-overlay")) {
		e.target.classList.toggle('modal-active');
	}
	// 그 외 영역 클릭 시 필터 초기화 필요. ( 리셋버튼 Func 재사용 )
}

            // 모달 확인버튼 이벤트 처리
            // 모달 리셋버튼 이벤트 처리
           