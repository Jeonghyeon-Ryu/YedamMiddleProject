let mu = document.getElementById("menu")
let content1 = document.getElementById("content1")
let content2 = document.getElementById("content2")
let content3 = document.getElementById("content3")
let content4 = document.getElementById("content4")
let condition1 = document.getElementById("condition1")
let condition2 = document.getElementById("condition2")
let condition3 = document.getElementById("condition3")
let condition4 = document.getElementById("condition4")
let openCheck = 1; //메뉴창 열림 확인

let xhtp = new XMLHttpRequest();
xhtp.open('get', 'js/asdf.txt');
xhtp.send();
xhtp.onreadystatechange = callBackContent;
const set = new Set(); //중복제거용

//대화창 애니메이션
AOS.init({
	duration: 1000
});

//접속자의 메뉴 생성
function callBackContent() {
	let aosCheck = true;
	let aosDelay = 0;
	if (this.readyState == 4 && this.status == 200) {
		data = JSON.parse(this.responseText);

		//중복제거
		for (let a of data) {
			if (a.name == 'a') {
				set.add(a.bname)
			} else if (a.bname == 'a') {
				set.add(a.name)
			}
		}
		//대화목록 생성
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
			document.getElementById("contentRoom").append(area);

			//대화내용 생성
			area.addEventListener("click", function (e) {
				document.getElementById("contentText").style.display = 'block'
				if (e.target && e.target.id == item) {
					console.log(item);
					for (let a of data) {
						if ((a.name == 'a' && a.bname == item) || (a.name == item && a.bname == 'a')) {
							let content = document.createElement('div');
							content.setAttribute("class", "text");
							if (a.name == 'a') {
								content.setAttribute("id", 'my');
								content.innerText = a.ct;
							} else if (a.bname == 'a') {
								content.setAttribute("id", 'you');
								content.innerText = a.ct;
							}
							document.getElementById("contentText").append(content);
						}
					}
					document.getElementById("contentRoom").style.display='none'
					let recevi =document.createElement('input');
					recevi.setAttribute('id','recevi');
					recevi.setAttribute('value',item);
					recevi.setAttribute('type','hidden');
					let send =document.createElement('input');
					send.setAttribute('id','send');
					send.setAttribute('value','a');
					send.setAttribute('type','hidden');
					let inputContent =document.createElement('input');
					inputContent.setAttribute('id','inputContent')
					inputContent.setAttribute('type','text')
					let sendContent =document.createElement('input');
					sendContent.setAttribute('type','submit')
					sendContent.setAttribute('value','전송')
					document.getElementById("contentText").append(recevi);
					document.getElementById("contentText").append(send);
					document.getElementById("contentText").append(inputContent);
					document.getElementById("contentText").append(sendContent);
				}
			})
		}
	}
}

//메뉴 여는 기능
function openMenu() {
	openCheck *= -1;
	if (openCheck == 1) {
		mu.style.display = 'none';
	} else {
		mu.style.display = 'flex';
		mu.style.flexDirection = 'column';
	}
}

//전체메뉴
function openAllMs() {
	content1.style.display = 'block'
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
	document.getElementById("contentRoom").style.display = 'flex';
	document.getElementById("contentText").style.display = 'none'
	let q = document.getElementById("contentText")
	while (q.hasChildNodes()) {
		q.removeChild(q.firstChild);
	}
}

//저장메뉴
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
	document.getElementById("contentText").style.display = 'none'
}

//안읽은메뉴
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
	document.getElementById("contentText").style.display = 'none'
}

//공지메뉴
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
	document.getElementById("contentText").style.display = 'none'
}