let pickCard = document.querySelector('.card [accid="500"]');
pickCard.addEventListener('click', clickCard);

function clickCard() {
	location.href="compDetail.do?accid="+pickCard.value;
}



