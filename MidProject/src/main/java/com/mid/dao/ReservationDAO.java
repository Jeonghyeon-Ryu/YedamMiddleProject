package com.mid.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mid.vo.Reservation;

public class ReservationDAO extends DAO {
	
	// 전체 조회
	public List<Reservation> selectAll() {
		connect();
		String sql = "select * from Reservation order by 1";
		List<Reservation> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Reservation vo = new Reservation();
				vo.setHeadcount(rs.getInt("HEADCOUNT"));
				vo.setMemberId(rs.getString("MEMBER_ID"));
				vo.setPaymentCose(rs.getInt("PAYMENT_COST"));
				vo.setPaymentDate(rs.getDate("PAYMENT_DATE"));
				vo.setReservationDay(rs.getInt("RESERVATION_DAY"));
				vo.setReservationTime(rs.getDate("RESERVATION_TIME"));
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

	// 단건 조회 - roomId
	public Reservation selectOne(Reservation reservation) {
		String sql = "select * from reservation where room_id =?";
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reservation.getRoomId());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				Reservation vo = new Reservation();
				vo.setHeadcount(rs.getInt("HEADCOUNT"));
				vo.setMemberId(rs.getString("MEMBER_ID"));
				vo.setPaymentCose(rs.getInt("PAYMENT_COST"));
				vo.setPaymentDate(rs.getDate("PAYMENT_DATE"));
				vo.setReservationDay(rs.getInt("RESERVATION_DAY"));
				vo.setReservationTime(rs.getDate("RESERVATION_TIME"));
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

	// 삭제 - roomId
	public void delete(Reservation reservation) {
		String sql = "delete reservation where room_id=?";
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,reservation.getRoomId());
			int r = pstmt.executeUpdate();
			System.out.println(r + "건 업데이트.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
}
