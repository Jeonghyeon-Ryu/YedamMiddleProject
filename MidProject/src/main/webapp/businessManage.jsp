<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/businessManage.css">
</head>
<body>
	<div class="businessManage-container">
		<div class="businessManage-box">
			<div class="business-icon">
				<img src="img/business-100.png" class="far fa-user" />
			</div>
			<div class="serparater">
				<p>사업자 번호 : <span></span></p>
				<p>업체 명 : <span></span></p>
				<p>업제 주소 : <span></span></p>
			</div>
			<c:foreach var="i" items="">
				<div class="form-group">
					<img class="businessManage-img" src="img/business-100.png">
					<div>
						<div>
							<input type="text" name="accName" class="form-control" readonly>
						</div>
						<div>
							<button class="full-btn">조회</button>
							<button class="full-btn">수정</button>
							<button class="full-btn">삭제</button>
						</div>
					</div>
				</div>
			</c:foreach>
		</div>
	</div>
</body>
</html>