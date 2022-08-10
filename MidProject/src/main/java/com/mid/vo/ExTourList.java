package com.mid.vo;

import java.sql.Date;

public class ExTourList {
	private String name;
	private String roomName;
	private Date reservationTime;
	private int reservationDay;
	private Date paymentDate;
	private String memberName;
	private String phone;
	private int paymentCost;
	private String imgUrl;

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getPaymentCost() {
		return paymentCost;
	}

	public void setPaymentCost(int paymentCost) {
		this.paymentCost = paymentCost;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public Date getReservationTime() {
		return reservationTime;
	}

	public void setReservationTime(Date reservationTime) {
		this.reservationTime = reservationTime;
	}

	public int getReservationDay() {
		return reservationDay;
	}

	public void setReservationDay(int reservationDay) {
		this.reservationDay = reservationDay;
	}

	@Override
	public String toString() {
		return "ExTourList [name=" + name + ", roomName=" + roomName + ", reservationTime=" + reservationTime
				+ ", reservationDay=" + reservationDay + ", getName()=" + getName() + ", getRoomName()=" + getRoomName()
				+ ", getReservationTime()=" + getReservationTime() + ", getReservationDay()=" + getReservationDay()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
