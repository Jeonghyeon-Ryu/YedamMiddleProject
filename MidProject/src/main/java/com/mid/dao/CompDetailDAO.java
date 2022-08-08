package com.mid.dao;

import com.mid.vo.CompDetail;

public class CompDetailDAO extends DAO {

	public CompDetail getcompDetail(int accId) {
		CompDetail comp = null;
		connect();
		String sql = "SELECT a.acc_id, a.name, a.address, a.phone, rv.member_id, rv.review_score, rv.review_content, rv.review_date, rm.ROOM_ID, rm.name, rm.info, rm.is_reservation, rm.price, NVL(rm.reservation_time,sysdate) AS reservationTime, rv.review_id, a.img_url FROM accommodation a, review rv, room rm WHERE a.acc_id = rv.acc_id and rv.room_id = rm.room_id and a.acc_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, accId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				comp = new CompDetail();
				comp.setAccId(rs.getInt(1));
				comp.setName(rs.getString(2));
				comp.setAddress(rs.getString(3));
				comp.setPhone(rs.getString(4));
				comp.setMemberId(rs.getString(5));
				comp.setReviewScore(rs.getInt(6));
				comp.setReviewContent(rs.getString(7));
				comp.setReviewDate(rs.getDate(8));
				comp.setRoomId(rs.getInt(9));
				comp.setRoomName(rs.getString(10));
				comp.setInfo(rs.getString(11));
				comp.setIsReservation(rs.getInt(12));
				comp.setPrice(rs.getString(13));
				comp.setReservationTime(rs.getDate(14));
				comp.setReviewId(rs.getInt(15));
				comp.setImgUrl(rs.getString(16));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return comp;
	}

//	// accommodation
//	public CompDetail compInfo(int accId) {
//		connect();
//		CompDetail comp = null;
//		String sql = "SELECT acc_id, name, address, phone FROM accommodation;";
//		String sql2 = "SELECT member_id, review_content, review_content FROM review where acc_id=?";
//		String sql3 = "SELECT room_id, name, info, is_reservation, price, reservation_time FROM room where acc_id=?";
//
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, accId);
//			rs = pstmt.executeQuery();
//			if (rs.next()) {
//				comp = new CompDetail();
//				comp.setAccId(rs.getInt("ACC_ID"));
//				comp.setAddress(rs.getString("ADDRESS"));
//				comp.setName(rs.getString("NAME"));
//				comp.setPhone(rs.getString("PHONE"));
//			}
//			pstmt = conn.prepareStatement(sql2);
//			pstmt.setInt(1, accId);
//			rs = pstmt.executeQuery();
//			if (rs.next()) {
//				comp.setMemberId(rs.getString("member_id"));
//				comp.setReviewDate(rs.getDate("review_date"));
//				comp.setReviewContent(rs.getString("review_content"));
//			}
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
//		return comp;
//	}

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
