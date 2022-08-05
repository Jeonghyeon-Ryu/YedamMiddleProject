const init = {
	monList: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
	dayList: ['일', '월', '화', '수', '목', '금', '토'],
	today: new Date(),
	monForChange: new Date().getMonth(),
	activeDate: new Date(),
	activeDate2: new Date(),
	getFirstDay: (yy, mm) => new Date(yy, mm, 1),
	getLastDay: (yy, mm) => new Date(yy, mm + 1, 0),
	nextMonth: function() {
		let d = new Date();
		d.setDate(1);
		d.setMonth(++this.monForChange);
		this.activeDate = d;
		this.activeDate2=d;
		return d;
	},
	prevMonth: function() {
		let d = new Date();
		d.setDate(1);
		d.setMonth(--this.monForChange);
		this.activeDate = d;
		this.activeDate2= d;
		return d;
	},
	addZero: (num) => (num < 10) ? '0' + num : num,

	getIndex: function(node) {
		let index = 0;
		while (node = node.previousElementSibling) {
			index++;
		}
		return index;
	}
};

const $calBody = document.querySelector('.cal-body');
const $btnNext = document.querySelector('.btn-cal.next');
const $btnPrev = document.querySelector('.btn-cal.prev');

let dateTag1 = null;
let dateTag2 = null;
let checkinDate=new Date();
function getYYDDMM(date) {
	return date.getFullYear() + '.' + init.addZero(date.getMonth() + 1) + '.' + init.addZero(date.getDate());
}

function loadYYMM(fullDate) {
	let yy = fullDate.getFullYear();
	let mm = fullDate.getMonth();
	console.log(mm)
	console.log(init.monList[mm])
	let firstDay = init.getFirstDay(yy, mm);
	let lastDay = init.getLastDay(yy, mm);

	if (mm === init.today.getMonth() && yy === init.today.getFullYear()) {
		markToday = init.today.getDate();
	}

	document.querySelector('.cal-month').textContent = init.monList[mm];
	document.querySelector('.cal-year').textContent = yy;

	let trtd = '';
	let startCount;
	let countDay = 0;
	for (let i = 0; i < 6; i++) {
		trtd += '<tr>';
		for (let j = 0; j < 7; j++) {
			if (i === 0 && !startCount && j === firstDay.getDay()) {
				startCount = 1;
			}

			let fullDate = yy + '.' + init.addZero(mm + 1) + '.' + init.addZero(countDay + 1);
			let fullChkinDate = getYYDDMM(checkinDate);

			if (!startCount) {
				trtd += '<td>'
			}  else {
				trtd += '<td class="day';
				if (!dateTag1 && fullDate == fullChkinDate) {
					loadDate(checkinDate)
					trtd += ' day-active';
				}
				trtd += ` data-date="${countDay + 1}" data-fdate="${fullDate}">`;
			}
			trtd += (startCount) ? ++countDay : '';
			if (countDay === lastDay.getDate()) {
				startCount = 0;
			}
			trtd += '</td>';
		}
		trtd += '</tr>';
	}
	$calBody.innerHTML = trtd;
}


function createNewList(val) {
	let id = new Date().getTime() + '';
	let yy = init.activeDate.getFullYear();
	let mm = init.activeDate.getMonth() + 1;
	let dd = init.activeDate.getDate();
	const $target = $calBody.querySelector(`.day[data-date="${dd}"]`);

	let date = yy + '.' + init.addZero(mm) + '.' + init.addZero(dd);

	let eventData = {};
	eventData['date'] = date;
	eventData['memo'] = val;
	eventData['complete'] = false;
	eventData['id'] = id;

	init.event.push(eventData);

}
loadYYMM(init.today);

$btnNext.addEventListener('click', () => loadYYMM(init.nextMonth()));
$btnPrev.addEventListener('click', () => loadYYMM(init.prevMonth()));

function loadDate(day) {
	document.querySelector('.cal-day1').textContent = day.getFullYear() + ". " + (day.getMonth() + 1) + ". " + day.getDate();
}

function loadDate2(day) {
	document.querySelector('.cal-day2').textContent = day.getFullYear() + ". " + (day.getMonth() + 1) + ". " + day.getDate();
}


let inDate1=new Date;
$calBody.addEventListener('click', (e) => {
	console.log('1 :'+dateTag1+','+dateTag2)
	if (e.target.classList.contains('day')) {
		if (dateTag1 && dateTag2) {
			dateTag1.classList.remove('day-active');
			dateTag2.classList.remove('day-active');
			dateTag1 = null;
			dateTag2 = null;
			document.querySelector('.cal-day2').textContent = "";
			inDate1=null;
		}
		if (!dateTag1 && !dateTag2) {

			let day = Number(e.target.textContent);
			e.target.classList.add('day-active');
			dateTag1 = e.target;
			init.activeDate.setDate(day);
			loadDate(init.activeDate);
			inDate1=init.activeDate;
			console.log("tag:"+dateTag1.textContent)
		}
		else if (dateTag1 && !dateTag2) {
			let day2 = Number(e.target.textContent);
			init.activeDate2.setDate(day2);
			
			console.log(init.activeDate2+', '+inDate1)
			if (init.activeDate2 <= inDate1) {
				dateTag1.classList.remove('day-active');
				e.target.classList.add('day-active');
				dateTag1 = e.target;
				init.activeDate.setDate(day2);
				loadDate(init.activeDate);
				

			} else {
				loadDate2(init.activeDate2);
				e.target.classList.add('day-active');
				dateTag2 = e.target;
				init.activeDate2.setDate(day2);
			}
		}
		checkinDate = init.activeDate;
		
		console.log(dateTag1,dateTag2,inDate1)
	}
});