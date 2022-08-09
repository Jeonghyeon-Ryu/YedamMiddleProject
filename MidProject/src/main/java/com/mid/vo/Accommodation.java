package com.mid.vo;

import java.sql.Date;

public class Accommodation {
	private int accId;
	private String name;
	private String address;
	private String zipcode;
	private String phone;
	private int status;
	private double pointX;
	private double pointY;
	private Date renewalTime;
	private String imgUrl;
	
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
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
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public double getPointX() {
		return pointX;
	}
	public void setPointX(double pointX) {
		this.pointX = pointX;
	}
	public double getPointY() {
		return pointY;
	}
	public void setPointY(double pointY) {
		this.pointY = pointY;
	}
	public Date getRenewalTime() {
		return renewalTime;
	}
	public void setRenewalTime(Date renewalTime) {
		this.renewalTime = renewalTime;
	}
	
	
}
