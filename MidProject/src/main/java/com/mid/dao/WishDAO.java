package com.mid.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mid.vo.Accommodation;
import com.mid.vo.Wish;

public class WishDAO extends DAO{
	// 위시리스트 등록
	public boolean insert(Wish vo) {
		boolean result = false;
		try {
			connect();
			String sql = "INSERT INTO wish VALUES(?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getAccId());
			pstmt.setString(2, vo.getMemberId());
			result = ((pstmt.executeUpdate()>0) ? true:false);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}
	// 위시리스트 삭제
	public boolean delete(Wish vo) {
		boolean result = false;
		try {
			connect();
			String sql = "DELETE FROM wish WHERE acc_id=? AND member_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getAccId());
			pstmt.setString(2, vo.getMemberId());
			result = ((pstmt.executeUpdate()>0) ? true:false);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}
	// 위시리스트 존재 조회
	public boolean select(Wish vo) {
		boolean result = false;
		try {
			connect();
			String sql = "SELECT * FROM wish WHERE acc_id=? AND member_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getAccId());
			pstmt.setString(2, vo.getMemberId());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}
	
	// 위시리스트 읽어오기
	public List<Accommodation> selectAll(String memberId) {
		List<Accommodation> list = new ArrayList<>();
		try {
			connect();
			String sql = "SELECT a.acc_id, a.name, a.img_url, a.address FROM wish w JOIN accommodation a ON w.acc_id=a.acc_id  WHERE member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Accommodation acc = new Accommodation();
				acc.setAccId(rs.getInt(1));
				acc.setName(rs.getString(2));
				acc.setImgUrl(rs.getString(3));
				acc.setAddress(rs.getString(4));
				list.add(acc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
}
