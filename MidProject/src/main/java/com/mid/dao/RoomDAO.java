package com.mid.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mid.vo.Room;

public class RoomDAO extends DAO {

	public boolean update(Room room) {
		boolean result = false;
		try {
			connect();
			String sql = "UPDATE room SET name=?, price=?, info=? WHERE room_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, room.getName());
			pstmt.setString(2, room.getPrice());
			pstmt.setString(3, room.getInfo());
			pstmt.setInt(4, room.getRoomId());
			result = (pstmt.executeUpdate()>0)?true:false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}
	// 전체 조회
	public List<Room> selectAll() {
		connect();
		String sql = "SELECT * FROM room ORDER BY 1";
		List<Room> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Room vo = new Room();
				vo.setAccId(rs.getInt("ACC_ID"));
				vo.setInfo(rs.getString("INFO"));
				vo.setIsReservation(rs.getInt("IS_RESERVATION"));
				vo.setName(rs.getString("NAME"));
				vo.setPrice(rs.getString("PRICE"));
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
	public List<Room> selectAllForBusiness(int accId) {
		connect();
		String sql = "select * from room WHERE acc_id=? AND status!=0 order by 1";
		List<Room> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, accId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Room vo = new Room();
				vo.setAccId(rs.getInt("ACC_ID"));
				vo.setInfo(rs.getString("INFO"));
				vo.setIsReservation(rs.getInt("IS_RESERVATION"));
				vo.setName(rs.getString("NAME"));
				vo.setPrice(rs.getString("PRICE"));
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
	public Room selectOne(int roomId) {
		String sql = "select * from room where room_id =?";
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, roomId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				Room vo = new Room();
				vo.setAccId(rs.getInt("ACC_ID"));
				vo.setInfo(rs.getString("INFO"));
				vo.setIsReservation(rs.getInt("IS_RESERVATION"));
				vo.setName(rs.getString("NAME"));
				vo.setPrice(rs.getString("PRICE"));
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
	
	public Room selectOneAcc(int accId) {
		String sql = "select * from room where acc_id =?";
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, accId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				Room vo = new Room();
				vo.setAccId(rs.getInt("ACC_ID"));
				vo.setInfo(rs.getString("INFO"));
				vo.setIsReservation(rs.getInt("IS_RESERVATION"));
				vo.setName(rs.getString("NAME"));
				vo.setPrice(rs.getString("PRICE"));
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
	
	//삭제
	public boolean deleteForBusiness(int roomId) {
		boolean result = false;
		try {
			connect(); 
			String sql = "UPDATE room SET status=0 WHERE room_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, roomId);
			result = (pstmt.executeUpdate()>0)?true:false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}
	
}
