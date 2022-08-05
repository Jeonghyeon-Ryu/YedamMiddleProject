package com.mid.vo;

import java.util.ArrayList;
import java.util.List;

public class PageCard {
	int endPageNo;
	List<Accommodation> list;
	
	public PageCard(){
		list = new ArrayList<>();
	}

	public int getEndPageNo() {
		return endPageNo;
	}

	public void setEndPageNo(int endPageNo) {
		this.endPageNo = endPageNo;
	}

	public List<Accommodation> getList() {
		return list;
	}

	public void setList(List<Accommodation> list) {
		this.list = list;
	}
	
	
}
