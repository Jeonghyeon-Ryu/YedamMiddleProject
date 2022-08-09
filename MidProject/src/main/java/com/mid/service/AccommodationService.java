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

	public boolean update(Accommodation acc) {
		return new AccommodationDAO().update(acc);
	}
	public boolean deleteForBusiness(int accId) {
		return new AccommodationDAO().deleteForBusiness(accId);
	}
	public List<Accommodation> select(int pageNum, String filterQuery) {
		return new AccommodationDAO().selectAll(pageNum, filterQuery);
	}

	public List<Accommodation> select(int pageNum, String city, String filterQuery) {
		return new AccommodationDAO().selectList(pageNum, city, filterQuery);
	}

	public List<Accommodation> select(int pageNum, String city, String region, String filterQuery) {
		return new AccommodationDAO().selectList(pageNum, city, region, filterQuery);
	}
	public int selectCount() {
		return new AccommodationDAO().selectCount();
	}
	public int selectCount(String resultQuery) {
		return new AccommodationDAO().selectCount(resultQuery);
	}
	public int selectCount(String city, String resultQuery) {
		return new AccommodationDAO().selectCount(city, resultQuery);
	}
	public int selectCount(String city, String region, String resultQuery) {
		return new AccommodationDAO().selectCount(city,region, resultQuery);
	}
	public List<Accommodation> selectAllForBusiness(int businessId){
		return new AccommodationDAO().selectAllForBusiness(businessId);
	}
	public Accommodation getCompDetail(int accId) {
		return new AccommodationDAO().selectOne(accId);
	}
}
