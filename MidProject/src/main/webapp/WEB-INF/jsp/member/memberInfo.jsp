<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>findInfo.jsp</title>
<style>
.update-info {
   margin : 20px;
}
.update-info{}
.update-info div {
   height:100%;
   margin: 40px 20px;
}
.update-info .update-title{
   margin-left:30px;}
.update-info .update-info{
   padding:40px 20px;
}
.update-info input, button{
   margin:20px 5px; 
   padding :10px; 
   border : 1px solid lightgray;
   border-radius:5px; 
}
.update-info input:hover, button:hover{
   margin:20px 5px; 
   padding :10px; 
   border : 1px solid lightgray;
   border-radius:5px; 
   background:black;
   color:white;
}
.update-info label{
   margin:20px; 
   padding :10px; 
}

.update-info hr{
   color: lightgray;
   width:100%;
   margin : 10px 0;
   border: 0.1px solid lightgray;
}
.update-info-frm p{margin-left:20px;}
</style>
</head>
<body>
<div class="update-info" id="info">
   <div id="update-title">
         <h2 style="float:left">개인 정보</h2>
    </div>
    <div class="update-content" style="clear:both">

        <form id="update-info-frm" action="updateMemberInfo.do">
             <label for="memberId" style="float:left">아이디</label> 
                 <input type="text" name="memberId" value="${member.id}" readonly>
              <hr>
              <label for="info-nm"style="float:left">이름</label>
                 <input type="text" name="info-nm" value="${member.name}">
              <hr>
              <label for="info-phone1"style="float:left">전화번호</label>
                   <input type="text" name="info-phone1" value="${phone1}" maxlength="3" size=4> - 
               <input type="text" name="info-phone2" value="${phone2}" maxlength="4" size=4> - 
               <input type="text" name="info-phone3" value="${phone3}" maxlength="4" size=4>
              <hr>
              <label for="info-pre-pw" style="float:left">현재 비밀번호</label>
                 <input type="password" id="info-pre-pw" name="info-pre-pw">
                 <input type="hidden" id="info-presentPw" value="${member.pw}">
              <hr >
              <label for="info-new-pw" style="float:left">새 비밀번호</label>
                 <input type="password" onchange="InfopwChk()" id="info-new-pw" name="info-new-pw">
              <p style="color:red" id="info-pw-error" class="info-error" style="cleat:both"></p>
              <hr>
            <c:if test="${!empty infoMsg }">
               <p style="color:red" style="cleat:both">${infoMsg}</p>
            </c:if>
             <p style="color:red" id="no-pw-error" class="info-error" style="cleat:both"></p>
             <input type="hidden" name="job" value="infoUpdate">
              <button onclick="updatePwChk()" style="float:left" name="role" value="memberPw">수정</button>
        </form>
         <button onclick="location.href='deleteMemberInfo.do'" style="float:right;color:lightgray">회원탈퇴</button>
     </div>
</div>

<script>
let infoPw=document.getElementById("info-new-pw");
function InfopwChk() {
   let regExp = /^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[$`~!@$!%*#^?&\\(\\)\-_=+]).{8,16}$/;
   if (infoPw.value.length < 8 || infoPw.value.length > 16) {
      document.getElementById('info-pw-error').innerText = "8자리 ~ 16자리 이내로 입력해주세요.";
      infoPw.value = "";
      return false;
   } else if (!regExp.test(infoPw.value)) {
      document.getElementById('info-pw-error').innerText = "영문,숫자,특수문자를 포함하여 입력하세요.";
      infoPw.value = "";
      return false;
   } else {
      document.getElementById("info-pw-error").innerText="";
      return true;
   }
}

function updatePwChk(){
   if(!(infoPw.value.equals("")||infoPw.value==null)){
      InfopwChk;
      if(InfopwChk()){
         document.getElementById('update-info-frm').submit();
         InfopwChk;
      }else{
         event.preventDefault();
      }
   }else{
      document.getElementById('update-info-frm').submit();
   }
}

</script>
 </body>
 </html>
 