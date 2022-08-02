const gangwon = ["강릉시", "동해시", "삼척시", "속초시", "원주시", "춘천시", "태백시", "고성군", "양구군", "양양군", "영월군", "인제군", "정선군", "철원군", "평창군", "홍천군", "화천군", "횡성군"];
const gyeonggi = ["고양시", "과천시", "광명시", "광주시", "구리시", "군포시", "김포시", "남양주시", "동두천시", "부천시", "성남시", "수원시", "시흥시", "안산시", "안성시", "안양시", "양주시", "오산시", "용인시", "의왕시", "의정부시", "이천시", "파주시", "평택시", "포천시", "하남시", "화성시", "가평군", "양평군", "여주군", "연천군"];
const gyeongsangnam = ["거제시", "김해시", "마산시", "밀양시", "사천시", "양산시", "진주시", "진해시", "창원시", "통영시", "거창군", "고성군", "남해군", "산청군", "의령군", "창녕군", "하동군", "함안군", "함양군", "합천군"];
const gyeongsangbuk = ["경산시", "경주시", "구미시", "김천시", "문경시", "상주시", "안동시", "영주시", "영천시", "포항시", "고령군", "군위군", "봉화군", "성주군", "영덕군", "영양군", "예천군", "울릉군", "울진군", "의성군", "청도군", "청송군", "칠곡군"];
const gwangju = ["광산구", "남구", "동구", "북구", "서구"];
const daegu = ["남구", "달서구", "동구", "북구", "서구", "수성구", "중구", "달성군"];
const daejeon = ["대덕구", "동구", "서구", "유성구", "중구"];
const busan = ["강서구", "금정구", "남구", "동구", "동래구", "부산진구", "북구", "사상구", "사하구", "서구", "수영구", "연제구", "영도구", "중구", "해운대구", "기장군"];
const seoul = ["강남구", "강동구", "강북구", "강서구", "관악구", "광진구", "구로구", "금천구", "노원구", "도봉구", "동대문구", "동작구", "마포구", "서대문구", "서초구", "성동구", "성북구", "송파구", "양천구", "영등포구", "용산구", "은평구", "종로구", "중구", "중랑구"];
const ulsan = ["남구", "동구", "북구", "중구", "울주군"];
const incheon = ["계양구", "남구", "남동구", "동구", "부평구", "서구", "연수구", "중구", "강화군", "옹진군"];
const jeonnam = ["광양시", "나주시", "목포시", "순천시", "여수시", "강진군", "고흥군", "곡성군", "구례군", "담양군", "무안군", "보성군", "신안군", "영광군", "영암군", "완도군", "장성군", "장흥군", "진도군", "함평군", "해남군", "화순군"];
const jeonbuk = ["군산시", "김제시", "남원시", "익산시", "전주시", "정읍시", "고창군", "무주군", "부안군", "순창군", "완주군", "임실군", "장수군", "진안군"];
const jeju = ["서귀포시", "제주시", "남제주군", "북제주군"];
const chungbuk = ["제천시", "청주시", "충주시", "괴산군", "단양군", "보은군", "영동군", "옥천군", "음성군", "증평군", "진천군", "청원군"];

// Regions 할당
let selectedLocations = document.querySelectorAll('.option input[type="radio"]');
for (let selectedLocation of selectedLocations) {
	selectedLocation.addEventListener('click', clickSelectedLocation);
}
function clickSelectedLocation(e) {
	let add;
	if (this.value == "gangwon") {
		add = gangwon;
	} else if (this.value == "gyeonggi") {
		add = gyeonggi;
	} else if (this.value == "gyeongsangnam") {
		add = gyeongsangnam;
	} else if (this.value == "gyeongsangbuk") {
		add = gyeongsangbuk;
	} else if (this.value == "gwangju") {
		add = gwangju;
	} else if (this.value == "daegu") {
		add = daegu;
	} else if (this.value == "daejeon") {
		add = daejeon;
	} else if (this.value == "busan") {
		add = busan;
	} else if (this.value == "seoul") {
		add = seoul;
	} else if (this.value == "ulsan") {
		add = ulsan;
	} else if (this.value == "incheon") {
		add = incheon;
	} else if (this.value == "jeonnam") {
		add = jeonnam;
	} else if (this.value == "jeonbuk") {
		add = jeonbuk;
	} else if (this.value == "jeju") {
		add = jeju;
	} else if (this.value == "chungbuk") {
		add = chungbuk;
	}
	let regions = document.querySelector('#regions');
	removeRegions(regions)
	for (a of add) {
		// Select 노드 생성
		let label = document.createElement('label');
		label.setAttribute('class', 'option');
		let input = document.createElement('input');
		input.setAttribute('type', 'radio');
		input.setAttribute('name', 'option2');
		input.setAttribute('value', a);
		let span = document.createElement('span');
		span.setAttribute('class', 'title animated fadeIn');
		span.innerHTML = '<i class="icon icon-arrow-right"></i>' + a;
		label.append(input);
		label.append(span);

		// Select 노드 append

		regions.append(label);

	}
}
function removeRegions() {
	let regions = document.querySelector('#regions');
	let labels = regions.querySelectorAll('label');
	for (x of labels) {
		regions.removeChild(x);
	}
	region="";
}
// Close Button Event
let locationModalCloseButton = document.querySelector('#location-modal .modal-close-button');
locationModalCloseButton.addEventListener('click', locationModalCloseAction);
function locationModalCloseAction(e) {
	searchBoxRemoveClass();
	if (e.target.parentElement.getAttribute("class") == 'modal-close-button') {
		let modal = e.target.parentElement.parentElement.parentElement.parentElement;
		modal.style.display = "none";
		modal.style.top = '-200%';
	}
}
function searchBoxRemoveClass() {
	let searchBoxItems = document.querySelectorAll('.search-box-item');
	for (searchBoxItem of searchBoxItems) {
		searchBoxItem.classList.remove('search-box-clicked');
		searchBoxItem.classList.remove('search-box-unclicked');
	}
}

let locationModal = document.querySelector('#location-modal');
locationModal.addEventListener('click', locationModalClickEvent);
function locationModalClickEvent(e) {
	searchBoxRemoveClass();
	if (e.target.classList.contains("modal-overlay")) {
		e.target.style.display = "none";
		e.target.style.top = '-200%';
	}
	// 그 외 영역 클릭 시 필터 초기화 필요. ( 리셋버튼 Func 재사용 )
}

// Reset Button Event 
let locationModalReset = document.querySelector('#location-modal button[type="reset"]');
locationModalReset.addEventListener('click', clickLocationModalReset);
function clickLocationModalReset() {
	removeRegions();
	for(x of document.querySelectorAll('#location-modal input[type="radio"]')){
		x.checked=false;
	}
}
