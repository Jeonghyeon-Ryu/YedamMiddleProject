package com.mid.service;

import java.util.List;

import com.mid.dao.ExTourListDAO;
import com.mid.vo.ExTourList;

public class ExTourListService {
	private static ExTourListService instance;

	private ExTourListService() {
	}

	public static ExTourListService getInstance() {
		if (instance == null) {
			instance = new ExTourListService();
		}
		return instance;
	}
	
	ExTourListDAO dao = new ExTourListDAO();
	
	public List<ExTourList> getExTourList(String id) {
		return dao.getExTourList(id);
	}
}
