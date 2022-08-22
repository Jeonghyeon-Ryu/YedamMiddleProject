package com.mid.service;

import java.util.List;

import com.mid.dao.RoomDAO;
import com.mid.vo.Room;

public class RoomService {
	private static RoomService instance;
	private RoomService() {}
	public static RoomService getInstance() {
		if (instance == null) {
			instance = new RoomService();
		}
		return instance;
	}
	public boolean insert(Room room) {
		return new RoomDAO().insert(room);
	}
	public boolean update(Room room) {
		return new RoomDAO().update(room);
	}
	// 객실 전체 가져오기
	public List<Room> getRoomAll() {
		return new RoomDAO().selectAll();
	}
	// 객실 단건 출력
	public Room getRoomOne(int roomId) {
		return new RoomDAO().selectOne(roomId);
	}
	public Room selectOneAcc(int accId) {
		return new RoomDAO().selectOneAcc(accId);
	}
	public List<Room> selectAllForBusiness(int accId) {
		return new RoomDAO().selectAllForBusiness(accId);
	}
	public boolean deleteForBusiness(int roomId) {
		return new RoomDAO().deleteForBusiness(roomId);
	}
}
