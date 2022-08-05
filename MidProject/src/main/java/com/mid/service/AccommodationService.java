package com.mid.service;

import java.util.List;

import com.mid.dao.AccommodationDAO;
import com.mid.vo.Accommodation;

public class AccommodationService {
	private static AccommodationService instance;

	private AccommodationService() {
	}

	public static AccommodationService getInstance() {
		if (instance == null) {
			instance = new AccommodationService();
		}
		return instance;
	}

	AccommodationDAO adao = new AccommodationDAO();

	public List<Accommodation> select(int pageNum) {
		return new AccommodationDAO().selectAll(pageNum);
	}

	public List<Accommodation> select(int pageNum, String city) {
		return new AccommodationDAO().selectList(pageNum, city);
	}

	public List<Accommodation> select(int pageNum, String city, String region) {
		return new AccommodationDAO().selectList(pageNum, city, region);
	}
	public int selectCount() {
		return new AccommodationDAO().selectCount();
	}
	public int selectCount(String city) {
		return new AccommodationDAO().selectCount(city);
	}
	public int selectCount(String city, String region) {
		return new AccommodationDAO().selectCount(city,region);
	}
	
	// 업체정보 출력
	public Accommodation getCompDetail(int accId) {
		return adao.selectOne(accId);
	}
}
