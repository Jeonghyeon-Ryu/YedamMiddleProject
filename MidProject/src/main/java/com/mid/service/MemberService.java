package com.mid.service;

import java.util.List;

import com.mid.dao.MemberDAO;
import com.mid.vo.Member;

public class MemberService {
	private static MemberService instance;

	private MemberService() {
	}

	public static MemberService getInstance() {
		if (instance == null) {
			instance = new MemberService();
		}
		return instance;
	}

	MemberDAO mdao = new MemberDAO();

	// 회원가입
	public void addMember(Member vo) {
		mdao.insertMemeber(vo);
	}

	// 회원목록
	public List<Member> memberList() {
		return mdao.getMemberList();
	}

	// 회원조회
	public Member getMember(String id) {
		return mdao.searchMember(id);
	}

	// 회원정보수정
	public void modifyMember(Member vo) {
		mdao.updateMember(vo);
	}

	// 회원정보 삭제
	public boolean removeMember(String id) {
		return mdao.deleteMember(id);
	}

	// 로그인체크
	public Member loginChk(String id, String pw) {
		return mdao.loginChk(id, pw);
	}
}
