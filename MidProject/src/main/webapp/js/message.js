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
function callBackThree() {

	if (this.readyState == 4 && this.status == 200) {
		data = JSON.parse(this.responseText);

		for (let a of data) {
			if (a.name == 'a') {
				set.add(a.bname)
			} else if (a.bname == 'a') {
				set.add(a.name)
			}
		}
		for (let i = 0; i < set.size; i++) {
			let area = document.createElement('button');
			console.log(set);
			area.setAttribute("class", "area");
			area.setAttribute("id", set[i]);
			area.setAttribute("value", set[i]);
			document.getElementById("content1").append(area);
		}
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
	content1.style.display = 'block';
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