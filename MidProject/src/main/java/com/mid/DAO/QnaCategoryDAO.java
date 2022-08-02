package com.mid.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mid.vo.QnaCategory;

public class QnaCategoryDAO extends DAO {

	// 전체 조회
	public List<QnaCategory> selectAll() {
		connect();
		String sql = "select * from QnaCategory order by 1";
		List<QnaCategory> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				QnaCategory vo = new QnaCategory();
				vo.setCategoryId(rs.getInt("CATEGORY_ID"));
				vo.setCategoryName(rs.getString("CATEGORY_NAME"));
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

	// 단건 조회 - CATEGORY_ID
	public QnaCategory selectOne(QnaCategory qnaCategory) {
		String sql = "select * from QnaCategory where CATEGORY_ID =?";
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qnaCategory.getCategoryId());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				QnaCategory vo = new QnaCategory();
				vo.setCategoryId(rs.getInt("CATEGORY_ID"));
				vo.setCategoryName(rs.getString("CATEGORY_NAME"));
				return vo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}

	// 삭제 - CATEGORY_ID
	public void delete(QnaCategory qnaCategory) {
		String sql = "delete qnaCategory where CATEGORY_ID=?";
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qnaCategory.getCategoryId());
			int r = pstmt.executeUpdate();
			System.out.println(r + "건 업데이트.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
}
