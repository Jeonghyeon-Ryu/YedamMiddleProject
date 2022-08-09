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
<link href="${pageContext.request.contextPath}/css/modal.css"
	rel="stylesheet">
<link rel="stylesheet" href="css/message.css">
</head>

<body onload="openReContent()">
	<div id="modal" role="dialog">
		<div>
			<div class="modal-box">
				<!-- Modal Title -->
				<div class="modal-title">
					<div id="msCondition" onclick="openAllMs()" style="cursor: pointer">목록</div>
					<h5>메시지함</h5>
					<div class="modal-close-button">
						<img src="img/close-20.png">
					</div>
				</div>
				<hr>
				<!-- Modal Content -->
				<div class="modal-content">
					<div id="msContainer">
						<header>
							<div id="msHeader">
								<input id="exitRecevi" value="${recevi}" type="hidden">
								<div id="userId">발신 : ${id }</div>
								<div id="receviId"></div>
							</div>
						</header>
						<hr>
						<c:set var="userCheck" value="${checkUser }" />
						<c:set var="trueUser" value="1" />
						<div id="msContent">
							<div id="msContentRoom">
								<c:choose>
									<c:when test="${checkUser eq trueUser }">
										<c:forEach var="i" items="${acclist }">
											<button class="msBtn" id="${i.accId }"
												style="cursor: pointer" onclick="openContent(this.id)">
												<img class="msImg" src="${i.imgUrl}">
												<p id="${i.name }Name">${i.name}</p>
											</button>
										</c:forEach>
									</c:when>
									<c:when test="${checkUser ne trueUser }">
										<c:forEach var="m" items="${mlist }">
											<button class="msBtn" id="${m.id }" style="cursor: pointer"
												onclick="openContent(this.id)"></button>
										</c:forEach>
									</c:when>
								</c:choose>
							</div>
							<div id="msContentText">
								<form action="sendContent.do" id="msSendContent"
									name="msSendContent">
									<p id="${i.name }AccName"></p>
									<c:set var="id" value="${id }" />
									<c:forEach var="i" items="${ctlist }">
										<c:set var="sender" value="${i.sender }" />
										<c:set var="recevier" value="${i.receiver }" />
										<c:choose>
											<c:when test="${sender eq id}">
												<c:if test="${i.nextDay eq '1' }">
													<div id="msThisDay" class="${recevier}">-----------${i.currentDay }-----------</div>
												</c:if>
												<c:choose>
													<c:when test="${i.checkEmoji eq '1'}">
														<div id="msMyLine" class="${recevier}">
															<small id="msMyTime" class="msMyTime">${i.currentTime}</small>
															<img id="msMyImg" class="msMyImg" src="${i.content}">
														</div>
													</c:when>
													<c:when test="${i.checkEmoji eq '0'}">
														<div id="msMyLine" class="${recevier}">
															<small id="msMyTime" class="msMyTime">${i.currentTime}</small>
															<div id="msMyText" class="msMyText">${i.content }</div>
														</div>
													</c:when>
												</c:choose>
											</c:when>
											<c:when test="${recevier eq id}">
												<c:if test="${i.nextDay eq '1' }">
													<div id="msThisDay" class="${sender}">-----------${i.currentDay }-----------</div>
												</c:if>
												<c:choose>
													<c:when test="${i.checkEmoji eq '1'}">
														<div id="msYouLine" class="${sender}">
															<img id="msYouImg" class="msYouImg" src="${i.content}">
															<small id="msYouTime" class="msYouTime">${i.currentTime}</small>
														</div>
													</c:when>
													<c:when test="${i.checkEmoji eq '0'}">
														<div id="msYouLine" class="${sender}">
															<div id="msYouText" class="msYouText">${i.content }</div>
															<small id="msYouTime" class="msYouTime">${i.currentTime}</small>
														</div>
													</c:when>
												</c:choose>
											</c:when>
										</c:choose>
									</c:forEach>
									<div id="msSendAll">
										<input id="msSend" name="msSend" value="${id }" type="hidden">
										<input id="msReceiv" name="msReceiv" type="hidden"> <input
											id="msSendText" name="msSendText" type="text"> <img
											id="msSendEmoji" class=msEmoji onclick="openMsEmoji()"
											src="img/emoji_1.jpg" style="cursor: pointer">
									</div>
									<div id="msEmojiAll">
										<c:forEach var="i" begin="1" end="28">
											<img id="img/emoji_${i}.gif" class=msEmoji
												name="img/emoji_${i}.gif" src="img/emoji_${i}.gif"
												ondblclick="sendEomji(this.id)" style="cursor: pointer">
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
	</div>
	<script src="js/message.js">
		
	</script>
</body>

</html>