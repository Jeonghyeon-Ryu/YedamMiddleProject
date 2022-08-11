let thisId
let msEmoji = document.getElementById("msEmojiAll")

function openContent(id) {
	thisId = id
	document.getElementById("msContentText").style.display = 'block'
	document.getElementById(id).style.display = 'flex'
	let a = document.getElementsByClassName(thisId)
	for (i = 0; i < a.length; i++) {
		a[i].style.display = 'flex';
	}
	document.getElementById("msSendAll").style.display = 'flex'
	document.getElementById("msContentRoom").style.display = 'none'
	document.getElementById("msReceiv").setAttribute("value", thisId);
	document.getElementById("msContent").scrollTo(0, document.getElementById("msContentText").offsetHeight)
	document.getElementById("receviId").innerText = "수신 : " + id;
}

function sendText() {
	let content = document.getElementById("msSendText")
	fetch('sendContent.do?youId=' + thisId + '&msSendText=' + content.value)
		.then(result => result.json())
		.then(readContent)

	function readContent(result) {
		var msParent = document.createElement("div")
		if (result.sender == thisId) {
			msParent.setAttribute("id", "msYouLine")
			msParent.setAttribute("class", thisId)
			if (result.checkEmoji == 1) {
				var msTime = document.createElement("small")
				msTime.innerText = result.currentTime
				var msText = document.createElement("img")
				msText.setAttribute("src", result.content);
			} else {
				var msTime = document.createElement("small")
				msTime.innerText = result.currentTime
				var msText = document.createElement("div")
				msText.innerText = result.content
			}
			msParent.append(msText);
			msParent.append(msTime)
		} else {
			msParent.setAttribute("id", "msMyLine")
			msParent.setAttribute("class", thisId)
			if (result.checkEmoji == 1) {
				var msTime = document.createElement("small")
				msTime.innerText = result.currentTime
				msTime.setAttribute("id", "msMyTime");
				var msText = document.createElement("img")
				msText.setAttribute("id", "msMyText")
				msText.setAttribute("src", result.content);
			} else {
				var msTime = document.createElement("small")
				msTime.innerText = result.currentTime
				msTime.setAttribute("id", "msMyTime");
				var msText = document.createElement("div")
				msText.innerText = result.content
				msText.setAttribute("id", "msMyText")
			}
			msParent.append(msTime)
			msParent.append(msText);
			document.getElementById("msSendText").value = ""
		}
		msParent.style.display = 'flex'
		document.getElementById("msContentText").append(msParent)
		document.getElementById("msContent").scrollTo(0, document.getElementById("msContentText").offsetHeight)
		document.getElementById("msSendText").value = ""
	}
	document.getElementById("msSendText").value = ""
}

function sendEomji(id) {
	document.getElementById("msSendText").value = id
	sendText();
	document.getElementById("msSendText").value = ""
			document.getElementById("msContent").scrollTo(0, document.getElementById("msContentText").offsetHeight)
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
	document.getElementById("msEmojiAll").style.display = 'none'
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
		document.getElementById("msContent").scrollTo(0, document.getElementById("msContentText").offsetHeight)
}

