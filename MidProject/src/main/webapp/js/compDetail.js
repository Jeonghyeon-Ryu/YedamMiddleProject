document.querySelector('.card[accid="14255"]').addEventListener('click', function(event) {
	var card = new XMLHttpRequest();
	card.open('GET', '../main.do');
	card.addEventListener('readystatechange', function() {
		if (card.readyState == 4 && card.status == 200) {
			document.querySelector('.comp-title').innerHTML = card.responseText;
		}
	})
	card.send();
});


$(function() {
	$(document).on("click", "card[accid="+[i]+"]", function(event) {
		$.ajax({
			url: "/compDetail.do",
			type: "GET",
			dataType: "json",
			success: function(res) {
                  req[i].name
                  req[i].reviewId
                  req[i].Address
                  req[i].Phone
                  req[i].name
                  req[i].name
			},
			error: function(er) {
				console.log("실패원인 : " + er);
			}
		})
	})
})