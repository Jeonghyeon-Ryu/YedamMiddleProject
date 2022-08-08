package com.mid.vo;

import java.util.Date;

public class Chat {
	private String sender; // 발신
	private String receiver; // 수신
	private String content; // 내용
	private int chatSeq; // 입력순저장용
	private int checkEmoji; // =0 text =1 emoji
	private String currentTime;
	private String currentDay;
	private int nextDay = 1;

	public int getNextDay() {
		return nextDay;
	}

	public void setNextDay(int nextDay) {
		this.nextDay = nextDay;
	}

	public String getCurrentDay() {
		return currentDay;
	}

	public void setCurrentDay(String currentDay) {
		this.currentDay = currentDay;
	}

	public String getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(String currentTime) {
		this.currentTime = currentTime;
	}

	public int getChatSeq() {
		return chatSeq;
	}

	public void setChatSeq(int chatSeq) {
		this.chatSeq = chatSeq;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public int getCheckEmoji() {
		return checkEmoji;
	}

	public void setCheckEmoji(int checkEmoji) {
		this.checkEmoji = checkEmoji;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
