function getExTourList(){
   fetch({
      method : 'POST'
   }).then(result => result.json())
      .then(ExTourList)
      .catch(err => consoloe.log(err))
}

function ExTourList(result) {
   let template = document.querySelector('#ex-template');
   for(let i=0; i<result.length; i++) {
      let exTour = document.importNode(template.content, true);
      exTour.querySelector('.exTourList-placeImg').src=result[i].imgUrl;
      exTour.querySelector('#ex-title').innerHTML=result[i].name;
      exTour.querySelector('#ex-address').innerHTML=result[i].address;
      exTour.querySelector('#ex-checkIn').innerHTML=result[i].reservationTime;
      exTour.querySelector('#ex-checkOut').innerHTML=result[i].reservationDay;
      exTour.querySelector('#ex-name').innerHTML=result[i].memberId;
      exTour.querySelector('#ex-phone').innerHTML=result[i].phone;
      exTour.querySelector('#ex-price').innerHTML=result[i].price;
      exTour.querySelector('#ex-container').setAttribute('id','w'+result[i].id);
      document.querySelector('#reservation-modal .modal-content').append(exTour);
   }
}