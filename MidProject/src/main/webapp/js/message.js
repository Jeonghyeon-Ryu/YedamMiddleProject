let thisId



function openContent(id) {
	thisId = id
	console.log(id)
	document.getElementById("msContentText").style.display = 'block'
	document.getElementById(id).style.display = 'block'
	let a = document.getElementsByClassName(thisId)
	for (i = 0; i < a.length; i++) {
		a[i].style.display = 'block';
	}
	document.getElementById("msContentRoom").style.display = 'none'
	document.getElementById("msReceiv").setAttribute("value", thisId);
	document.getElementById("msSendText").autofocus;
}

function openReContent() {
	
	let recevi = document.getElementById("exitRecevi").innerText
	if (recevi != "") {
		console.log('start')
		openContent(recevi)
	}
}

function openAllMs() {
	document.getElementById("msContentText").style.display = 'none'
	let a = document.getElementsByClassName(thisId)
	for (i = 0; i < a.length; i++) {
		a[i].style.display = 'none';
	}
	document.getElementById("msContentRoom").style.display = 'block'
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
}
function sendEomji(id){
	document.getElementById("msSendText").setAttribute("value",id)
	document.getElementById("msSendContent").submit();
}