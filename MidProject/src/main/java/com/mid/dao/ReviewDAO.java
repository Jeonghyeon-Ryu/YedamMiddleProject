package com.mid.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mid.vo.Review;
import com.mid.vo.Room;

public class ReviewDAO extends DAO {
	// 리뷰 작성
	public boolean insert(Review review) {
		boolean result=false;
		try {
			connect();
			String sql = "INSERT INTO review(review_id,member_id,acc_id,room_id,review_score,review_content,review_date) values((SELECT NVL(MAX(review_id)+1,1) FROM review),?,?,?,?,?,SYSDATE)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, review.getMemberId());
			pstmt.setInt(2, review.getAccId());
			pstmt.setInt(3, review.getRoomId());
			pstmt.setInt(4, review.getReviewScore());
			pstmt.setString(5, review.getReviewContent());
			result = (pstmt.executeUpdate()>0)?true:false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		return result;
	}
	public boolean update(Review review) {
		boolean result=false;
		try {
			connect();
			String sql = "UPDATE review SET review_score=?,review_content=?,review_date=SYSDATE WHERE member_id=? AND room_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, review.getReviewScore());
			pstmt.setString(2, review.getReviewContent());
			pstmt.setString(3, review.getMemberId());
			pstmt.setInt(4, review.getRoomId());
			result = (pstmt.executeUpdate()>0)?true:false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}
	public boolean delete(int roomId, String memberId) {
		boolean result=false;
		try {
			connect();
			String sql = "DELETE FROM review WHERE member_id=? AND room_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			pstmt.setInt(2, roomId);
			result = (pstmt.executeUpdate()>0)?true:false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}
	// 회원이 작성한 리뷰 조회
	public Review selectOneOfMember(int roomId, String memberId) {
		Review review = null;
		try {
			connect();
			String sql = "SELECT * FROM review WHERE room_id=? AND member_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, roomId);
			pstmt.setString(2, memberId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				review = new Review();
				review.setReviewId(rs.getInt("review_id"));
				review.setMemberId(rs.getString("member_id"));
				review.setAccId(rs.getInt("acc_id"));
				review.setRoomId(rs.getInt("room_id"));
				review.setReviewScore(rs.getInt("review_score"));
				review.setReviewContent(rs.getString("review_content"));
				review.setReviewDate(rs.getDate("review_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return review;
	}
	public int getReviewScore(int accId) {
		int reviewScore = 0;
		try {
			connect();
			String sql = "SELECT AVG(review_score) FROM review WHERE acc_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, accId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				reviewScore = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return reviewScore;
	}
	// 전체 조회
	public List<Review> selectAll() {
		connect();
		String sql = "select * from review order by 1";
		List<Review> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Review vo = new Review();
				vo.setAccId(rs.getInt("ACC_ID"));
				vo.setMemberId(rs.getString("MEMBER_ID"));
				vo.setReviewContent(rs.getString("REVIEW_CONTENT"));
				vo.setReviewDate(rs.getDate("REVIEW_DATE"));
				vo.setReviewId(rs.getInt("REVIEW_ID"));
				vo.setReviewScore(rs.getInt("REVIEW_SCORE"));
				vo.setRoomId(rs.getInt("ROOM_ID"));
				list.add(vo);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}
	
	public List<Review> selectAllAcc(int accId) {
		connect();
		String sql = "select * from review where acc_id = ? order by 1";
		List<Review> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, accId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Review vo = new Review();
				vo.setAccId(rs.getInt("ACC_ID"));
				vo.setMemberId(rs.getString("MEMBER_ID"));
				vo.setReviewContent(rs.getString("REVIEW_CONTENT"));
				vo.setReviewDate(rs.getDate("REVIEW_DATE"));
				vo.setReviewId(rs.getInt("REVIEW_ID"));
				vo.setReviewScore(rs.getInt("REVIEW_SCORE"));
				vo.setRoomId(rs.getInt("ROOM_ID"));
				list.add(vo);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}

	// 단건 조회 - reviewId
	public Review selectOne(int accId) {
		String sql = "select * from review where acc_id =?";
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, accId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				Review vo = new Review();
				vo.setAccId(rs.getInt("ACC_ID"));
				vo.setMemberId(rs.getString("MEMBER_ID"));
				vo.setReviewContent(rs.getString("REVIEW_CONTENT"));
				vo.setReviewDate(rs.getDate("REVIEW_DATE"));
				vo.setReviewId(rs.getInt("REVIEW_ID"));
				vo.setReviewScore(rs.getInt("REVIEW_SCORE"));
				vo.setRoomId(rs.getInt("ROOM_ID"));
				return vo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}

	// 삭제
	public void delete(Review review) {
		String sql = "delete review where review_id=?";
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,review.getReviewId());
			int r = pstmt.executeUpdate();
			System.out.println(r + "건 업데이트.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

}
