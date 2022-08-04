// 헤더 이벤트 추가 부분
window.addEventListener('load',() => {

    // ADD Header Scroll Event 
    let rightScrollButton = document.querySelector('.right-scroll-button');
    let leftScrollButton = document.querySelector('.left-scroll-button');
    rightScrollButton.addEventListener('click', rightScrollFunction);
    leftScrollButton.addEventListener('click', leftScrollFunction);
    document.querySelector('.left-scroll-button').style.visibility='hidden';

    // ADD Filter Item Event 
    let filterItems = document.querySelectorAll('.filter-item');
    for(filterItem of filterItems){
        filterItem.addEventListener('click',filterItemAction);
    }
    
    // Search Box Event
    let location = document.querySelector('#location');
	let checkinDate = document.querySelector('#checkin-date');
	let checkoutDate = document.querySelector('#checkout-date');
	let headcount = document.querySelector('#headcount');
	
	location.parentElement.addEventListener('click',clickSearchBox);
	checkinDate.parentElement.addEventListener('click',clickSearchBox);
	checkoutDate.parentElement.addEventListener('click',clickSearchBox);
	headcount.parentElement.addEventListener('click',clickSearchBox);
})
    
function rightScrollFunction() {
    // Header Width
    let headerWidth = document.querySelector('header').getBoundingClientRect().width;
    // Filter Box Width & Left Right Button Width
    let filterBoxWidth = headerWidth*0.8;
    let scrollButtonWidth = headerWidth*0.1;

    // Filter Inner Box
    let filterInnerBox = document.querySelector('.filter-inner-box');

    let transform = filterInnerBox.style.transform;
    let translateX = +transform.slice(11,transform.indexOf("px"));

    // 박스 길이 < items 길이 - left 면 이동금지
    if(filterBoxWidth < (585 + translateX)){
        if(filterBoxWidth > (585 + translateX - 100)){
            filterInnerBoxLeft = (filterBoxWidth - 605) + "px";
            filterInnerBox.style.transform = 'translateX('+filterInnerBoxLeft+')';
            document.querySelector('.right-scroll-button').style.visibility='hidden';
        } else {
            filterInnerBox.style.transform = 'translateX('+ (translateX - 100)+"px"+')';
            if(document.querySelector('.left-scroll-button').style.visibility=='hidden'){
                document.querySelector('.left-scroll-button').style.visibility='visible';
            }
        }
    }
}

// 헤더 왼쪽 스크롤 버튼 이벤트함수
function leftScrollFunction() {
    // Header Width
    let headerWidth = document.querySelector('header').getBoundingClientRect().width;
    // Filter Box Width & Left Right Button Width
    let filterBoxWidth = headerWidth*0.8;
    let scrollButtonWidth = headerWidth*0.1;

    // Filter Inner Box
    let filterInnerBox = document.querySelector('.filter-inner-box');
    let filterInnerBoxLeft = +getComputedStyle(filterInnerBox).left.slice(0,getComputedStyle(filterInnerBox).left.indexOf("px"));

    let transform = filterInnerBox.style.transform;
    let translateX = +transform.slice(11,transform.indexOf("px"));

    // Left 가 20 보다 커지면 오른쪽으로 이동금지
    if(translateX < 20){
        if(20 < (translateX + 100)){
            filterInnerBox.style.transform = 'translateX('+"0px"+')';
            document.querySelector('.left-scroll-button').style.visibility='hidden';
        } else {
            filterInnerBox.style.transform = 'translateX('+ (translateX + 100) + "px"+')';
            if(document.querySelector('.right-scroll-button').style.visibility=='hidden'){
                document.querySelector('.right-scroll-button').style.visibility='visible';
            }
        }
    }
}


// 필터 아이템 클릭 이벤트.
function filterItemAction(e) {
    let item;
    // filter item Click class 추가
    if(e.target.classList.contains('filter-item') || e.target.classList.contains('filter-item-img') || e.target.classList.contains('filter-item-name')){
        if(e.target.classList.contains('filter-item-img') || e.target.classList.contains('filter-item-name')){
            item = e.target.parentElement;
        } else {
            item = e.target;
        }
    }

    if(item.classList.contains('filter-item-clicked')){
        item.classList.remove('filter-item-clicked');
    }else{
        item.className += ' filter-item-clicked';
    }
	
	
    // 위치, 날짜, 인원 확인 ( 없으면 추천 랜덤 리스트로 )
    // 체크된 필터 확인 후 ajax 호출
}

// Modal 박스 클릭 이벤트함수
function clickSearchBox(e) {
	let searchBoxItems = document.querySelectorAll('.search-box-item');
	for(searchBoxItem of searchBoxItems){
		searchBoxItem.classList.remove('search-box-clicked');
		searchBoxItem.classList += ' search-box-unclicked';
	}
	this.parentElement.classList.remove('search-box-unclicked')
	this.parentElement.classList += ' search-box-clicked';
	
	let id = this.lastElementChild.getAttribute("id");
	
	if(id == 'location'){
		let locationModal = document.querySelector('#location-modal');
		locationModal.classList.toggle('modal-active');
	}else if(id == 'checkin-date') {
		let checkinModal = document.querySelector('#checkin-modal');
		checkinModal.classList.toggle('modal-active');
	}else if(id == 'checkout-date') {
		
	}else if(id == 'headcount') {
		
	}
}