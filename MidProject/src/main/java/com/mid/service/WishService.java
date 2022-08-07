package com.mid.service;

import java.util.List;

import com.mid.dao.WishDAO;
import com.mid.vo.Accommodation;
import com.mid.vo.Wish;

public class WishService {
	private static WishService instance;
	private WishService() {}
	public static WishService getInstance() {
		if (instance == null) {
			instance = new WishService();
		}
		return instance;
	}
	
	// 위시리스트 등록
	public boolean insert(Wish vo) {
		return new WishDAO().insert(vo);
	}
	// 위시리스트 삭제
	public boolean delete(Wish vo) {
		return new WishDAO().delete(vo);
	}
	// 위시리스트 존재 확인
	public boolean select(Wish vo) {
		return new WishDAO().select(vo);
	}
	// 위시리스트 읽어오기
	public List<Accommodation> selectAll(String memberId) {
		return new WishDAO().selectAll(memberId);
	}
}
