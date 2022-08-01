<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ReserGram</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="css/header.css">
    <link rel="stylesheet" type="text/css" href="css/index.css">
    <link rel="stylesheet" type="text/css" href="css/star.css">
    <link rel="stylesheet" type="text/css" href="css/nav.css">
    <link rel="stylesheet" type="text/css" href="css/modal.css">
</head>
<body>
    <div class="container">
    	<!------------------------ Headder 영역 시작 ------------------------->
        <tiles:insertAttribute name="head"></tiles:insertAttribute>
        <!------------------------ Main 영역 시작 ------------------------->
        <tiles:insertAttribute name="body"></tiles:insertAttribute>
        <!-- 필터 모달창 시작 -->

        <div id="modal" class="modal-overlay" role="dialog">
            <div class="modal-box">
                <!-- Modal Title -->
                <div class="modal-title">
                    <h5>로그인</h5>
                    <div class="modal-close-button">
                        <img src="img/close-20.png">
                    </div>
                </div>
                <!-- Modal Content -->
                <div class="modal-content">

                </div>
                <!-- Modal Footer(Optional) -->
                <div class="modal-footer">
                    <button type="reset">전체 해제</button>
                    <button type="button"><span>555</span> 건 조회</button>
                </div>
            </div>
        </div>
        <!-- 하단 네비 시작 -->
        <tiles:insertAttribute name="nav"></tiles:insertAttribute>
    </div>
<script src="js/modal.js"></script>
<script src="js/header.js"></script>
    <!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>