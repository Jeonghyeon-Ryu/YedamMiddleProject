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
	<link rel="stylesheet" href="css/message.css">
</head>

<body onload="openReContent()">
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
						<div id ="exitRecevi">${recevi}</div>
						<div id="userId">${id }</div>
					</header>
					<hr>
					<nav>
						<div id="msCondition1" onclick="openAllMs()">메시지</div>
					</nav>
					<hr>
					<c:set var="userCheck" value="${checkUser }" />
					<c:set var="trueUser" value="1" />
					<div id="msContent1">
						<c:out value="${userCheck} " />
						<div id="msContentRoom">
							<c:choose>
								<c:when test="${checkUser eq trueUser }">
									<c:forEach var="i" items="${acclist }">
										<button class="msBtn" id="${i.accId }" onclick="openContent(this.id)">
											<img class="msImg" src="${i.imgUrl}">
											<p>${i.name}</p>
										</button>
									</c:forEach>
								</c:when>
								<c:when test="${checkUser ne trueUser }">
									<c:forEach var="m" items="${mlist }">
										<button class="msBtn" id="${m.id }" onclick="openContent(this.id)"></button>
									</c:forEach>
								</c:when>
							</c:choose>
						</div>
						<div id="msContentText">
							<form action="sendContent.do" id="msSendContent" name="msSendContent">
								모든 메시지
								<div></div>
								<c:set var="id" value="${id }" />
								<c:forEach var="i" items="${ctlist }">
									<c:set var="sender" value="${i.sender }" />
									<c:set var="recevier" value="${i.receiver }" />
									<c:choose>
										<c:when test="${sender eq id}">
											<c:if test="${i.nextDay eq '1' }">
												<div id="msThisDay">`-----------${i.currentDay }-----------`</div>
											</c:if>
											<c:choose>
												<c:when test="${i.checkEmoji eq '1'}">
													<div id ="msMyLine">
														<div id ="msMyTime">${i.currentTime}</div>
														<img id="msMyEmoji" name="${i.content}" src="${i.content}">
													</div>
													<br>
												</c:when>
												<c:when test="${i.checkEmoji eq '0'}">
													<div id ="msMyLine">
														<div id ="msMyTime">${i.currentTime}</div>
														<div class="${recevier}" id="${recevier}">${i.content }</div>
													</div>
												</c:when>
											</c:choose>
										</c:when>
										<c:when test="${recevier eq id}">
											<c:if test="${i.nextDay eq '1' }">
												<div>${i.currentDay }</div>
											</c:if>
											<c:choose>
												<c:when test="${i.checkEmoji eq '1'}">
													<div id ="msYouLine">
														<img id="msYouEmoji" name="${i.content}" src="${i.content}">
														<div id ="msYouTime">${i.currentTime}</div>
													</div>
													<br>
												</c:when>
												<c:when test="${i.checkEmoji eq '0'}">
													<div id ="msYouLine">
														<div class="${sender}" id="${sender}">${i.content }</div>
														<div id ="msYouTime">${i.currentTime}</div>
													</div>
												</c:when>
											</c:choose>
										</c:when>
									</c:choose>
								</c:forEach>
								<input id="msSend" name="msSend" value="${id }" type="hidden">
								<input id="msReceiv" name="msReceiv" type="hidden">
								<input id="msSendText" name="msSendText" type="text">
								<img id="msSendEmoji" onclick="openMsEmoji()" src="img/emoji_1.jpg">
								<div id="msEmojiAll">
									<c:forEach var="i" begin="1" end="28">
										<img id="img/emoji_${i}.gif" name="img/emoji_${i}.gif" src="img/emoji_${i}.gif"
											ondblclick="sendEomji(this.id)">
									</c:forEach>
								</div>
							</form>
						</div>

					</div>
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