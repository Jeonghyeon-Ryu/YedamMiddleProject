package com.mid.service;

import java.util.List;

import com.mid.dao.ReviewDAO;
import com.mid.vo.Review;

public class ReviewService {
	private static ReviewService instance;
	private ReviewService() {}
	public static ReviewService getInstance() {
		if (instance == null) {
			instance = new ReviewService();
		}
		return instance;
	}
	// 리뷰 작성
	public boolean insert(Review review) {
		return new ReviewDAO().insert(review);
	}
	// 회원의 리뷰 가져오기
	public Review selectOneOfMember(int roomId, String memberId) {
		return new ReviewDAO().selectOneOfMember(roomId, memberId);
	}
	// 회원의 리뷰 수정
	public boolean update(Review review) {
		return new ReviewDAO().update(review);
	}
	// 회원의 리뷰 삭제
	public boolean delete(int roomId, String memberId) {
		return new ReviewDAO().delete(roomId, memberId);
	}
	public int getReviewScore(int accId) {
		return new ReviewDAO().getReviewScore(accId);
	}
	
	ReviewDAO rvdao = new ReviewDAO();

	// 리뷰 전체 가져오기
	public List<Review> getReviewAll() {
		return rvdao.selectAll();
	}

	public Review getReviewOne(int accId) {
		return rvdao.selectOne(accId);
	}

	public List<Review> getReviewAllAcc(int accId) {
		return rvdao.selectAllAcc(accId);
	}
}
