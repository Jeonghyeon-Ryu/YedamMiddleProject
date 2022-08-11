function mycall(accId, checkIn=0, checkOut=0) {
   if (!checkIn || !checkOut) {
      alert('메인화면에서서 날짜를 선택하세요.')
      return;
   }
   location.href='reservationPage.do?accId='+accId+'&checkIn='+checkIn+'&checkOut='+checkOut;
}