package com.mid.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.mid.vo.Member;

public class MemberDAO extends DAO {

	// 입력
	public void insertMemeber(Member vo) {
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
