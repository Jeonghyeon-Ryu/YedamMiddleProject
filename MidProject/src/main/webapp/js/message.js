let thisId
let msEmoji = document.getElementById("msEmojiAll")
function openContent(id) {
	thisId = id
	console.log(id)
	document.getElementById("msContentText").style.display = 'block'
	document.getElementById(id).style.display = 'flex'
	let a = document.getElementsByClassName(thisId)
	for (i = 0; i < a.length; i++) {
		a[i].style.display = 'flex';
	}
	document.getElementById("msSendAll").style.display = 'flex'
	document.getElementById("msContentRoom").style.display = 'none'
	document.getElementById("msReceiv").setAttribute("value", thisId);
	document.getElementById("msContent").scrollTo(0, document.getElementById("msSendContent").offsetHeight)
	document.getElementById("receviId").innerText = "수신 : " + id;
}

function openReContent() {

	let recevi = document.getElementById("exitRecevi").value
	if (recevi != "") {
		console.log('start')
		openContent(recevi)
	}
	document.getElementById("msEmojiAll").style.display = 'none'
}

function openAllMs() {
	document.getElementById("msContentText").style.display = 'none'
	document.getElementById("msSendAll").style.display = 'none'
	let a = document.getElementsByClassName(thisId)
	for (i = 0; i < a.length; i++) {
		a[i].style.display = 'none';
	}
	document.getElementById("msContentRoom").style.display = 'block'
	document.getElementById("receviId").innerText = "";
}

function openMsEmoji() {
	let msEmoji = document.getElementById("msEmojiAll")
	if (
		msEmoji.style.display == 'block'
	) {
		msEmoji.style.display = 'none'
	} else {
		msEmoji.style.display = 'block'
	}
	document.getElementById("msSendContent").scrollTop = document.getElementById("msSendContent").scrollHeight;
}
function sendEomji(id) {
	document.getElementById("msSendText").setAttribute("value", id)
	document.getElementById("msSendContent").submit();
}

