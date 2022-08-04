<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보입력</title>
</head>
<style>
	#container{width:50%; max-width:400px; margin:0 auto;}
	input{border: none;}
	.input{border-bottom:1px solid lightgray ; padding : 10px; max-width :400px; text-align: left;}
	p{text-align:center;}
	input>label{width : 180px}
	.identi, .phone{border:1px solid lightgray; width : 50px;}
</style>
<body>
	<div id="container">
		<div>
			<h1>회원가입</h1>
		</div>
		<div>
			<form id="frm" name="frm" action="memberJoin.do" method="post">
				<div class="input">
					<label for="memberId">아이디</label> 
					<input type="email"id="memberId" name="memberId" placeholder="이메일 형식으로 입력하세요"> &nbsp;
					<button type="button" id="idCheck" name="idCheck" onclick="javascript:IdCheck();">중복체크</button>
					<p style="display: none;" id="idmessage1" ></p>
				</div>
				<div class="input">
					<label for="memberNm">이름</label> 
					<input type="text" id="memberNm" name="memberNm">
				</div>
				<div class="input">
					<label for="identi">주민번호</label> 
					<input type="text" class="identi" id="identi" name="identi">
					- <input type="password" class="identi" id="identi2" name="identi2">
				</div>
				<div class="input">
					<label for="memberPw">비밀번호</label> 
					<input type="password" id="memberPw" name="memberPw" >
				</div>
				<div class="input">
					<label for="memberPw2">비밀번호 확인</label> 
					<input type="password" id="memberPw2" name="memberPw2" >
				</div>
				<div class="input">
					<label for="phone1">연락처</label> 
					<input type="text" class="phone" id="phone1" name="phone1" maxlength="4" size=4>
						- <input type="text" class="phone" id="phone2" name="phone2" maxlength="4" size=4>
						- <input type="text" class="phone" id="phone3" name="phone3" maxlength="4" size=4>
				</div>
			
				<br>
				<div>
					<button type="submit" onclick="formCheck();">회원가입</button>&nbsp;&nbsp;&nbsp;
					<button type="reset">취 소</button>&nbsp;&nbsp;&nbsp;
					<button type="button" onclick="location.href='main.do'">홈</button>
				</div>
			</form>
		</div>
	</div>

<script type="text/javascript">
	function IdCheck() {
		 let id = document.getElementById("memberId").value;
		 
	     fetch('idcheckAjax.do?memberId=' + id)
	     .then(result => result.text())
	     .then(result => {
	            console.log(result);
	            if(result == 1) {
	              document.getElementById("idmessage1").style.display ='flex';
	              document.getElementById('idmessage1').innerText ='중복된 아이디입니다.'
	              document.getElementById("idmessage1").style.color ='red';
	            } else {
	              document.getElementById("idmessage1").style.display ='flex';
	              document.getElementById('idmessage1').innerText ='사용가능한 아이디입니다.'
	              document.getElementById("idmessage1").style.color ='green';
	            }
			})
	 }
	let pw1 = document.getElementById("memberPw");
	let pw2 = document.getElementById("memberPw2");
	
	function pwdChk(){
		if(pw1.value!=pw2.value){
			p2.nextSibling.innerText ='✔';
			p2.nextSibling.style.color ='green';
		}else{
			p2.nextSibling.innerText ='X';
			p2.nextSibling.style.color ='green';
		}
	}

	function isEmail(asValue) {
		var regExp = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
		regCheck(regExp,asValue);
	}
	
	function regCheck(regExp, asValue){
		   let checkIcon = asValue.nextSibling; 
		   if(regExp.test(asValue.value) ){
		      checkIcon.innerText='done';
		      checkIcon.style.color='green';
		   }else{
		      checkIcon.innerText='warning';
		      checkIcon.style.color='red';
		   }
		   checkIcon.style.visibility='visible';
		}

	function formCheck(){
		
	}
</script>
</body>
</html>