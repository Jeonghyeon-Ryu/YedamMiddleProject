package com.mid.vo;

import java.sql.Date;

public class Reservation {
	private int roomId;
	private String memberId;
	private Date reservationTime;
	private int reservationDay;
	private int headcount;
	private Date paymentDate;
	private int paymentCost;

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
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

	public int getHeadcount() {
		return headcount;
	}

	public void setHeadcount(int headcount) {
		this.headcount = headcount;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public int getPaymentCost() {
		return paymentCost;
	}

	public void setPaymentCose(int paymentCost) {
		this.paymentCost = paymentCost;
	}

}
