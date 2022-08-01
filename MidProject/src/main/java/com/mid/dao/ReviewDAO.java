package com.mid.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mid.vo.Review;
import com.mid.vo.Room;

public class ReviewDAO extends DAO {

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

	// 단건 조회 - reviewId
	public Review selectOne(Review review) {
		String sql = "select * from review where review_id =?";
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, review.getReviewId());
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
