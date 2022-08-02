package com.mid.service;

import com.mid.dao.AccommodationDAO;
import com.mid.vo.Accommodation;

public class MemberService {
	AccommodationDAO adao = new AccommodationDAO();
	private static MemberService instance;
	private MemberService() {}
	public static MemberService getInstance() {
		if(instance==null) {
			instance=new MemberService();
		}
		return instance;
	}
	
	public Accommodation getCompDetail(Accommodation accommodation) {
		return adao.selectOne(accommodation);
	}
}
