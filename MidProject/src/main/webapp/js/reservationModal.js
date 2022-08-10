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
	
	fetch('getReservationList.do')
		.then(result => result.json())
		.then(result => {
			if(wishResult.retCode=="exist"){
				card.querySelector('.like').src="img/like-redheart-35.png";
			}
			// 카드 붙이기
			document.querySelector('main').append(card);
		}).catch(err => console.log(err));
	
	
	
	
	
	
	
	
	// ajax.
	fetch('exTourList.do?id=qwe@123')
   .then(result => result.json())
   .then(result => {
      console.log(result)
     
      let company = document.getElementById('ex-comp-title');
      let roomName = document.getElementById('ex-room-name')
      let checkin = document.getElementById('ex-checkin')
      let ckeckout = document.getElementById('ex-checkout')
      let memberName = document.getElementById('ex-name')
      let phone = document.getElementById('ex-phone')
      let price = document.getElementById('ex-price')
      let div = document.createElement('div');
      for(let itm of result) {
      company.innerText= itm.name;
      roomName.innerText=itm.roomName;
      checkin.innerText = itm.reservationTime;
      ckeckout.innerText = itm.reservationDay;
      memberName.innerText = itm.memberName;
      phone.innerText = itm.phone;
      price.innerText = itm.paymentCost;
      }
   })
   .catch(err => console.log(err))

	
	
}

function reservList(result) {
	
}

