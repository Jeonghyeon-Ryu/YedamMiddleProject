<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>findInfo.jsp</title>
<link href="${pageContext.request.contextPath}/css/memberAgreement.css" rel="stylesheet">

</head>
<body>
<div class="agreement-box">
   <div class="findInfo-title">
      <div class="modal-close-button" style="float:right"><a href="main.do">
         <img src="img/close-20.png"></a>
      </div>
      <h3>아이디/비밀번호 찾기</h3>
   </div>
   <div class="findInfo-content">
      <form class="findInfo-frm" id="SearchId-frm" name="frm" action="findInfo.do">
         <h3>아이디 찾기</h3>
         <input type="hidden" name="job" value="searchId">
         <div class="searchId">
            <label for="s-memberNm">이름</label>
            <input type="text" id="s-memberNm" name="s-memberNm" >
         </div>
         <div class="searchId">
            <div class="searchPw">
            <label for="s-phone1">연락처</label> 
            <input type="text" class="s-phone" id="s-phone1" name="s-phone1" maxlength="3" size=4> - 
            <input type="text" class="s-phone" id="s-phone2" name="s-phone2" maxlength="4" size=4> - 
            <input type="text" class="s-phone" id="s-phone3" name="s-phone3" maxlength="4" size=4>
         </div>
         </div>
         <p id="findId-error" style="display:none"></p>
         <input type="submit" value="아이디 찾기">
      </form>
      
      <div class="searchedInfo-box" id="searchedId-box">
         <c:if test="${!empty error}">
            <p style="color:red;">${error}</p>
         </c:if>      
         <c:if test="${!empty list}">
            <c:forEach var="vo" items="${list}">
               <p style="color:green;">${vo.name}님의 아이디는 ${vo.id} 입니다.</p>
            </c:forEach>
         </c:if>   
      </div>
      
      <form class="findInfo-frm" id="searchPw-frm" name="searchPw-frm" action="findInfo.do">
         <h3>비밀번호 찾기</h3>
         <input type="hidden" name="job" value="searchPw">
         <div class="searchPw">
            <label for="s2-memberNm">이름</label>
            <input type="text" id="s2-memberNm" name="s-memberNm" >
         </div>
         <div class="searchPw">
            <label for="s2-memberId">아이디</label>
            <input type="text" id="s2-memberId" name="s-memberId" >
         </div>
         <div class="searchPw">
            <label for="s2-phone1">연락처</label> 
            <input type="text" class="s2-phone" id="s2-phone1" name="s-phone1" maxlength="3" size=4> - 
            <input type="text" class="s2-phone" id="s2-phone2" name="s-phone2" maxlength="4" size=4> - 
            <input type="text" class="s2-phone" id="s2-phone3" name="s-phone3" maxlength="4" size=4>
         </div>
         <input type="submit" id="searchPw-btn" value="비밀번호 찾기">
      </form>
      
      <div class="searchedInfo-box" id="searchedPw-box">
         <c:if test="${msg eq 'fail'}">
            <p style="color:red;flat:left">일치하는 정보가 없습니다.</p>            
         </c:if>
         <c:if test="${msg eq 'success'}">
            <form id="newInfo-input" action="updateMemberInfo.do" method="post">
               <h3>'${id}'님의 비밀번호 재설정</h3>
               <label for="memberPw">새로운 비밀번호</label> 
               <input type="password" id="memberPw" name="memberPw"><br><br>
               <p style="display: none;" id="pw-error" class="info-error"></p>
               <label for="memberPw2">비밀번호 확인</label> <input type="password"
                  id="memberPw2" name="memberPw2">
               <p style="display: none;" id="pw2-error" class="info-error"></p>
               
               <input type="hidden" name="memberId" value="${id }">
               <input type="hidden" name="job" value="pwUpdate">
               <input type="button" id="updatePw-btn" onclick="upDatePwChk()" value="수정">
            </form>
         </c:if>
      </div>
      
   </div>
</div>
<script>
let pw1 = document.getElementById("memberPw");
let pw2 = document.getElementById("memberPw2");

function pwChk() {
   let regExp = /^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[$`~!@$!%*#^?&\\(\\)\-_=+]).{8,16}$/;
   document.getElementById("pw2-error").style.color = 'red';
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
function upDatePwChk(){
   pwChk();
   pw2Chk();
   if (pwChk() && pw2Chk()) {
      alert("비밀번호 수정이 완료되었습니다.")
      document.getElementById('newInfo-input').submit();
   }
}
</script>
</body>
</html>