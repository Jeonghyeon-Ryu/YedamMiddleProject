package com.mid.vo;

import java.sql.Date;

public class CompDetail {
	private int accId;
	private String name;
	private String address;
	private String phone;
	private String memberId;
	private int reviewScore;
	private String reviewContent;
	private Date reviewDate;
	private int roomId;
	private String roomName;
	private int price;
	private int isReservation;
	private Date reservationTime;
	private String info;
	
	
	
	@Override
	public String toString() {
		return "CompDetail [accId=" + accId + ", name=" + name + ", address=" + address + ", phone=" + phone
				+ ", memberId=" + memberId + ", reviewScore=" + reviewScore + ", reviewContent=" + reviewContent
				+ ", reviewDate=" + reviewDate + ", roomId=" + roomId + ", roomName=" + roomName + ", price=" + price
				+ ", isReservation=" + isReservation + ", reservationTime=" + reservationTime + ", info=" + info + "]";
	}
	
	public int getAccId() {
		return accId;
	}
	public void setAccId(int accId) {
		this.accId = accId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getReviewScore() {
		return reviewScore;
	}
	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	public Date getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getIsReservation() {
		return isReservation;
	}
	public void setIsReservation(int isReservation) {
		this.isReservation = isReservation;
	}
	public Date getReservationTime() {
		return reservationTime;
	}
	public void setReservationTime(Date reservationTime) {
		this.reservationTime = reservationTime;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	
	
	
}
