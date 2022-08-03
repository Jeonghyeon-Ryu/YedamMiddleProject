package com.mid.service;

import com.mid.dao.ReservationDAO;
import com.mid.vo.Reservation;

public class ReservationService {
	private static ReservationService instance;

	private ReservationService() {
	}
 
	public static ReservationService getInstance() {
		if (instance == null) {
			instance = new ReservationService();
		}
		return instance;
	}

	ReservationDAO rsdao = new ReservationDAO();

	// 예약 단건 조회
	public Reservation SelectOne(int roomId) {
		return rsdao.selectOne(roomId);
	}
}
