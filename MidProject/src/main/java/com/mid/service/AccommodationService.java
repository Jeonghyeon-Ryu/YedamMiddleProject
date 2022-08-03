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
	public List<Accommodation> select() {
		System.out.println("All");
		return new AccommodationDAO().selectAll();
	}
	public List<Accommodation> select(String city) {
		System.out.println("One");
		return new AccommodationDAO().selectOneAddress(city);
	}

	public List<Accommodation> select(String city, String region) {
		System.out.println("Two");
		return new AccommodationDAO().selectOneAddress(city,region);
	}
}
