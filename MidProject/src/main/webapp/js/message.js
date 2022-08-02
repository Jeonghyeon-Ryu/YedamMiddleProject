let mu = document.getElementById("menu")
let content1 = document.getElementById("content1")
let content2 = document.getElementById("content2")
let content3 = document.getElementById("content3")
let content4 = document.getElementById("content4")
let condition1 = document.getElementById("condition1")
let condition2 = document.getElementById("condition2")
let condition3 = document.getElementById("condition3")
let condition4 = document.getElementById("condition4")
let openCheck = 1;

let xhtp = new XMLHttpRequest();
xhtp.open('get', 'js/asdf.txt');
xhtp.send();
xhtp.onreadystatechange = callBackThree;

const set = new Set();
AOS.init({
	duration: 1000
});

function callBackThree() {
	let aosCheck = true;
	let aosDelay = 0;
	if (this.readyState == 4 && this.status == 200) {
		data = JSON.parse(this.responseText);

		for (let a of data) {
			if (a.name == 'a') {
				set.add(a.bname)
			} else if (a.bname == 'a') {
				set.add(a.name)
			}
			if ((a.name == 'a') || (a.bname == 'a')) {
				let content = document.createElement('p');
				content.setAttribute("class", "content");
				if (a.name == 'a') {
					content.setAttribute("id", 'send');
				} else if (a.bname == 'a') {
					content.setAttribute("id", 'receive');
				}
				content.innerText = a.ct;
				document.getElementById("content1").append(content);
			}
		}

		for (let item of set.keys()) {
			let area = document.createElement('button');
			area.setAttribute("class", "area");
			area.setAttribute("id", item);
			if (aosCheck == true) {
				area.setAttribute("data-aos", "flip-up")
				aosCheck = false
			} else {
				area.setAttribute("data-aos", "flip-down")
				aosCheck = true;
			}
			area.setAttribute("data-aos-delay", aosDelay)
			aosDelay += 300;
			document.getElementById("content1").append(area);
			area.attachEvent
		}
	}
}

function openContent() {
	if (this.readyState == 4 && this.status == 200) {
		data = JSON.parse(this.responseText);
		for (let a of data) {
			if ((a.name == 'a' && a.bname == item) || (a.name == item && a.bname == 'a')) {
				let content = document.createElement('p');
				content.setAttribute("class", "content");
				if (a.name == 'a') {
					content.setAttribute("id", 'my');
				} else if (a.bname == 'a') {
					content.setAttribute("id", 'you');
				}
				content.innerText = a.ct;
				document.getElementById("content1").append(content);
			}
		}
		document.getElementsByClassName("content").style.display = 'block'
	}
}

function openMenu() {
	openCheck *= -1;
	if (openCheck == 1) {
		mu.style.display = 'none';
	} else {
		mu.style.display = 'flex';
		mu.style.flexDirection = 'column';
	}
}

function openAllMs() {
	content1.style.display = 'flex';
	content2.style.display = 'none';
	content3.style.display = 'none';
	content4.style.display = 'none';
	condition1.style.display = 'flex';
	condition1.style.fontWeight = 'bold'
	condition2.style.display = 'none';
	condition1.style.borderBottom = '1px solid red';
	condition3.style.display = 'none';
	condition4.style.fontWeight = 'lighter'
	condition4.style.borderBottom = 'none';
}

function openSaveMs() {
	content1.style.display = 'none';
	content2.style.display = 'flex';
	content3.style.display = 'none';
	content4.style.display = 'none';
	condition1.style.display = 'none';
	condition2.style.display = 'flex';
	condition2.style.fontWeight = 'bold'
	condition2.style.borderBottom = '1px solid red';
	condition3.style.display = 'none';
	condition4.style.fontWeight = 'lighter'
	condition4.style.borderBottom = 'none';
}

function openNotReadMs() {
	content1.style.display = 'none';
	content2.style.display = 'none';
	content3.style.display = 'flex';
	content4.style.display = 'none';
	condition1.style.display = 'none';
	condition2.style.display = 'none';
	condition3.style.display = 'flex';
	condition3.style.fontWeight = 'bold'
	condition3.style.borderBottom = '1px solid red';
	condition4.style.fontWeight = 'lighter'
	condition4.style.borderBottom = 'none';
}

function openNoticeMs() {
	content1.style.display = 'none';
	content2.style.display = 'none';
	content3.style.display = 'none';
	content4.style.display = 'flex';
	condition1.style.fontWeight = 'lighter'
	condition2.style.fontWeight = 'lighter'
	condition3.style.fontWeight = 'lighter'
	condition4.style.fontWeight = 'bold'
	condition1.style.borderBottom = 'none';
	condition2.style.borderBottom = 'none';
	condition3.style.borderBottom = 'none';
	condition4.style.borderBottom = '1px solid red';
}