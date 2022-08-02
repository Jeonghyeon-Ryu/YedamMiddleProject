package com.mid.service;

public class MemberService {
	private static MemberService instance;
	private MemberService() {}
	public static MemberService getInstance() {
		if(instance==null) {
			instance=new MemberService();
		}
		return instance;
	}
}
