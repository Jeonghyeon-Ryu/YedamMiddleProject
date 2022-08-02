package com.mid.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mid.vo.Accommodation;


public class AccommodationDAO extends DAO {
	public void insert(Accommodation acc) {
		connect();
		String sql = "INSERT INTO accommodation VALUES(acc_seq.NEXTVAL,?,?,0,?,1,?,?,sysdate,?)"; 
		try {
			connect();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, acc.getName());
			pstmt.setString(2, acc.getAddress());
			pstmt.setString(3, acc.getPhone());
			pstmt.setDouble(4, acc.getPointX());
			pstmt.setDouble(5, acc.getPointY());
			pstmt.setString(6, acc.getImgUrl());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	// 전체 조회
	public List<Accommodation> selectAll() {
		connect();
		String sql = "select * from accommodation order by 1";
		List<Accommodation> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Accommodation vo = new Accommodation();
				vo.setAccId(rs.getInt("ACC_ID"));
				vo.setAddress(rs.getString("ADDRESS"));
				vo.setName(rs.getString("NAME"));
				vo.setPhone(rs.getString("PHONE"));
				vo.setPointX(rs.getDouble("POINT_X"));
				vo.setPointY(rs.getDouble("POINT_Y"));
				vo.setRenewalTime(rs.getDate("RENEWAL_TIME"));
				vo.setStatus(rs.getInt("STATUS"));
				vo.setZipcode(rs.getString("ZIPCODE"));
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

	// 단건 조회 - ACC_ID
	public Accommodation selectOne(Accommodation accommodation) {
		String sql = "select * from accommodation where ACC_ID =?";
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, accommodation.getAccId());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				Accommodation vo = new Accommodation();
				vo.setAccId(rs.getInt("ACC_ID"));
				vo.setAddress(rs.getString("ADDRESS"));
				vo.setName(rs.getString("NAME"));
				vo.setPhone(rs.getString("PHONE"));
				vo.setPointX(rs.getDouble("POINT_X"));
				vo.setPointY(rs.getDouble("POINT_Y"));
				vo.setRenewalTime(rs.getDate("RENEWAL_TIME"));
				vo.setStatus(rs.getInt("STATUS"));
				vo.setZipcode(rs.getString("ZIPCODE"));
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
	public void delete(Accommodation accommodation) {
		String sql = "delete accommodation where ACC_ID=?";
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, accommodation.getAccId());
			int r = pstmt.executeUpdate();
			System.out.println(r + "건 업데이트.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
}