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
		return d;
	},
	prevMonth: function() {
		let d = new Date();
		d.setDate(1);
		d.setMonth(--this.monForChange);
		this.activeDate = d;
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

let Tag1 = null;
let Tag2 = null;
let eDate = new Date();
let inDate = new Date();
let outDate = new Date();
let checkinDate = new Date();

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
			let fulleDate = getYYDDMM(eDate);
			let fullChkinDate = getYYDDMM(checkinDate);

			console.log(fullDate + ", " + fulleDate + ", " + fullChkinDate);
			if (!startCount) {
				trtd += '<td>'
			} else if (init.monForChange<=eDate.getMonth()&&fullDate < fulleDate) {
				trtd += '<td class="day-disable';
				trtd += ` data-date="${countDay + 1}" data-fdate="${fullDate}">`;
			} else {
				trtd += '<td class="day';
				if (!Tag1 && fullDate == fullChkinDate) {
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



$calBody.addEventListener('click', (e) => {
	if (e.target.classList.contains('day')) {
		let day = Number(e.target.textContent);
		console.log("click event > tag1: " + Tag1 + " 2: " + Tag2);
		
		if ((Tag1 && Tag2)||(!Tag1 && !Tag2)) {
			inDate = init.activeDate.setDate(day);
			console.log(init.activeDate)
			console.log(inDate);
			Tag1=e.target;
			loadDate(inDate);
		} else {
			outDate = init.activeDate.setDate(day);
			Tag2=e.target;
			loadDate2(outDate);
		}
		
		if(OutDate<=inDate){
			inDate = OutDate;
			loadDate(inDate);
			document.querySelector('.cal-day2').textContent="";
		}
	}
	
		/*if (Tag1 && Tag2) {
			Tag1.classList.remove('day-active');
			Tag2.classList.remove('day-active');
			Tag1 = null;
			Tag2 = null;
			document.querySelector('.cal-day2').textContent = "";
		}
		if (!Tag1 && !Tag2) {

			let day = Number(e.target.textContent);
			e.target.classList.add('day-active');
			Tag1 = e.target;
			init.activeDate.setDate(day);
			loadDate(init.activeDate);
		}
		else if (Tag1 && !Tag2) {
			let day2 = Number(e.target.textContent);
			init.activeDate2.setDate(day2);
			if (init.activeDate2 <= init.activeDate) {
				Tag1.classList.remove('day-active');
				Tag1 = null;
				e.target.classList.add('day-active');
				Tag1 = e.target;
				init.activeDate.setDate(day2);
				loadDate(init.activeDate);

			} else {
				loadDate2(init.activeDate2);
				e.target.classList.add('day-active');
				Tag2 = e.target;
				init.activeDate2.setDate(day2);
			}
		}
		checkinDate = init.activeDate;
*/

	
	}
);