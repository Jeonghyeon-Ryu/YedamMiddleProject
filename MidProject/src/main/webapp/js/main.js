let searchButton = document.querySelector('.search-button');
searchButton.addEventListener('click', checkLocation);
// 1. Search Box 확인
let resultCity;
let resultRegion;
let resultFilter = [];
// (1) Location Select 확인
function checkLocation(e) {
	e.preventDefault();
	e.stopPropagation();
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
}
// (2) Checkin, Checkout Date 확인
// (3) Head Count 확인

// 2. Filter Box 확인
function checkFilterBox() {
	let filterItems = document.querySelectorAll('.filter-item');
	resultFilter = [];
    for(filterItem of filterItems){
		if(filterItem.classList.contains('filter-item-clicked')){
			resultFilter.push(filterItem.lastElementChild.innerText);
		}
	}
}
// 3. Filter Box String 만들기

// 4. Ajax
createCard();
// 5. Content Append
function createCard(){
	let template = document.querySelector('template');
	let card = document.importNode(template.content,true);
	// 카드 내용 채우기
	card.querySelector('img').setAttribute('src','');
	card.querySelector('.card-address').innerText = "주소주소";
	
	// 카드 붙이기
	document.querySelector('main').append(card);
}