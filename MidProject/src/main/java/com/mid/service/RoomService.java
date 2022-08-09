package com.mid.service;

import java.util.List;

import com.mid.dao.RoomDAO;
import com.mid.vo.Room;

public class RoomService {
	private static RoomService instance;

	private RoomService() {
	}
 
	public static RoomService getInstance() {
		if (instance == null) {
			instance = new RoomService();
		}
		return instance;
	}

	RoomDAO rmdao = new RoomDAO();

	// 객실 전체 가져오기
	public List<Room> getRoomAll() {
		return rmdao.selectAll();
	}

	// 객실 단건 출력
	public Room getRoomOne(int roomId) {
		return rmdao.selectOne(roomId);
	}
	
	public List<Room> selectAllForBusiness(int accId) {
		return new RoomDAO().selectAllForBusiness(accId);
	}
}
