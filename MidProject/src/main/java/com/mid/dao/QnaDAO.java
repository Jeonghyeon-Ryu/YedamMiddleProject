package com.mid.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.mid.vo.Qna;

public class QnaDAO extends DAO {
	// 전체 조회
	public List<Qna> selectAll() {
		connect();
		String sql = "select * from Qna order by 1";
		List<Qna> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Qna vo = new Qna();
				vo.setQnaId(rs.getInt("QNA_ID"));
				vo.setCategoryId(rs.getInt("CATEGORY_ID"));
				vo.setMemberId(rs.getString("MEMBER_ID"));
				vo.setTitle(rs.getString("TITLE"));
				vo.setContent(rs.getString("CONTENT"));
				vo.setWriteDate(rs.getDate("WRITE_DATE"));
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

	// 카테고리 이름별 조회
	public List<Qna> selectCategory(String categoryNm) {
		connect();
		String sql = "select * "
					+ "from qna join qna_category using (category_id) "
					+ "where category_name=?";
		List<Qna> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, categoryNm);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Qna vo = new Qna();
				vo.setQnaId(rs.getInt("QNA_ID"));
				vo.setCategoryId(rs.getInt("CATEGORY_ID"));
				vo.setMemberId(rs.getString("MEMBER_ID"));
				vo.setTitle(rs.getString("TITLE"));
				vo.setContent(rs.getString("CONTENT"));
				vo.setWriteDate(rs.getDate("WRITE_DATE"));
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

	// 단건 조회 - QNA_ID
	public Qna selectOne(int qnaId) {
		String sql = "select * from Qna where QNA_ID =?";
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qnaId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				Qna vo = new Qna();
				vo.setCategoryId(rs.getInt("CATEGORY_ID"));
				vo.setContent(rs.getString("CONTENT"));
				vo.setMemberId(rs.getString("MEMBER_ID"));
				vo.setQnaId(rs.getInt("QNA_ID"));
				vo.setTitle(rs.getString("TITLE"));
				vo.setWriteDate(rs.getDate("WRITE_DATE"));
				return vo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}

	// 삭제 - QNA_ID
	public void delete(int qnaId) {
		String sql = "delete qna where QNA_ID=?";
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qnaId);
			int r = pstmt.executeUpdate();
			System.out.println(r + "건 업데이트.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
}
