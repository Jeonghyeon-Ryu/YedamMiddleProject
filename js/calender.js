const init = {
  monList: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
  dayList: ['일', '월', '화', '수', '목', '금', '토'],
  today: new Date(),
  monForChange: new Date().getMonth(),
  activeDate: new Date(),
  activeDate2 : new Date(),
  getFirstDay: (yy, mm) => new Date(yy, mm, 1),
  getLastDay: (yy, mm) => new Date(yy, mm + 1, 0),
  nextMonth: function () {
    let d = new Date();
    d.setDate(1);
    d.setMonth(++this.monForChange);
    this.activeDate = d;
    return d;
  },
  prevMonth: function () {
    let d = new Date();
    d.setDate(1);
    d.setMonth(--this.monForChange);
    this.activeDate = d;
    return d;
  },
  addZero: (num) => (num < 10) ? '0' + num : num,
  activeDTag: 0,
  getIndex: function (node) {
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


function loadDate(month, date) {
  document.querySelector('.cal-month').textContent = month;
  document.querySelector('.cal-date').textContent = date;
}
function loadDate2(month, date) {
  document.querySelector('.cal-month2').textContent = month;
  document.querySelector('.cal-date2').textContent = date;
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
      if (!startCount) {
        trtd += '<td>'
      } else {
        let fullDate = yy + '.' + init.addZero(mm + 1) + '.' + init.addZero(countDay + 1);
        trtd += '<td class="day';
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
  $todoList.appendChild(createLi(id, val, date));

  init.activeDate2=init.activeDate;
}

loadYYMM(init.today);

$btnNext.addEventListener('click', () => loadYYMM(init.nextMonth()));
$btnPrev.addEventListener('click', () => loadYYMM(init.prevMonth()));


$calBody.addEventListener('click', (e) => {
  if (e.target.classList.contains('day')) {
    if (init.activeDTag==0) {
      let day = Number(e.target.textContent);
      e.target.classList.add('day-active');
      init.activeDTag = e.target;
      init.activeDate.setDate(day);
      loadDate(day, init.activeDate.getMonth());

      console.log('데이트' + init.activeDate)
    }else if(init.activeDTag==1){
      let day2 = Number(e.target.textContent);
      init.activeDate2.setDate(day2);
      if (init.activeDate2 <= init.activeDate) {
        init.activeDTag.classList.remove('day-active');
      } else {
        loadDate(day2, init.activeDate2.getMonth());
        e.target.classList.add('day-active');
        init.activeDTag = null;
        init.activeDate2.setDate(day2);
        
      }
      
      
      
      
    }
    
  }
});