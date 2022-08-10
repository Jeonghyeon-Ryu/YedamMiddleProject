window.addEventListener('load', () => {
	document.querySelector('#nav-reservation').addEventListener('click',reservationModalOpenAction);
	document.querySelector('#reservation-modal .modal-close-button').addEventListener('click',modalCloseAction);
})

function reservationModalOpenAction(e) {
	closeAllModal();
	let modal = document.querySelector('#reservation-modal');
	let body = document.querySelector('body');
	modal.classList.toggle('modal-active');
	body.classList.toggle('modal-active-background');
	


function getWishList(){
	fetch('exTourList.do?id=vxxv@naver.com', {
		method: 'POST',
	}).then(result => result.json())
		.then(exTourList)
		.catch(err => console.log(err));
}

function exTourList(result) {
   let template = document.querySelector('#ex-template');
   for(let i=0; i<result.length; i++) {
	console.log(result)
      let exTour = document.importNode(template.content, true);
      exTour.querySelector('img').src=result[i].imgUrl;
      exTour.querySelector('.ex-title').innerHTML=result[i].name;
      exTour.querySelector('.ex-address').innerHTML=result[i].address;
      exTour.querySelector('.ex-checkIn').innerHTML=result[i].reservationTime;
      exTour.querySelector('.ex-checkOut').innerHTML=result[i].reservationDay;
      exTour.querySelector('.ex-memberName').innerHTML=result[i].memberName;
      exTour.querySelector('.ex-phone').innerHTML=result[i].phone;
      exTour.querySelector('.ex-price').innerHTML=result[i].price;
      exTour.querySelector('.ex-container').setAttribute('id','w'+result[i].id);
      document.querySelector('#reservation-modal .modal-content').append(exTour);
   }
}

getWishList();

	// ajax.
//	fetch('exTourList.do?id=vxxv@naver.com')
//   .then(result => result.json())
//   .then(result => {
//      console.log(result)
//      let imgUrl = document.getElementById('ex-img');
//      let company = document.getElementById('ex-comp-title');
//      let roomName = document.getElementById('ex-room-name');
//      let checkin = document.getElementById('ex-checkin');
//      let ckeckout = document.getElementById('ex-checkout');
//      let memberName = document.getElementById('ex-name');
//      let phone = document.getElementById('ex-phone');
//      let price = document.getElementById('ex-price');
//      let div = document.createElement('div');
//      for(let i=0; i>result.length; i++) {
//	  imgUrl.innerText = result.imgUrl;
//      company.innerText= itm.name;
//      roomName.innerText=itm.roomName;
//      checkin.innerText = itm.reservationTime;
//      ckeckout.innerText = itm.reservationDay;
//      memberName.innerText = itm.memberName;
//      phone.innerText = itm.phone;
//      price.innerText = itm.paymentCost;
//      }
//   })
//   .catch(err => console.log(err))
}


