<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberAgreement.jsp</title>
<link href="${pageContext.request.contextPath}/css/modal.css" rel="stylesheet">
<style>
.modal-box{max-width :400px; margin:0 auto; }
.agree-frm input[type=checkbox]{margin:9px;}
.agree-frm .agreePage-btn{float:right;background:black;color:white;margin:15px 10px 0 0;border-radius:3px;}
.agree-frm .agreePage-btn:hover{background:lightgray;color:gray; border-color:gray }
</style>
</head>
<body>
 <div class="modal-box">
     <div class="modal-title">
         <h5>약관 동의</h5>
         <div class="modal-close-button">
         	<a href="main.do"><img src="img/close-20.png"></a>
         </div>
     </div>
     <div class="modal-content">
     <form class="agree-frm" action="memberJoinForm.do">
        	<input type="checkbox" id="checkAll" style="font-weight: bold;"><label for="checkAll">전체동의</label><br>
         	<a href="#" onclick="openA"><input type="checkbox" name="chk" required>이용약관 동의 <span>(필수)</span></a><br>
           	<a href="#"><input type="checkbox" name="chk" required>만 14세 이상 확인 <span>(필수)</span></a><br>
           	<a href="#"><input type="checkbox" name="chk" >개인정보 수집 및 이용 동의 <span>(선택)</span></a><br>
           	<a href="#"><input type="checkbox" name="chk" >마케팅 알림 수신동의 (선택)</a><br>
           	<a href="#"><input type="checkbox" name="chk" >위치기반 서비스 이용약관 동의 (선택)</a><br>
        <input type="submit" class="agreePage-btn" value="다음" >
        <a href="loginForm.do"><input type="button" class="agreePage-btn" value="이전" ></a>
       </form>
   </div>
</div>
</body>
<script>
    let chkAll = document.querySelector("#checkAll");
    chkAll.addEventListener("change", ()=>{
        const chkList = document.getElementsByName("chk");
        for(chk of chkList){
            chk.checked = chkAll.checked;
        }
    })
    
</script>
</html>