let searchButton = document.querySelector('.search-button');
searchButton.addEventListener('click', clearAccList);
// 1. Search Box 확인
let resultCity;
let resultRegion;
let reservationDay = '';
let reservationTime = '';
let resultFilter;
const Criteria = { page : 0, endPageNo: 0 };
let scrollIsStop = false;
getAccList(); // 웹 오픈시 10개 출력
// (1) Location Select 확인
function checkLocation() {
	// Locations
	let selectedLocations = document.querySelectorAll('#city input[type="radio"]');
	for (let selectedLocation of selectedLocations) {
		if (selectedLocation.checked) {
			resultCity = selectedLocation.getAttribute('text');
		}
	}
	// Regions
	selectedLocations = document.querySelectorAll('#regions input[type="radio"]');
	for (let selectedLocation of selectedLocations) {
		if (selectedLocation.checked) {
			resultRegion = selectedLocation.getAttribute('value');
		}
	}

	if (typeof resultCity == "undefined") {
		resultCity = '';
	}
	if (typeof resultRegion == "undefined") {
		resultRegion = '';
	}
}
// (2) Checkin, Checkout Date 확인
// (3) Head Count 확인

// 2. Filter Box 확인
function checkFilterBox() {
	let filterItems = document.querySelectorAll('.filter-item');
	resultFilter = "";
	let i = 1;
	for (filterItem of filterItems) {
		if (filterItem.classList.contains('filter-item-clicked')) {
			resultFilter += '&f' + i + '=' + filterItem.lastElementChild.innerText;
			i++;
		}

	}
}
// 3. Filter Box String 만들기

// 5. Content Append
function createCard(result) {
	let template = document.querySelector('template');
	// 카드 내용 채우기
	Criteria.endPageNo = result.endPageNo;
	for (let i = 0; i < result.list.length; i++) {
		let card = document.importNode(template.content, true);
		card.querySelector('img').src = result.list[i].imgUrl;
		card.querySelector('.card-title').innerText = result.list[i].name;
		card.querySelector('.card-address strong').innerText += result.list[i].address;
		card.querySelector('.text-muted').innerText += ' ' + result.list[i].renewalTime;
		card.querySelector('.card').setAttribute('accId',result.list[i].accId);
		// 카드 붙이기
		document.querySelector('main').append(card);
	}
}
// 4. Ajax - 페이징으로 호출 필요
function getAccList() {
	checkLocation();
	checkFilterBox();
	console.log('pageNum='+ Criteria.page +'&city=' + resultCity + '&region=' + resultRegion + '&reservationDay=' + reservationDay + '&reservationTime=' + reservationTime + resultFilter)
	fetch('accList.do', {
		method: 'POST',
		headers: { 'Content-type': 'application/x-www-form-urlencoded' },
		body: 'pageNum='+ Criteria.page +'&city=' + resultCity + '&region=' + resultRegion + '&reservationDay=' + reservationDay + '&reservationTime=' + reservationTime + resultFilter
	}).then(result => result.json())
		.then(createCard)
		.then(Criteria.page++)
		.catch(err => console.log(err));
}
// 3.5. Search 버튼 클릭 또는 필터 변경 적용 시 Body Clear
function clearAccList() {
	window.scrollTo(0,0);
	document.querySelector('main').remove();
	let main = document.createElement('main');
	document.querySelector('header').after(main);
	Criteria.page=0;
	getAccList();
}
// 6. Scroll 이벤트 추가 + Scroll 위치 계산
// Scroll Page 계산 위한 Criteria -> 인자 전달 필요.
window.addEventListener('scroll',() => {
	// scrollY:스크롤 상단 + innerHeight:현재화면 높이 = 현재까지 스크롤된 부분 하단
	let currScrollY = window.innerHeight + window.scrollY
	if( (currScrollY >= (document.body.offsetHeight-200)) && scrollIsStop!=true && Criteria.page<=Criteria.endPageNo){
		// 200 남기고 ajax 호출 필요.
		getAccList();
		scrollIsStop=true;
		// 만약 모든 Card 출력 후  위로올라가는 스크롤이면 ajax 호출안되게 해야됨. 
		// 더 Append 할 데이터가 남은게 있는지 없는지 확인하여야함.
	} else {
		scrollIsStop=false;
	}
},{ passive:true })

// ------------------- Card Click Event -----------------------
function clickCard() {
	let clickedCard = event.target;
	while(!clickedCard.classList.contains('card')){
		clickedCard = clickedCard.parentElement;	
	}
	clickedCard = clickedCard.getAttribute('accid');
	console.log(clickedCard);
	
	
	
}
