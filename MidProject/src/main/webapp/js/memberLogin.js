function mainLogin(){
	event.preventDefault();
	let id = document.getElementById("memberId");
	let pw = document.getElementById("memberPw");
	let msg = document.getElementById('login-error-msg');
	fetch('login.do?memberId=' + id.value+"&memberPw="+pw.value)
	.then(result => result.text())
	.then(result => {
		if (result==0) {
			msg.innerText = '아이디 또는 비밀번호가 존재하지 않습니다.';
		} else {
			window.location.href = 'main.do';
		}
	})
}