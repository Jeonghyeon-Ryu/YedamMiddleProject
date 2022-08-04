package com.mid.dao;

import com.mid.vo.CompDetail;

public class compDetailDAO extends DAO {

	// accommodation
	public CompDetail compInfo(int accId) {
		connect();
		CompDetail comp = null;
		String sql = "SELECT acc_id, name, address, phone FROM accommodation;";
		String sql2 = "SELECT member_id, review_content, review_content FROM review where acc_id=?";
		String sql3 = "SELECT room_id, name, info, is_reservation, price, reservation_time FROM room where acc_id=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, accId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				comp = new CompDetail();
				comp.setAccId(rs.getInt("ACC_ID"));
				comp.setAddress(rs.getString("ADDRESS"));
				comp.setName(rs.getString("NAME"));
				comp.setPhone(rs.getString("PHONE"));
			}
			pstmt = conn.prepareStatement(sql2);
			pstmt.setInt(1, accId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				comp.setMemberId(rs.getString("member_id"));
				comp.setReviewDate(rs.getDate("review_date"));
				comp.setReviewContent(rs.getString("review_content"));
			}
			pstmt = conn.prepareStatement(sql3);
			pstmt.setInt(1, accId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				comp.setRoomId(rs.getInt("room_id"));
				comp.setRoomName(rs.getString("name"));
				comp.setInfo(rs.getString("info"));
				comp.setIsReservation(rs.getInt("is_reservation"));
				comp.setPrice(rs.getInt("price"));
				comp.setReservationTime(rs.getDate("reservation_time"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return comp;
	}

//	// Review
//	public compDetail getReview(int accId) {
//		connect();
//		String sql2 = "SELECT member_id, review_content, review_content FROM review where acc_id=?";
//		try {
//			pstmt = conn.prepareStatement(sql2);
//			pstmt.setInt(1, accId);
//			rs = pstmt.executeQuery();
//			if (rs.next()) {
//				compDetail comp = new compDetail();
//				comp.setMemberId(rs.getString("member_id"));
//				comp.setReviewDate(rs.getDate("review_date"));
//				comp.setReviewContent(rs.getString("review_content"));
//
//				return comp;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			disconnect();
//		}
//		return null;
//	}
//
//	// Room
//	public compDetail getRoom(int accId) {
//		connect();
//		String sql3 = "SELECT room_id, name, info, is_reservation, price, reservation_time FROM room where acc_id=?";
//		try {
//			pstmt = conn.prepareStatement(sql3);
//			pstmt.setInt(1, accId);
//			rs = pstmt.executeQuery();
//			if (rs.next()) {
//				comp.setRoomId(rs.getInt("room_id"));
//				comp.setRoomName(rs.getString("name"));
//				comp.setInfo(rs.getString("info"));
//				comp.setIsReservation(rs.getInt("is_reservation"));
//				comp.setPrice(rs.getInt("price"));
//				comp.setReservationTime(rs.getDate("reservation_time"));
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			disconnect();
//		}
//		return null;
//	}
}
