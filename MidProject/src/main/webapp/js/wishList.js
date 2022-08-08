window.addEventListener('load', () => {
	document.querySelector('#nav-wishlist').addEventListener('click',wishlistModalOpenAction);
	document.querySelector('#wishlist-modal .modal-close-button').addEventListener('click',modalCloseAction);
})

function wishlistModalOpenAction(e) {
	closeAllModal();
	let modal = document.querySelector('#wishlist-modal');
	let body = document.querySelector('body');
	
	if(modal.classList.contains('modal-active')){
		modal.classList.toggle('modal-active');
		body.classList.toggle('modal-active-background');
		return;
	}
	modal.classList.toggle('modal-active');
	body.classList.toggle('modal-active-background');
	
	fetch('getWish.do', {
		method: 'POST',
	}).then(result => result.json())
		.then(createWishList)
		.catch(err => console.log(err));
}

function createWishList(result){
	let template = document.querySelector('#wish-template');
	for(let i=0; i<result.length; i++){
		let wish = document.importNode(template.content, true);
		wish.querySelector('img').src=result[i].imgUrl;
		wish.querySelector('strong').innerHTML=result[i].name;
		wish.querySelector('span').innerHTML=result[i].address;
		wish.querySelector('.wish-container').setAttribute('id','w'+result[i].acc_id);
		document.querySelector('#wishlist-modal .modal-content').append(wish);
		$('#wishlist-modal .modal-content').on("click","#w"+result[i].accId,function(e){
			let clickedCard = e.target;
			while(!clickedCard.classList.contains('wish-container')){
				clickedCard = clickedCard.parentElement;	
			}
			clickedCard = clickedCard.getAttribute('id');
			// Card 콘텐츠 눌렀을때. -> 상세페이지 Modal + Ajax 호출
			$.ajax({
				url: "",
				data: { "accId" : clickedCard },
				method: "GET",
				success: function(result){
					if(result=="success"){
						e.target.src = "img/like-redheart-35.png";
					} else if(result=="delete"){
						e.target.src = "img/like-heart-35.png";
					}
				}, error : function(err){
					console.log(err);
				}
			})
		});
	}
}