package com.mid.service;

import com.mid.dao.WishListDAO;
import com.mid.vo.WishList;

public class WishListService {
	private static WishListService instance;

	private WishListService() {
	}

	public static WishListService getInstance() {
		if (instance == null) {
			instance = new WishListService();
		}
		return instance;
	}

	WishListDAO dao = new WishListDAO();

	// 단건조회
	public WishList getWishList(int accId) {
		return dao.getWishList(accId);
	}

}
