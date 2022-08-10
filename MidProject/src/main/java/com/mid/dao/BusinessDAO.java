package com.mid.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mid.vo.Business;

public class BusinessDAO extends DAO{
	public boolean insert(Business vo) {
		boolean result = false;
		try {
			connect();
			String sql = "INSERT INTO business VALUES ( ?,?,?,? )";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMemberId());
			pstmt.setInt(2, vo.getBusinessId());
			pstmt.setString(3, vo.getBusinessName());
			pstmt.setString(4, vo.getBusinessAddress());
			result = (pstmt.executeUpdate()>0)?true:false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}
	
	public boolean update(Business vo) {
		boolean result = false;
		try {
			connect();
			String sql = "UPDATE business SET business_address=? WHERE business_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getBusinessAddress());
			pstmt.setInt(2, vo.getBusinessId());
			result = (pstmt.executeUpdate()>0)?true:false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}
	
	public boolean delete(int businessId) {
		boolean result = false;
		try {
			connect();
			String sql = "DELETE FROM business WHERE business_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, businessId);
			result = (pstmt.executeUpdate()>0)?true:false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}
	
	public List<Business> selectAll(String memberId){
		List<Business> list = new ArrayList<>();
		try {
			connect();
			String sql = "SELECT * FROM business WHERE member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Business vo = new Business();
				vo.setBusinessId(rs.getInt("business_id"));
				vo.setBusinessName(rs.getString("business_name"));
				vo.setBusinessAddress(rs.getString("business_address"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	//단건조회
		public Business selectOne(int bmId){
			try {
				connect();
				String sql = "SELECT * FROM business WHERE BUSINESS_ID = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, bmId);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					Business vo = new Business();
					vo.setBusinessId(rs.getInt("business_id"));
					vo.setBusinessName(rs.getString("business_name"));
					vo.setBusinessAddress(rs.getString("business_address"));
					vo.setMemberId(rs.getString("MEMBER_ID"));
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
