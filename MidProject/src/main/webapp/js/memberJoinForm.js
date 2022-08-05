let id = document.getElementById("memberId");
let identi1 = document.getElementById("identi");
let identi2 = document.getElementById("identi2");
let pw1 = document.getElementById("memberPw");
let pw2 = document.getElementById("memberPw2");
let phone1 = document.getElementById("phone1");
let phone2 = document.getElementById("phone2");
let phone3 = document.getElementById("phone3");

id.onchange = chkChange;
pw2.onchange = pw2Chk;

let idchangeChk = 0;
function chkChange() {
	idchangeChk = 0;
}

function IdCheck() {
	let regExp = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/;
	document.getElementById("idMsg").style.display = 'flex';

	fetch('idcheckAjax.do?memberId=' + id.value)
	.then(result => result.text())
	.then(result => {
		if (result == 1) {
			document.getElementById("idMsg").style.color = 'red';
			document.getElementById('idMsg').innerText = '중복된 아이디입니다.';
		} else {
			if (!regExp.test(id.value)) {
				document.getElementById("idMsg").style.color = 'red';
				document.getElementById('idMsg').innerText = "아이디는 이메일 형식으로 입력하세요.";
			} else {
				document.getElementById("idMsg").style.color = 'green';
				document.getElementById('idMsg').innerText = '사용가능한 아이디입니다.';
				idChangeChk = 1;
				return true;
			}
		}
		idChangeChk = 0;
		return false;
	})
}

let identiMsg = '주민번호를 올바르게 입력해주세요';
function identiChk() {
	let regExp = /^(?:[0-9]{2}(?:0[1-9]|1[0-2])(?:0[1-9]|[1,2][0-9]|3[0,1]))-[1-8][0-9]{6}$/;

	let arrNum1 = new Array(); // 주민번호 앞자리숫자 6개를 담을 배열
	let arrNum2 = new Array(); // 주민번호 뒷자리숫자 7개를 담을 배열

	// -------------- 주민번호 -------------
	for (let i = 0; i < identi1.value.length; i++) {
		arrNum1[i] = identi1.value.charAt(i);
	} // 주민번호 앞자리를 배열에 순서대로 담는다.

	for (let i = 0; i < identi2.value.length; i++) {
		arrNum2[i] = identi2.value.charAt(i);
	} // 주민번호 뒷자리를 배열에 순서대로 담는다.

	var tempSum = 0;
	for (let i = 0; i < identi1.value.length; i++) {
		tempSum += arrNum1[i] * (2 + i);
	} // 주민번호 검사방법을 적용하여 앞 번호를 모두 계산하여 더함

	for (let i = 0; i < identi2.value.length - 1; i++) {
		if (i >= 2) {
			tempSum += arrNum2[i] * i;
		}
		else {
			tempSum += arrNum2[i] * (8 + i);
		}
	} // 같은방식으로 앞 번호 계산한것의 합에 뒷번호 계산한것을 모두 더함

	if ((11 - (tempSum % 11)) % 10 != arrNum2[6]) {
		document.getElementById("identi-error").style.display = 'flex';
		document.getElementById('identi-error').innerText = identiMsg;
		identi1.value = "";
		identi2.value = "";
		return false;
	} else {
		document.getElementById('identi-error').innerText = "";
		return true;
	}
}

function pwChk() {
	let regExp = /^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[$`~!@$!%*#^?&\\(\\)\-_=+]).{8,16}$/;

	if (pw1.value.length1 < 8 || pw1.value.length1 > 16) {
		document.getElementById("pw-error").style.display = 'flex';
		document.getElementById('pw-error').innerText = "8자리 ~ 16자리 이내로 입력해주세요.";
		pw1.value = "";
		return false;
	} else if (!regExp.test(pw1.value)) {
		document.getElementById("pw-error").style.display = 'flex';
		document.getElementById('pw-error').innerText = "영문,숫자,특수문자를 포함하여 입력하세요.";
		pw1.value = "";
		return false;
	} else {
		document.getElementById("pw-error").style.display = 'none';
		return true;
	}
}


function pw2Chk() {
	if (pw1.value != pw2.value) {
		document.getElementById("pw2-error").style.display = 'flex';
		document.getElementById('pw2-error').innerText = '비밀번호가 일치하지 않습니다.';
		document.getElementById("pw2-error").style.color = 'red';
		pw2.value = "";
		return false;
	} else {
		document.getElementById("pw2-error").style.display = 'none';
		return true;
	}
}

function phoneChk() {
	let regExp = /^01(?:0|1|[6-9])-(?:\d{3}|\d{4})-\d{4}$/;
	let pNum = phone1.value + '-' + phone2.value + '-' + phone3.value;
	console.log(pNum)
	if (!regExp.test(pNum)) {
		document.getElementById("phone-error").style.display = 'flex';
		document.getElementById("phone-error").innerText = '휴대폰 전화번호를 입력하세요';
		return false;
	} else {
		document.getElementById("phone-error").style.display = 'none';
		return true;
	}
}

function frmChk() {
	pwChk();
	pw2Chk();
	phoneChk();
	identiChk();
	if (idChangeChk == 0) {
		document.getElementById("idMsg").style.display = 'flex';
		document.getElementById("idMsg").style.color = 'red';
		document.getElementById('idMsg').innerText = "중복검사를 하세요";
	}
	if (pwChk() && pw2Chk() && phoneChk() && identiChk() && idChangeChk) {
		document.getElementById('mInfo-frm').submit();
	} else
		alert('입력한 값을 다시 확인해주세요')
}