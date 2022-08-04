<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="memberJoinForm.do">
        <h3>약관 동의</h3>
        <input type="checkbox" id="checkAll" style="font-weight: bold;"><label for="checkAll">전체동의</label><br>
        <a href="#"><input type="checkbox" name="chk" required>이용약관 동의 <span>(필수)</span></a><br>
        <a href="#"><input type="checkbox" name="chk" required>만 14세 이상 확인 <span>(필수)</span></a><br>
        <a href="#"><input type="checkbox" name="chk" >개인정보 수집 및 이용 동의 <span>(선택)</span></a><br>
        <a href="#"><input type="checkbox" name="chk" >마케팅 알림 수신동의 (선택)</a><br>
        <a href="#"><input type="checkbox" name="chk" >위치기반 서비스 이용약관 동의 (선택)</a><br>
        <input type="submit" value="동의" >
    </form>
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