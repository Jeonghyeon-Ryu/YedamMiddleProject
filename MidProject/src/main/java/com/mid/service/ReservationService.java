package com.mid.service;

import java.util.List;

import com.mid.dao.ReservationDAO;
import com.mid.vo.Accommodation;
import com.mid.vo.Member;
import com.mid.vo.Reservation;

public class ReservationService {
	private static ReservationService instance;
	private ReservationService() {}
	public static ReservationService getInstance() {
		if (instance == null) {
			instance = new ReservationService();
		}
		return instance;
	}
	
	public boolean insert(Reservation vo) {
		return new ReservationDAO().insert(vo);
	}
	// 예약 단건 조회
	public Reservation SelectOne(int roomId) {
		return new ReservationDAO().selectOne(roomId);
	}
	// 예약 리스트 가져오기 - RJH
	public List<Reservation> selectAll(String memberId) {
		return new ReservationDAO().selectAll(memberId);
	}
	// 유저가 예약한곳 조회
	public List<Accommodation> selectAccommodationLoginId(String id){
		return new ReservationDAO().selectOneAccommodationInfo(id);
	}
	// 업체가 예약한 유저 조회
	public List<Member> selectMemberAccommodation(String id){
		return new ReservationDAO().selectMemberAccommodation(id);
	}
	
}
