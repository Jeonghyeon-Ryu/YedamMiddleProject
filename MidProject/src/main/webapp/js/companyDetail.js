function mycall(accId, checkIn=0, checkOut=0) {
	let memberId = document.querySelector('.member-id').innerText;
	console.log(memberId);
	if(memberId==undefined){
		alert('예약하시려면 로그인이 필요합니다');
		return;
	}
   if (!checkIn || !checkOut) {
      alert('메인화면에서서 날짜를 선택하세요.')
      return;
   }
}