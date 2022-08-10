<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberAgreement.jsp</title>
<link href="${pageContext.request.contextPath}/css/memberAgreement.css" rel="stylesheet">
</head>
<body>
 <div class="agreement-box">
     <div class="agreement-title">
         <h3>약관 동의</h3>
     </div>
     <div class="agreement-content">
         <hr>
     <form class="agree-frm" action="memberJoinForm.do">
        <input type="checkbox" id="checkAll"><label for="checkAll">전체동의</label><br>
      <div class="agree-content">
            <input type="checkbox" class="chk" id='chk-1' required>이용약관 동의 <span>(필수)</span><span class="a-question" id="que-1"> 자세히</span><br>
             <div class="agreement" id="agree-1">
                <p class="ls2 lh6 bs5 ts4"><em class="emphasis">
            &lt; 여기서자바 &gt;('http://localhost:8081/MidProject/'이하 '여기서자바')</em>은(는) 
            개인정보 보호법」 제30조에 따라 정보주체의 개인정보를 보호하고 이와 관련한 고충을 신속하고 원활하게 처리할 수 있도록 하기 위하여
            다음과 같이 개인정보 처리방침을 수립·공개합니다.</p>
            <p class="ls2"><br></p>
            <p class="sub_p mgt30"><strong>제1조(개인정보의 처리목적)<br><br>
            &lt; 여기서자바 &gt;(이)가 개인정보 보호법 제32조에 따라 등록․공개하는 개인정보파일의 처리목적은 다음과 같습니다.</strong></p>
            <ul class="list_indent2 mgt10">
            <li class="tt"><b>1. 개인정보 파일명 : 여기서자바 이용양관</b></li>
            <li>개인정보의  처리목적 : 서비스 이용 실적 정보를 활용한 통계 분석 및 서비스 개선</li>
            <li>수집방법 : 홈페이지, 경품행사</li>
            <li>보유기간 : 1년</li><li>관련법령 : 신용정보의 수집/처리 및 이용 등에 관한 기록 : 3년</li></ul>
             <br><br><p class="lh6 bs4"><strong>
            1. 개인정보분쟁조정위원회 : (국번없이) 1833-6972 (www.kopico.go.kr)<br>
            2. 개인정보침해신고센터 : (국번없이) 118 (privacy.kisa.or.kr)<br>
            3. 대검찰청 : (국번없이) 1301 (www.spo.go.kr)<br>
            개인정보보호법」제35조(개인정보의 열람), 제36조(개인정보의 정정·삭제), 제37조(개인정보의 처리정지 등)의 규정에 의한 요구에 대 하여 공공기관의 장이 행한 처분 또는 부작위로 인하여 권리 또는 이익의 침해를 받은 자는 행정심판법이 정하는 바에 따라 행정심판을 청구할 수 있습니다.<br><br>
            ※ 행정심판에 대해 자세한 사항은 중앙행정심판위원회(www.simpan.go.kr) 홈페이지를 참고하시기 바랍니다.<br><br>
            <p class="lh6 bs4"><strong>제13조(영상정보처리기기 운영·관리에 관한 사항)<br>①  
            <em class="emphasis">&lt; 여기서자바 &gt;</em>은(는) 아래와 같이 영상정보처리기기를 설치·운영하고 있습니다.</strong></p>
            <p class="sub_p mgt30">1.영상정보처리기기 설치근거·목적 : <span class="colorLightBlue">&lt; 여기서자바 &gt;</span>의 </p>
            <ul class="list_indent2 mgt10">
               <li class="tt">2.설치 대수, 설치 위치, 촬영 범위 :</li>
               <li>설치대수 :  대</li><li>설치위치 : </li><li>촬영범위 : </li>
            </ul>
            <p class="sub_p mgt10">3.관리책임자, 담당부서 및 영상정보에 대한 접근권한자 : </p>
            <ul class="list_indent2 mgt10">
               <li class="tt">4.영상정보 촬영시간, 보관기간, 보관장소, 처리방법 </li>
               <li>촬영시간 :  시간</li><li>보관기간 : 촬영시부터 </li>
               <li>보관장소 및 처리방법 : </li>
            </ul>
            <p class="sub_p mgt10">5.영상정보 확인 방법 및 장소 : </p>
            <p class="sub_p mgt10">6.정보주체의 영상정보 열람 등 요구에 대한 조치 : 개인영상정보 열람.존재확인 청구서로 신청하여야 하며, 정보주체 자신이 촬영된 경우 또는 명백히 정보주체의 생명.신체.재산 이익을 위해 필요한 경우에 한해 열람을 허용함</p>
            <p class="sub_p mgt10">7.영상정보 보호를 위한 기술적.관리적.물리적 조치 : </p><br><br>
            <p class="lh6 bs4"><strong>제14조(개인정보 처리방침 변경)   <em class="emphasis"></em></strong></p><br>
            <p class="sub_p">① 이 개인정보처리방침은 2022년 8월 1부터 적용됩니다.</p>
            </strong>
         </div>
      </div>
      <div class="agree-content">
            <input type="checkbox" class="chk" id='chk-2' required>만 14세 이상 확인<span>(필수)</span><span class="a-question" id="que-2"> 자세히</span><br>
             <div class="agreement" id="agree-2">
              <p class="ls2 lh6 bs5 ts4"><em class="emphasis">
            &lt; 여기서자바 &gt;('http://localhost:8081/MidProject/'이하 '여기서자바')</em>은(는) 
            개인정보 보호법」 제30조에 따라 정보주체의 개인정보를 보호하고 이와 관련한 고충을 신속하고 원활하게 처리할 수 있도록 하기 위하여
            다음과 같이 개인정보 처리방침을 수립·공개합니다.</p>
            <p class="ls2"><br></p>
            <p class="sub_p mgt30"><strong>제1조(개인정보의 처리목적)<br><br>
            &lt; 여기서자바 &gt;(이)가 개인정보 보호법 제32조에 따라 등록․공개하는 개인정보파일의 처리목적은 다음과 같습니다.</strong></p>
            <ul class="list_indent2 mgt10">
            <li class="tt"><b>1. 개인정보 파일명 : 여기서자바 이용양관</b></li>
            <li>개인정보의  처리목적 : 서비스 이용 실적 정보를 활용한 통계 분석 및 서비스 개선</li>
            <li>수집방법 : 홈페이지, 경품행사</li>
            <li>보유기간 : 1년</li><li>관련법령 : 신용정보의 수집/처리 및 이용 등에 관한 기록 : 3년</li></ul>
             <br><br><p class="lh6 bs4"><strong>
            1. 개인정보분쟁조정위원회 : (국번없이) 1833-6972 (www.kopico.go.kr)<br>
            2. 개인정보침해신고센터 : (국번없이) 118 (privacy.kisa.or.kr)<br>
            3. 대검찰청 : (국번없이) 1301 (www.spo.go.kr)<br>
            개인정보보호법」제35조(개인정보의 열람), 제36조(개인정보의 정정·삭제), 제37조(개인정보의 처리정지 등)의 규정에 의한 요구에 대 하여 공공기관의 장이 행한 처분 또는 부작위로 인하여 권리 또는 이익의 침해를 받은 자는 행정심판법이 정하는 바에 따라 행정심판을 청구할 수 있습니다.<br><br>
            ※ 행정심판에 대해 자세한 사항은 중앙행정심판위원회(www.simpan.go.kr) 홈페이지를 참고하시기 바랍니다.<br><br>
            <p class="lh6 bs4"><strong>제13조(영상정보처리기기 운영·관리에 관한 사항)<br>①  
            <em class="emphasis">&lt; 여기서자바 &gt;</em>은(는) 아래와 같이 영상정보처리기기를 설치·운영하고 있습니다.</strong></p>
            <p class="sub_p mgt30">1.영상정보처리기기 설치근거·목적 : <span class="colorLightBlue">&lt; 여기서자바 &gt;</span>의 </p>
            <ul class="list_indent2 mgt10">
               <li class="tt">2.설치 대수, 설치 위치, 촬영 범위 :</li>
               <li>설치대수 :  대</li><li>설치위치 : </li><li>촬영범위 : </li>
            </ul>
            <p class="sub_p mgt10">3.관리책임자, 담당부서 및 영상정보에 대한 접근권한자 : </p>
            <ul class="list_indent2 mgt10">
               <li class="tt">4.영상정보 촬영시간, 보관기간, 보관장소, 처리방법 </li>
               <li>촬영시간 :  시간</li><li>보관기간 : 촬영시부터 </li>
               <li>보관장소 및 처리방법 : </li>
            </ul>
            <p class="sub_p mgt10">5.영상정보 확인 방법 및 장소 : </p>
            <p class="sub_p mgt10">6.정보주체의 영상정보 열람 등 요구에 대한 조치 : 개인영상정보 열람.존재확인 청구서로 신청하여야 하며, 정보주체 자신이 촬영된 경우 또는 명백히 정보주체의 생명.신체.재산 이익을 위해 필요한 경우에 한해 열람을 허용함</p>
            <p class="sub_p mgt10">7.영상정보 보호를 위한 기술적.관리적.물리적 조치 : </p><br><br>
            <p class="lh6 bs4"><strong>제14조(개인정보 처리방침 변경)   <em class="emphasis"></em></strong></p><br>
            <p class="sub_p">① 이 개인정보처리방침은 2022년 8월 1부터 적용됩니다.</p>
            </strong>
           </div>
        </div>
        <div class="agree-content">
            <input type="checkbox" class="chk" id='chk-3'>개인정보 수집 및 이용 동의<span>(선택)</span><span class="a-question" id="que-3"> 자세히</span><br>
           <div class="agreement" id="agree-3">
              <p class="ls2 lh6 bs5 ts4"><em class="emphasis">
            &lt; 여기서자바 &gt;('http://localhost:8081/MidProject/'이하 '여기서자바')</em>은(는) 
            개인정보 보호법」 제30조에 따라 정보주체의 개인정보를 보호하고 이와 관련한 고충을 신속하고 원활하게 처리할 수 있도록 하기 위하여
            다음과 같이 개인정보 처리방침을 수립·공개합니다.</p>
            <p class="ls2"><br></p>
            <p class="sub_p mgt30"><strong>제1조(개인정보의 처리목적)<br><br>
            &lt; 여기서자바 &gt;(이)가 개인정보 보호법 제32조에 따라 등록․공개하는 개인정보파일의 처리목적은 다음과 같습니다.</strong></p>
            <ul class="list_indent2 mgt10">
            <li class="tt"><b>1. 개인정보 파일명 : 여기서자바 이용양관</b></li>
            <li>개인정보의  처리목적 : 서비스 이용 실적 정보를 활용한 통계 분석 및 서비스 개선</li>
            <li>수집방법 : 홈페이지, 경품행사</li>
            <li>보유기간 : 1년</li><li>관련법령 : 신용정보의 수집/처리 및 이용 등에 관한 기록 : 3년</li></ul>
             <br><br><p class="lh6 bs4"><strong>
            1. 개인정보분쟁조정위원회 : (국번없이) 1833-6972 (www.kopico.go.kr)<br>
            2. 개인정보침해신고센터 : (국번없이) 118 (privacy.kisa.or.kr)<br>
            3. 대검찰청 : (국번없이) 1301 (www.spo.go.kr)<br>
            개인정보보호법」제35조(개인정보의 열람), 제36조(개인정보의 정정·삭제), 제37조(개인정보의 처리정지 등)의 규정에 의한 요구에 대 하여 공공기관의 장이 행한 처분 또는 부작위로 인하여 권리 또는 이익의 침해를 받은 자는 행정심판법이 정하는 바에 따라 행정심판을 청구할 수 있습니다.<br><br>
            ※ 행정심판에 대해 자세한 사항은 중앙행정심판위원회(www.simpan.go.kr) 홈페이지를 참고하시기 바랍니다.<br><br>
            <p class="lh6 bs4"><strong>제13조(영상정보처리기기 운영·관리에 관한 사항)<br>①  
            <em class="emphasis">&lt; 여기서자바 &gt;</em>은(는) 아래와 같이 영상정보처리기기를 설치·운영하고 있습니다.</strong></p>
            <p class="sub_p mgt30">1.영상정보처리기기 설치근거·목적 : <span class="colorLightBlue">&lt; 여기서자바 &gt;</span>의 </p>
            <ul class="list_indent2 mgt10">
               <li class="tt">2.설치 대수, 설치 위치, 촬영 범위 :</li>
               <li>설치대수 :  대</li><li>설치위치 : </li><li>촬영범위 : </li>
            </ul>
            <p class="sub_p mgt10">3.관리책임자, 담당부서 및 영상정보에 대한 접근권한자 : </p>
            <ul class="list_indent2 mgt10">
               <li class="tt">4.영상정보 촬영시간, 보관기간, 보관장소, 처리방법 </li>
               <li>촬영시간 :  시간</li><li>보관기간 : 촬영시부터 </li>
               <li>보관장소 및 처리방법 : </li>
            </ul>
            <p class="sub_p mgt10">5.영상정보 확인 방법 및 장소 : </p>
            <p class="sub_p mgt10">6.정보주체의 영상정보 열람 등 요구에 대한 조치 : 개인영상정보 열람.존재확인 청구서로 신청하여야 하며, 정보주체 자신이 촬영된 경우 또는 명백히 정보주체의 생명.신체.재산 이익을 위해 필요한 경우에 한해 열람을 허용함</p>
            <p class="sub_p mgt10">7.영상정보 보호를 위한 기술적.관리적.물리적 조치 : </p><br><br>
            <p class="lh6 bs4"><strong>제14조(개인정보 처리방침 변경)   <em class="emphasis"></em></strong></p><br>
            <p class="sub_p">① 이 개인정보처리방침은 2022년 8월 1부터 적용됩니다.</p>
            </strong>
           </div>
        </div>
        <div class="agree-content">
            <input type="checkbox" class="chk" id='chk-4'>마케팅 알림 수신동의<span>(선택)</span><span class="a-question" id="que-4"> 자세히</span><br>
           <div class="agreement" id="agree-4">
              <p class="ls2 lh6 bs5 ts4"><em class="emphasis">
            &lt; 여기서자바 &gt;('http://localhost:8081/MidProject/'이하 '여기서자바')</em>은(는) 
            개인정보 보호법」 제30조에 따라 정보주체의 개인정보를 보호하고 이와 관련한 고충을 신속하고 원활하게 처리할 수 있도록 하기 위하여
            다음과 같이 개인정보 처리방침을 수립·공개합니다.</p>
            <p class="ls2"><br></p>
            <p class="sub_p mgt30"><strong>제1조(개인정보의 처리목적)<br><br>
            &lt; 여기서자바 &gt;(이)가 개인정보 보호법 제32조에 따라 등록․공개하는 개인정보파일의 처리목적은 다음과 같습니다.</strong></p>
            <ul class="list_indent2 mgt10">
            <li class="tt"><b>1. 개인정보 파일명 : 여기서자바 이용양관</b></li>
            <li>개인정보의  처리목적 : 서비스 이용 실적 정보를 활용한 통계 분석 및 서비스 개선</li>
            <li>수집방법 : 홈페이지, 경품행사</li>
            <li>보유기간 : 1년</li><li>관련법령 : 신용정보의 수집/처리 및 이용 등에 관한 기록 : 3년</li></ul>
             <br><br><p class="lh6 bs4"><strong>
            1. 개인정보분쟁조정위원회 : (국번없이) 1833-6972 (www.kopico.go.kr)<br>
            2. 개인정보침해신고센터 : (국번없이) 118 (privacy.kisa.or.kr)<br>
            3. 대검찰청 : (국번없이) 1301 (www.spo.go.kr)<br>
            개인정보보호법」제35조(개인정보의 열람), 제36조(개인정보의 정정·삭제), 제37조(개인정보의 처리정지 등)의 규정에 의한 요구에 대 하여 공공기관의 장이 행한 처분 또는 부작위로 인하여 권리 또는 이익의 침해를 받은 자는 행정심판법이 정하는 바에 따라 행정심판을 청구할 수 있습니다.<br><br>
            ※ 행정심판에 대해 자세한 사항은 중앙행정심판위원회(www.simpan.go.kr) 홈페이지를 참고하시기 바랍니다.<br><br>
            <p class="lh6 bs4"><strong>제13조(영상정보처리기기 운영·관리에 관한 사항)<br>①  
            <em class="emphasis">&lt; 여기서자바 &gt;</em>은(는) 아래와 같이 영상정보처리기기를 설치·운영하고 있습니다.</strong></p>
            <p class="sub_p mgt30">1.영상정보처리기기 설치근거·목적 : <span class="colorLightBlue">&lt; 여기서자바 &gt;</span>의 </p>
            <ul class="list_indent2 mgt10">
               <li class="tt">2.설치 대수, 설치 위치, 촬영 범위 :</li>
               <li>설치대수 :  대</li><li>설치위치 : </li><li>촬영범위 : </li>
            </ul>
            <p class="sub_p mgt10">3.관리책임자, 담당부서 및 영상정보에 대한 접근권한자 : </p>
            <ul class="list_indent2 mgt10">
               <li class="tt">4.영상정보 촬영시간, 보관기간, 보관장소, 처리방법 </li>
               <li>촬영시간 :  시간</li><li>보관기간 : 촬영시부터 </li>
               <li>보관장소 및 처리방법 : </li>
            </ul>
            <p class="sub_p mgt10">5.영상정보 확인 방법 및 장소 : </p>
            <p class="sub_p mgt10">6.정보주체의 영상정보 열람 등 요구에 대한 조치 : 개인영상정보 열람.존재확인 청구서로 신청하여야 하며, 정보주체 자신이 촬영된 경우 또는 명백히 정보주체의 생명.신체.재산 이익을 위해 필요한 경우에 한해 열람을 허용함</p>
            <p class="sub_p mgt10">7.영상정보 보호를 위한 기술적.관리적.물리적 조치 : </p><br><br>
            <p class="lh6 bs4"><strong>제14조(개인정보 처리방침 변경)   <em class="emphasis"></em></strong></p><br>
            <p class="sub_p">① 이 개인정보처리방침은 2022년 8월 1부터 적용됩니다.</p>
            </strong>
           </div>
        </div>
        <div class="agree-content">
            <input type="checkbox" class="chk" id='chk-5'>위치기반 서비스 이용약관 동의 <span>(선택)</span><span class="a-question" id="que-5"> 자세히</span><br>
           <div class="agreement" id="agree-5">
              <p class="ls2 lh6 bs5 ts4"><em class="emphasis">
            &lt; 여기서자바 &gt;('http://localhost:8081/MidProject/'이하 '여기서자바')</em>은(는) 
            개인정보 보호법」 제30조에 따라 정보주체의 개인정보를 보호하고 이와 관련한 고충을 신속하고 원활하게 처리할 수 있도록 하기 위하여
            다음과 같이 개인정보 처리방침을 수립·공개합니다.</p>
            <p class="ls2"><br></p>
            <p class="sub_p mgt30"><strong>제1조(개인정보의 처리목적)<br><br>
            &lt; 여기서자바 &gt;(이)가 개인정보 보호법 제32조에 따라 등록․공개하는 개인정보파일의 처리목적은 다음과 같습니다.</strong></p>
            <ul class="list_indent2 mgt10">
            <li class="tt"><b>1. 개인정보 파일명 : 여기서자바 이용양관</b></li>
            <li>개인정보의  처리목적 : 서비스 이용 실적 정보를 활용한 통계 분석 및 서비스 개선</li>
            <li>수집방법 : 홈페이지, 경품행사</li>
            <li>보유기간 : 1년</li><li>관련법령 : 신용정보의 수집/처리 및 이용 등에 관한 기록 : 3년</li></ul>
             <br><br><p class="lh6 bs4"><strong>
            1. 개인정보분쟁조정위원회 : (국번없이) 1833-6972 (www.kopico.go.kr)<br>
            2. 개인정보침해신고센터 : (국번없이) 118 (privacy.kisa.or.kr)<br>
            3. 대검찰청 : (국번없이) 1301 (www.spo.go.kr)<br>
            개인정보보호법」제35조(개인정보의 열람), 제36조(개인정보의 정정·삭제), 제37조(개인정보의 처리정지 등)의 규정에 의한 요구에 대 하여 공공기관의 장이 행한 처분 또는 부작위로 인하여 권리 또는 이익의 침해를 받은 자는 행정심판법이 정하는 바에 따라 행정심판을 청구할 수 있습니다.<br><br>
            ※ 행정심판에 대해 자세한 사항은 중앙행정심판위원회(www.simpan.go.kr) 홈페이지를 참고하시기 바랍니다.<br><br>
            <p class="lh6 bs4"><strong>제13조(영상정보처리기기 운영·관리에 관한 사항)<br>①  
            <em class="emphasis">&lt; 여기서자바 &gt;</em>은(는) 아래와 같이 영상정보처리기기를 설치·운영하고 있습니다.</strong></p>
            <p class="sub_p mgt30">1.영상정보처리기기 설치근거·목적 : <span class="colorLightBlue">&lt; 여기서자바 &gt;</span>의 </p>
            <ul class="list_indent2 mgt10">
               <li class="tt">2.설치 대수, 설치 위치, 촬영 범위 :</li>
               <li>설치대수 :  대</li><li>설치위치 : </li><li>촬영범위 : </li>
            </ul>
            <p class="sub_p mgt10">3.관리책임자, 담당부서 및 영상정보에 대한 접근권한자 : </p>
            <ul class="list_indent2 mgt10">
               <li class="tt">4.영상정보 촬영시간, 보관기간, 보관장소, 처리방법 </li>
               <li>촬영시간 :  시간</li><li>보관기간 : 촬영시부터 </li>
               <li>보관장소 및 처리방법 : </li>
            </ul>
            <p class="sub_p mgt10">5.영상정보 확인 방법 및 장소 : </p>
            <p class="sub_p mgt10">6.정보주체의 영상정보 열람 등 요구에 대한 조치 : 개인영상정보 열람.존재확인 청구서로 신청하여야 하며, 정보주체 자신이 촬영된 경우 또는 명백히 정보주체의 생명.신체.재산 이익을 위해 필요한 경우에 한해 열람을 허용함</p>
            <p class="sub_p mgt10">7.영상정보 보호를 위한 기술적.관리적.물리적 조치 : </p><br><br>
            <p class="lh6 bs4"><strong>제14조(개인정보 처리방침 변경)   <em class="emphasis"></em></strong></p><br>
            <p class="sub_p">① 이 개인정보처리방침은 2022년 8월 1부터 적용됩니다.</p>
            </strong>
           </div>
        </div>
        <div class="agree-content">
           <input type="submit" class="agreePage-btn" value="다음" >
          </div>
          <div class="agree-content">    
              <input type="button" class="agreePage-btn" value="이전" onclick="location.href='loginForm.do'">
          </div>
       </form>
   </div>
</div>
</body>
<script>
    const chkAll = document.querySelector("#checkAll");
    chkAll.addEventListener("change", ()=>{
        const chkList = document.querySelectorAll(".chk");
        for(chk of chkList){
            chk.checked = chkAll.checked;
        }
    })
     
    const agreeItems = document.querySelectorAll('.a-question');
     function openCloseAnswer() {
       const answerId = this.id.replace('que', 'agree');
   
       if(document.getElementById(answerId).style.display === 'block') {
         document.getElementById(answerId).style.display = 'none';
       } else {
         document.getElementById(answerId).style.display = 'block';
       }
     }
     agreeItems.forEach(agreeItems => agreeItems.addEventListener('click', openCloseAnswer));
    
</script>
</html>