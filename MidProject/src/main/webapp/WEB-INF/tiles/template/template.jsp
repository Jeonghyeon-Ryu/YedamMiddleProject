<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>여기서 자바</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="css/header.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <link rel="stylesheet" type="text/css" href="css/nav.css">
    <link rel="stylesheet" type="text/css" href="css/modal.css">
    <link rel="stylesheet" type="text/css" href="css/wishList.css">
    <link rel="stylesheet" type="text/css" href="css/exTourList.css">
    <link rel="stylesheet" type="text/css" href="css/companyDetail.css">
    <link rel="stylesheet" type="text/css" href="css/reservationPage.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <link rel="stylesheet" type="text/css" href="css/locationModal.css">
    <link rel="stylesheet" type="text/css" href="css/headcountModal.css">
    <link rel="stylesheet" type="text/css" href="css/calender.css">
    <link rel="stylesheet" type="text/css" href="css/mypage.css">
    
</head>
<body>
	<div class="body-container">
		<!------------------------ Headder 영역 시작 ------------------------->
		<!------------------------ Main(include Header) 영역 시작 ------------------------->
		<tiles:insertAttribute name="body"></tiles:insertAttribute>
		<!------------------------ 하단 Nav 영역 시작 ------------------------->
		<tiles:insertAttribute name="nav"></tiles:insertAttribute>
	</div>

	<script src="js/header.js"></script>
	<script src="js/main.js"></script>
	<script src="js/nav.js"></script>
	<script src="js/modal.js"></script>
	<script src="js/locationModal.js"></script>
	<script src="js/compDetail.js"></script>
	<script src="js/calender.js"></script>
	<script src="js/headcountModal.js"></script>
	<script src="js/wishList.js"></script>
	<script src="js/mypage.js"></script>
	<script src="js/reservationModal.js"></script>
	<script src="https://kit.fontawesome.com/9f16a06d13.js" crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
		crossorigin="anonymous"></script>
</body>
</html>