<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="css/message.css">
<div id="msModal" role="dialog">
	<div class="modal-box">
		<!-- Modal Title -->
		<div class="modal-title">
			<div id="msCondition" onclick="openAllMs()" style="cursor: pointer">목록</div>
			<h5>메시지함</h5>
			<div class="modal-close-button">
				<a href="javascript:window.history.back();"> <img
					src="img/close-20.png">
				</a>
			</div>
		</div>
		<hr>
		<!-- Modal Content -->
		<div class="msModal-content">
			<div id="msHeader">
				<input id="exitRecevi" value="${recevi}" type="hidden">
				<div id="userId">발신 : ${id }</div>
				<div id="receviId"></div>
			</div>
			<hr>
			<div id="msContent">
				<div id="msContentRoom">
					<p id="msUserRoom">유저방</p>
					<hr>
					<c:forEach var="i" items="${acclist }">
						<button class="msBtn" id="${i.accId }" style="cursor: pointer"
							onclick="openContent(this.id)">
							<img class="msImg" src="${i.imgUrl}">
							<p id="${i.name }Name">${i.name}</p>
						</button>
					</c:forEach>
					<c:if test="${!empty businessId }">
					<hr>
						<p id="msBmRoom">사업가</p>
						<hr>
					</c:if>
					<c:forEach var="m" items="${mlist }">
						<button class="msBtn" id="${m.id }" style="cursor: pointer"
							onclick="openContent(this.id)">${m.id }</button>
					</c:forEach>
				</div>
				<div id="msContentText">
					<p id="${i.name }AccName"></p>

					<c:forEach var="i" items="${ctlist }">
						<c:set var="sender" value="${i.sender }" />
						<c:set var="recevier" value="${i.receiver }" />
						<c:choose>

							<c:when
								test="${fn:contains(sender,businessId)or fn:contains(sender,id)}">
								<c:if test="${i.nextDay eq '1' }">
									<div id="msThisDay" class="${recevier}">-----------${i.currentDay
												}-----------</div>
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
							<c:when
								test="${fn:contains(recevier,businessId)or fn:contains(recevier,id)}">
								<c:if test="${i.nextDay eq '1' }">
									<div id="msThisDay" class="${sender}">-----------${i.currentDay
												}-----------</div>
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
				</div>
			</div>
			<!-- Modal Footer(Optional) -->
		</div>

		<div class="modal-footer">
		
			<div id="msSendAll">
				<input id="msSend" name="msSend" value="${id }" type="hidden">
				<input id="msReceiv" name="msReceiv" type="hidden"> <input
					id="msSendText" name="msSendText" type="text"
					onkeyup="if(window.event.keyCode==13){sendText()}" value="">
				<img id="msSendEmoji" class=msEmoji onclick="openMsEmoji()"
					src="img/emoji_1.jpg" style="cursor: pointer">
			</div>
		</div>
		<div id="msEmojiAll">
					<c:forEach var="i" begin="1" end="27">
						<img id="img/emoji_${i}.gif" class=msEmoji
							name="img/emoji_${i}.gif" src="img/emoji_${i}.gif"
							ondblclick="sendEomji(this.id)" style="cursor: pointer">
					</c:forEach>
				</div>
	</div>
</div>

<script src="js/message.js">
	
</script>