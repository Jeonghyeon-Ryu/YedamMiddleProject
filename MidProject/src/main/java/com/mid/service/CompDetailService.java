package com.mid.service;

import com.mid.dao.CompDetailDAO;
import com.mid.vo.CompDetail;

public class CompDetailService {
	private static CompDetailService instance;

	private CompDetailService() {
	}

	public static CompDetailService getInstance() {
		if (instance == null) {
			instance = new CompDetailService();
		}
		return instance;
	}

	CompDetailDAO dao = new CompDetailDAO();

	// CompDetail 단건
	public CompDetail compInfo(int accId) {
		return dao.getcompDetail(accId);
	}

//	// Review 단건
//	public compDetail reviewInfo(int accId) {
//		return dao.getReview(accId);
//	}
//	
//	public compDetail roomInfo(int accId) {
//		return dao.getRoom(accId);
//	}
}
