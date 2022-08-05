<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav>
    <div class="nav-container">
        <a href="main.do">
            <div><img src="img/nav-home-25.png"></div>
            <div>홈으로</div>
        </a>
        <a id="nav-wishlist">
            <div><img src="img/nav-heart-25.png"></div>
            <div>위시리스트</div>
        </a>
        <c:if test="${empty id }">
        <a href="loginForm.do">
            <div><img src="img/nav-enter-25.png"></div>
            <div>로그인</div>
        </a>
        </c:if>
        <c:if test="${!empty id }">
        <a id="nav-reservation">
            <div><img src="img/hotel.png" width="25px"></div>
            <div>여행</div>
        </a>
        <a href="message.do">
            <div><img src="img/nav-message-25.png"></div>
            <div>메세지</div>
        </a>
        <a id="nav-mypage">
            <div><img src="img/nav-profile-25.png"></div>
            <div>프로필</div>
        </a>
        </c:if>
    </div>
</nav>