package com.mid.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.mid.vo.Member;

public class MemberDAO extends DAO {
	//*******************************************************
	// 네이버 회원가입 관련 메소드
	// signupNaver : 네이버 회원가입
	// selectNaver : 네이버 아이디 유무 확인
	// updateNaver : 네이버 최초 연동
	//*******************************************************
	public boolean signupNaver(Member vo) {
		boolean result = false;
		try {
			connect();
			String sql = "INSERT INTO member(id, pw, name, identification, phone, join_date, naver_id) VALUES (?,?,?,?,?,SYSDATE,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getIdentification());
			pstmt.setString(5, vo.getPhone());
			pstmt.setString(6, vo.getNaverId());
			result = ((pstmt.executeUpdate()>0) ? true : false ); 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}
	public Member selectNaver(String naverId) {
		Member vo = null;
		try {
			connect();
			String sql = "SELECT * FROM member WHERE naver_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, naverId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				vo = new Member();
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setPw(rs.getString("pw"));
				vo.setIdentification(rs.getString("identification"));
				vo.setPhone(rs.getString("phone"));
				vo.setJoinDate(rs.getDate("join_date"));
				vo.setNaverId(rs.getString("naver_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return vo;
	}
	public boolean updateNaver(Member vo) {
		boolean result =false;
		try {
			connect();
			String sql = "UPDATE member SET naver_id=? WHERE id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getNaverId());
			pstmt.setString(2, vo.getId());
			result = ((pstmt.executeUpdate()>0)? true:false);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}
	//*******************************************************
	// 카카오 회원가입 관련 메소드
	// signupKakao : 카카오 회원가입
	// selectKakao : 카카오 아이디 유무 확인
	// updateKakao : 카카오 최초 연동
	//*******************************************************
	public boolean signupKakao(Member vo) {
		boolean result = false;
		try {
			connect();
			String sql = "INSERT INTO member(id, pw, name, identification, phone, join_date, kakao_id) VALUES (?,?,?,?,?,SYSDATE,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getIdentification());
			pstmt.setString(5, vo.getPhone());
			pstmt.setString(6, vo.getKakaoId());
			result = ((pstmt.executeUpdate()>0) ? true : false ); 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}
	public Member selectKakao(String kakaoId) {
		Member vo = null;
		try {
			connect();
			String sql = "SELECT * FROM member WHERE kakao_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, kakaoId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				vo = new Member();
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setPw(rs.getString("pw"));
				vo.setIdentification(rs.getString("identification"));
				vo.setPhone(rs.getString("phone"));
				vo.setJoinDate(rs.getDate("join_date"));
				vo.setKakaoId(rs.getString("kakao_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return vo;
	}
	public boolean updateKakao(Member vo) {
		boolean result =false;
		try {
			connect();
			String sql = "UPDATE member SET kakao_id=? WHERE id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getKakaoId());
			pstmt.setString(2, vo.getId());
			result = ((pstmt.executeUpdate()>0)? true:false);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}
	//*******************************************************
	// 입력 ( 일반 회원 가입 )
	//*******************************************************
	public void insertMember(Member vo) {
		String sql = "insert into member(id, pw, name, identification, phone, join_date) "
				+ "values(?,?,?,?,?,sysdate)";
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getIdentification());
			pstmt.setString(5, vo.getPhone());

			int r = pstmt.executeUpdate();
			System.out.println(r + "건 입력");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 리스트 출력
	public List<Member> getMemberList() {
		List<Member> list = new ArrayList<>();
		connect();
		String sql = "select * from member";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Member vo = new Member();
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setPw(rs.getString("pw"));
				vo.setIdentification(rs.getString("identification"));
				vo.setPhone(rs.getString("phone"));
				vo.setJoinDate(rs.getDate("join_date"));

				list.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 단건조회 (id)
	public Member searchMember(String id) {
		String sql = "select * from member where id=?";
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				Member vo = new Member();
				vo.setId(id);
				vo.setName(rs.getString("name"));
				vo.setPw(rs.getString("pw"));
				vo.setIdentification(rs.getString("identification"));
				vo.setPhone(rs.getString("phone"));
				vo.setJoinDate(rs.getDate("join_date"));
				return vo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}
	// 단건조회 (name)
		public List<Member> searchMemberByName(String name) {
			String sql = "select * from member where name=?";
			connect();
			try {
				List<Member> list = new ArrayList<>();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, name);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					Member vo = new Member();
					vo.setId(rs.getString("id"));
					vo.setPw(rs.getString("pw"));
					vo.setIdentification(rs.getString("identification"));
					vo.setPhone(rs.getString("phone"));
					vo.setJoinDate(rs.getDate("join_date"));
					list.add(vo);
				}
				return list;
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				disconnect();
			}
			return null;
		}

	// 수정 : 비밀번호, 연락처
	public void updateMember(Member vo) {
		String sql = " UPDATE member SET pw=?, phone=? WHERE id=? ";
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPw());
			pstmt.setString(2, vo.getPhone());
			pstmt.setString(3, vo.getId());

			int r = pstmt.executeUpdate();
			System.out.println(r + "건 변경");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 삭제
	public boolean deleteMember(String id) {
		String sql = "DELETE from member WHERE id=?";
		int r = 0;
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			r = pstmt.executeUpdate();
			System.out.println(r + "건 삭제");
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}

	// 로그인체크
	public Member loginChk(String id, String pw) {
		String sql = "select * from member where id=? and passwd=?";
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				Member vo = new Member();
				vo.setId(id);
				vo.setPw(pw);
				vo.setName(rs.getString("name"));
				return vo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}
}
