let searchButton = document.querySelector('.search-button');
searchButton.addEventListener('click', getAccList);
// 1. Search Box 확인
let resultCity;
let resultRegion;
let reservationDay = '';
let reservationTime = '';
let resultFilter;
const Criteria = { page : 1 };
let scrollIsStop = false;
getAccList(Criteria);
// (1) Location Select 확인
function checkLocation() {
	// Locations
	let selectedLocations = document.querySelectorAll('#city input[type="radio"]');
	for (let selectedLocation of selectedLocations) {
		console.log(selectedLocation.checked)
		if (selectedLocation.checked) {
			//location = selectedLocation.parentElement.lastElementChild.innerHTML;
			resultCity = selectedLocation.parentElement.lastElementChild.innerText;
		}

	}
	// Regions
	selectedLocations = document.querySelectorAll('#regions input[type="radio"]');
	for (let selectedLocation of selectedLocations) {
		console.log(selectedLocation.checked)
		if (selectedLocation.checked) {
			//location = selectedLocation.parentElement.lastElementChild.innerHTML;
			resultRegion = selectedLocation.parentElement.lastElementChild.innerText;
		}

	}
	console.log(resultCity == undefined)
	if (!resultCity) {
		console.log('aa');
		resultCity = '';
	}
	if (!resultRegion) {
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
	for (let i = 0; i < result.length; i++) {
		let card = document.importNode(template.content, true);
		console.log(card.querySelector('img'));
		card.querySelector('img').src = result[i].imgUrl;
		card.querySelector('.card-title').innerText = result[i].name;
		card.querySelector('.card-address strong').innerText += result[i].address;
		card.querySelector('.text-muted').innerText += ' ' + result[i].renewalTime;

		// 카드 붙이기
		document.querySelector('main').append(card);
	}
}
// 4. Ajax - 페이징으로 호출 필요
function getAccList(Criteria) {
	checkLocation();
	checkFilterBox();
	console.log('city=' + resultCity + '&region=' + resultRegion + '&reservationDay=' + reservationDay + '&reservationTime=' + reservationTime + resultFilter);
	fetch('accList.do', {
		method: 'POST',
		headers: { 'Content-type': 'application/x-www-form-urlencoded' },
		body: 'city=' + resultCity + '&region=' + resultRegion + '&reservationDay=' + reservationDay + '&reservationTime=' + reservationTime + resultFilter
	}).then(result => result.json())
		.then(createCard)
		.catch(err => console.log(err));
}

// 6. Scroll 이벤트 추가 + Scroll 위치 계산
// Scroll Page 계산 위한 Criteria -> 인자 전달 필요.

window.addEventListener('scroll',() => {
	// scrollY:스크롤 상단 + innerHeight:현재화면 높이 = 현재까지 스크롤된 부분 하단
	let currScrollY = window.innerHeight + window.scrollY
	if( (currScrollY >= (document.body.offsetHeight-200)) && scrollIsStop!=true ){
		// 200 남기고 ajax 호출 필요.
		Criteria.page++;
		getAccList(Criteria);
		scrollIsStop=true;
		// 만약 모든 Card 출력 후  위로올라가는 스크롤이면 ajax 호출안되게 해야됨. 
		// 더 Append 할 데이터가 남은게 있는지 없는지 확인하여야함.
	} else {
		scrollIsStop=false;
	}
	console.log(currScrollY + " : " + (document.body.offsetHeight));
	
},{ passive:true })


