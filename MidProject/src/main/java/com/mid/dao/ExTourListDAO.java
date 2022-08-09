package com.mid.dao;

import java.util.ArrayList;
import java.util.List;

import com.mid.vo.ExTourList;

public class ExTourListDAO extends DAO {
	public List<ExTourList> getExTourList(String id) {
		System.out.println(id);
		List<ExTourList> list = new ArrayList<>();
		connect();
		String sql = "SELECT a.name, rm.name, rs.reservation_time, rs.reservation_day, rs.payment_date, m.name, m.phone, rm.price, a.img_url,m.id, a.address FROM accommodation a, room rm, reservation rs, member m WHERE a.acc_id = rm.acc_id AND rm.room_id = rs.room_id AND rs.member_id = m.id AND m.id= ? ORDER BY 3 DESC";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ExTourList vo = new ExTourList();
				vo.setName(rs.getString(1));
				vo.setRoomName(rs.getString(2));
				vo.setReservationTime(rs.getDate(3));
				vo.setReservationDay(rs.getInt(4));
				vo.setPaymentDate(rs.getDate(5));
				vo.setMemberName(rs.getString(6));
				vo.setPhone(rs.getString(7));
				vo.setPrice(rs.getString(8));
				vo.setImgUrl(rs.getString(9));
				vo.setId(rs.getString(10));
				vo.setAddress(rs.getString(11));
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
