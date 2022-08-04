var loginId = document.getElementById("userId").innerText

let xhtp = new XMLHttpRequest();
xhtp.open('get', 'js/asdf.txt');
xhtp.send();
xhtp.onreadystatechange = callBackContent();
const set = new Set(); //중복제거용


function callBackContent() {
	if (this.readyState == 4 && this.status == 200) {
		data = JSON.parse(this.responseText);
		//중복제거
		console.log(data)
		for (let a of data) {
			if (a.sender == loginId) {
				set.add(a.receiver)
			} else if (a.receiver == loginId) {
				set.add(a.sender)
			}
		}
	}
}

function openContent() {
	let btn =
	
	
	console.log(btn)
	
	
	// for (let item of set.keys()) {
	// 	document.getElementById("msContentRoom").style.display = 'block'

	// 	for (let a of data) {
	// 		if ((a.sender == loginId && a.receiver == item) || (a.sender == item && a.receiver == 'a')) {
	// 			let content = document.createElement('div');
	// 			content.setAttribute("class", "text");
	// 			if (a.sender == 'a') {
	// 				content.setAttribute("id", 'my');
	// 				content.innerText = a.ct;
	// 			} else if (a.receiver == 'a') {
	// 				content.setAttribute("id", 'you');
	// 				content.innerText = a.ct;
	// 			}
	// 			document.getElementById("msContentText").append(content);
	// 		}
	// 	}
	// }
}