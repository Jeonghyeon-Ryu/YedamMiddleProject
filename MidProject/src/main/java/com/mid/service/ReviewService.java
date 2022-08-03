package com.mid.service;

import java.util.List;

import com.mid.dao.ReviewDAO;
import com.mid.vo.Review;

public class ReviewService {
	private static ReviewService instance;

	private ReviewService() {
	}
 
	public static ReviewService getInstance() {
		if (instance == null) {
			instance = new ReviewService();
		}
		return instance;
	}

	ReviewDAO rvdao = new ReviewDAO();

	// 리뷰 전체 가져오기
	public List<Review> getReviewAll() {
		return rvdao.selectAll();
	}
}
