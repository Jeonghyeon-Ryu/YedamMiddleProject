let searchButton = document.querySelector('.search-button');
searchButton.addEventListener('click', getAccList);
// 1. Search Box 확인
let resultCity;
let resultRegion;
let reservationDay = '';
let reservationTime = '';
let resultFilter;
getAccList();
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
	console.log(resultFilter);
}
// 3. Filter Box String 만들기

// 5. Content Append
function createCard(result) {
	let template = document.querySelector('template');
	// 카드 내용 채우기
	for(let i=0; i<result.length; i++){
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
// 4. Ajax
function getAccList() {
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

