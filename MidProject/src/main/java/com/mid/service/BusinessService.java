package com.mid.service;

import java.util.List;

import com.mid.dao.BusinessDAO;
import com.mid.vo.Business;

public class BusinessService {
	private static BusinessService instance;
	private BusinessService() {}
	public static BusinessService getInstance() {
		if (instance == null) {
			instance = new BusinessService();
		}
		return instance;
	}
	
	public boolean insert(Business vo) {
		return new BusinessDAO().insert(vo);
	}
	public boolean update(Business vo) {
		return new BusinessDAO().update(vo);
	}
	public boolean delete(int businessID) {
		return new BusinessDAO().delete(businessID);
	}
	public List<Business> selectAll(String memberId){
		return new BusinessDAO().selectAll(memberId);
	}
}
