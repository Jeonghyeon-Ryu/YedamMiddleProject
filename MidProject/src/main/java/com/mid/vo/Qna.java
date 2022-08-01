package com.mid.vo;

import java.sql.Date;

public class Qna {
	private int qnaId;
	private String memberId;
	private String title;
	private String content;
	private Date writeDate;
	private int categoryId;
	public int getQnaId() {
		return qnaId;
	}
	public void setQnaId(int qnaId) {
		this.qnaId = qnaId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	
	
}
