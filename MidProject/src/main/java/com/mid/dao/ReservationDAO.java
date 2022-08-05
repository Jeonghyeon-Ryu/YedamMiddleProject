package com.mid.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mid.vo.Accommodation;
import com.mid.vo.Member;
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
	public Reservation selectOne(int roomId) {
		String sql = "select * from reservation where room_id =?";
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, roomId);
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
			pstmt.setInt(1, reservation.getRoomId());
			int r = pstmt.executeUpdate();
			System.out.println(r + "건 업데이트.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// Accommodation정보 loginId로 조회
	public List<Accommodation> selectOneAccommodationInfo(String id) {
		List<Accommodation> list = new ArrayList<>();
		String sql = "select * from accommodation where acc_id in(" + "select acc_id from room where room_id in("
				+ "select room_id from(" + "select *from reservation where member_id= ?)))";
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Accommodation vo = new Accommodation();
				vo.setAccId(rs.getInt("ACC_ID"));
				vo.setAddress(rs.getString("ADDRESS"));
				vo.setName(rs.getString("NAME"));
				vo.setPhone(rs.getString("PHONE"));
				vo.setPointX(rs.getDouble("POINT_X"));
				vo.setPointY(rs.getDouble("POINT_Y"));
				vo.setRenewalTime(rs.getDate("RENEWAL_TIME"));
				vo.setStatus(rs.getInt("STATUS"));
				vo.setZipcode(rs.getString("ZIPCODE"));
				vo.setImgUrl(rs.getString("IMG_URL"));
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

	public List<Member> selectMemberAccommodation(String id) {
		List<Member> list = new ArrayList<>();
		String sql = "select member_id from reservation where room_id in(select room_ID from room where acc_id=?)";
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Member vo = new Member();
				vo.setId(rs.getString("member_id"));
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
}
