package com.mid.dao;

import java.util.ArrayList;
import java.util.List;

import com.mid.vo.ExTourList;

public class ExTourListDAO extends DAO {
	public List<ExTourList> getExTourList(String id) {
		List<ExTourList> list = new ArrayList<>();
		connect();
		String sql = "SELECT a.name, rm.name, rs.reservation_time, rs.payment_date, rs.reservation_day, m.name, m.phone, rs.payment_cost FROM accommodation a, room rm, reservation rs, member m WHERE a.acc_id = rm.acc_id AND rm.room_id = rs.room_id AND rs.member_id = m.id AND m.id= ? ORDER BY 3 DESC";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ExTourList vo = new ExTourList();
				vo.setName(rs.getString("name"));
				vo.setRoomName(rs.getString("name"));
				vo.setReservationTime(rs.getDate("reservation_time"));
				vo.setReservationTime(rs.getDate("reservation_day"));
				vo.setPaymentDate(rs.getDate("payment_date"));
				vo.setMemberName(rs.getString("name"));
				vo.setPhone(rs.getString("phone"));
				vo.setPaymentCost(rs.getInt("payment_cost"));
				
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
}
