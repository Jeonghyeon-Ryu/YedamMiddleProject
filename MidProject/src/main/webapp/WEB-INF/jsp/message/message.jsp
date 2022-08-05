<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Document</title>
	<link rel="stylesheet" href="https://unpkg.com/aos@2.3.1/dist/aos.css">
	<script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
	<link rel="stylesheet" href="css/message.css">
</head>

<body>
	<div id="modal" role="dialog">
		<div class="modal-box">
			<!-- Modal Title -->
			<div class="modal-title">
				<h5>필터</h5>
				<div class="modal-close-button">
					<img src="img/close-20.png">
				</div>
			</div>
			<!-- Modal Content -->
			<div class="modal-content">
				<div id="msContainer">
					<header>
						<h1>메시지함</h1>
						<div id='test'>&{recevi }</div>
						<div id="userId">${id }</div>
					</header>
					<nav>
						<div id="msCondition1" onclick="openAllMs()">메시지</div>
						<div id="msCondition3" onclick="openNotReadMs()">읽지않음</div>
						<div id="msCondition4" onclick="openNoticeMs()">
							<div>알림</div>
							<div id="num">1</div>
						</div>
					</nav>
					<div id="msContent1">
						<div id="msContentRoom">
							<c:forEach var="i" items="${acclist }">
								${i.accId }
								<button class="msBtn" id="${i.accId }" onclick="openContent(this.id)">
									<img src="${i.imgUrl}">
									<p>${i.name}</p>
								</button>
							</c:forEach>
						</div>
						<form action="sendContent.do" name=msSendContent onsubmit ="msClear()">
							<div id="msContentText">
								모든 메시지
								<c:set var="id" value="${id }" />
								<c:forEach var="i" items="${ctlist }">
									<c:set var="sender" value="${i.sender }" />
									<c:set var="recevier" value="${i.receiver }" />
									<c:choose>
										<c:when test="${sender eq id}">
											<div class="${recevier}" id="msMy">${i.content }</div>
										</c:when>
										<c:when test="${recevier eq id}">
											<div class="${sender}" id="msYou">${i.content }</div>
										</c:when>
									</c:choose>
								</c:forEach>
								<input id="msSend" name="msSend" value="${id }" type="hidden">
								<input id="msReceiv" name="msReceiv" type="hidden">
								<input id="msSendText" name="msSendText" type="text" onkeypress="JavaScript:press(this.form)">
							</div>
						</form>
					</div>
					<div id="msContent2">저장된 메시지</div>
					<div id="msContent3">읽지않은 메시지</div>
					<div id="msContent4">알림</div>
				</div>
			</div>
			<!-- Modal Footer(Optional) -->
			<div class="modal-footer"></div>
		</div>
	</div>
	<script src="js/message.js">

	</script>
</body>

</html>