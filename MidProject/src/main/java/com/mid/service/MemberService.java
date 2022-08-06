package com.mid.service;

import java.util.List;
import com.mid.dao.MemberDAO;
import com.mid.vo.Member;
import com.mid.dao.AccommodationDAO;
import com.mid.vo.Accommodation;


public class MemberService {
	private static MemberService instance;
	private MemberService() {}
	public static MemberService getInstance() {
		if (instance == null) {
			instance = new MemberService();
		}
		return instance;
	}
	//******************************************************
	// 카카오 가입/로그인 관련 서비스
	//******************************************************
	public Member selectKakao(String kakaoId) {
		return new MemberDAO().selectKakao(kakaoId);
	}
	public boolean updateKakao(Member vo) {
		return new MemberDAO().updateKakao(vo);
	}
	
	//******************************************************
	// 일반 가입/로그인 관련 서비스
	//******************************************************
	// 회원가입
	public void addMember(Member vo) {
		new MemberDAO().insertMember(vo);
	}

	// 회원목록
	public List<Member> memberList() {
		return new MemberDAO().getMemberList();
	}
 
	// 회원조회
	public Member getMember(String id) {
		return new MemberDAO().searchMember(id);
	}

	// 회원정보찾기
	public List<Member> getMemberByNm(String name){
		return new MemberDAO().searchMemberByName(name);
	}
	// 회원정보수정
	public void modifyMember(Member vo) {
		new MemberDAO().updateMember(vo);
	}

	// 회원정보 삭제
	public boolean removeMember(String id) {
		return new MemberDAO().deleteMember(id);
	}

	// 로그인체크
	public Member loginChk(String id, String pw) {
		return new MemberDAO().loginChk(id, pw);
	}
	
//	public Accommodation getCompDetail(Accommodation accommodation) {
//		return new AccommodationDAO.selectOne(accommodation);
//	}
}
