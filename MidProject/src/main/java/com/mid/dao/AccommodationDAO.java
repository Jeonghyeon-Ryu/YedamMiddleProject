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
	public List<Accommodation> selectAll(int pageNum) {
		List<Accommodation> list = new ArrayList<>();
		try {
			connect();
			String sql = "SELECT * FROM accommodation WHERE acc_id<600 ORDER BY 1";
			String pagingSql = "select acc_id, name, address, phone, status, renewal_time, img_url " + "from ( "
					+ "    select seq, acc_id, name, address, phone, status, renewal_time, img_url "
					+ "        from (select rownum as seq, acc_id, name, address, phone, status, renewal_time, img_url "
					+ "    from (select * from accommodation order by acc_id desc)) " + "    where seq>=?)"
					+ "WHERE rownum <= 20";
			pstmt = conn.prepareStatement(pagingSql);
			pstmt.setInt(1, 1 + pageNum * 20);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Accommodation vo = new Accommodation();
				vo.setAccId(rs.getInt("ACC_ID"));
				vo.setAddress(rs.getString("ADDRESS"));
				vo.setName(rs.getString("NAME"));
				vo.setPhone(rs.getString("PHONE"));
				// vo.setPointX(rs.getDouble("POINT_X"));
				// vo.setPointY(rs.getDouble("POINT_Y"));
				vo.setRenewalTime(rs.getDate("RENEWAL_TIME"));
				vo.setStatus(rs.getInt("STATUS"));
				// vo.setZipcode(rs.getString("ZIPCODE"));
				vo.setImgUrl(rs.getString("IMG_URL"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 필터 적용 갯수 조회
	public int selectCount() {
		int countResult = 0;
		try {
			connect();
			String sql = "SELECT count(*) FROM accommodation";
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if (rs.next()) {
				countResult = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return countResult;
	}
	public int selectCount(String city) {
		int countResult = 0;
		try {
			connect();
			String sql = "SELECT count(*) FROM accommodation WHERE address LIKE '%" + city + "%'";
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if (rs.next()) {
				countResult = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return countResult;
	}

	public int selectCount(String city, String region) {
		int countResult = 0;
		try {
			connect();
			String sql = "SELECT count(*) FROM accommodation WHERE address LIKE '%" + city + "%' AND address LIKE '%" + region
					+ "%'";
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if (rs.next()) {
				countResult = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return countResult;
	}

	// 필터 적용 조회 - ADDRESS
	public List<Accommodation> selectList(int pageNum, String city) {
		List<Accommodation> list = new ArrayList<>();
		try {
			connect();
			String sql = "SELECT * FROM accommodation WHERE address LIKE '%" + city + "%'";
			String pagingSql = "SELECT acc_id, name, address, phone, status, renewal_time, img_url FROM ( "
					+ "    SELECT seq, acc_id, name, address, phone, status, renewal_time, img_url, info "
					+ "        FROM (SELECT rownum as seq, acc_id, name, address, phone, status, renewal_time, img_url, info "
					+ "            FROM (SELECT a.acc_id, a.name, a.address, a.phone, a.status, a.renewal_time, a.img_url, r.info FROM accommodation a INNER JOIN room r ON a.acc_id=r.acc_id WHERE a.address like '%"
					+ city + "%' ORDER BY a.acc_id DESC) ) "
					+ "    WHERE seq>=?) WHERE rownum <= 20";
			pstmt = conn.prepareStatement(pagingSql);
			pstmt.setInt(1, 1 + pageNum * 20);
			rs=pstmt.executeQuery();
			while (rs.next()) {
				Accommodation vo = new Accommodation();
				vo.setAccId(rs.getInt("ACC_ID"));
				vo.setAddress(rs.getString("ADDRESS"));
				vo.setName(rs.getString("NAME"));
				vo.setPhone(rs.getString("PHONE"));
				// vo.setPointX(rs.getDouble("POINT_X"));
				// vo.setPointY(rs.getDouble("POINT_Y"));
				vo.setRenewalTime(rs.getDate("RENEWAL_TIME"));
				vo.setStatus(rs.getInt("STATUS"));
				// vo.setZipcode(rs.getString("ZIPCODE"));
				vo.setImgUrl(rs.getString("IMG_URL"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		System.out.println("listSize : " + list.size());
		return list;
	}

	public List<Accommodation> selectList(int pageNum, String city, String region) {
		List<Accommodation> list = new ArrayList<>();
		try {
			connect();
			String sql = "SELECT * FROM accommodation WHERE address LIKE '%" + city + "%' AND address LIKE '%" + region
					+ "%'";
			String pagingSql = "SELECT acc_id, name, address, phone, status, renewal_time, img_url FROM ( "
					+ "    SELECT seq, acc_id, name, address, phone, status, renewal_time, img_url, info "
					+ "        FROM (SELECT rownum as seq, acc_id, name, address, phone, status, renewal_time, img_url, info "
					+ "            FROM (SELECT a.acc_id, a.name, a.address, a.phone, a.status, a.renewal_time, a.img_url, r.info FROM accommodation a INNER JOIN room r ON a.acc_id=r.acc_id WHERE a.address like '%"
					+ city + "%' AND a.address LIKE '%" + region + "%' ORDER BY a.acc_id DESC) " + "            ) "
					+ "    WHERE seq>=?) " + "WHERE rownum <= 20";
			pstmt = conn.prepareStatement(pagingSql);
			pstmt.setInt(1, 1 + pageNum * 20);
			rs=pstmt.executeQuery();
			while (rs.next()) {
				Accommodation vo = new Accommodation();
				vo.setAccId(rs.getInt("ACC_ID"));
				vo.setAddress(rs.getString("ADDRESS"));
				vo.setName(rs.getString("NAME"));
				vo.setPhone(rs.getString("PHONE"));
				// vo.setPointX(rs.getDouble("POINT_X"));
				// vo.setPointY(rs.getDouble("POINT_Y"));
				vo.setRenewalTime(rs.getDate("RENEWAL_TIME"));
				vo.setStatus(rs.getInt("STATUS"));
				// vo.setZipcode(rs.getString("ZIPCODE"));
				vo.setImgUrl(rs.getString("IMG_URL"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		System.out.println("listSize : " + list.size());
		return list;
	}

	// 단건 조회 - ACC_ID
	public Accommodation selectOne(int accId) {
		String sql = "SELECT * FROM accommodation WHERE acc_id =?";
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, accId);
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
				vo.setImgUrl(rs.getString("IMG_URL"));
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
	public void delete(int accId) {
		String sql = "DELETE FROM accommodation WHERE ACC_ID=?";
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, accId);
			int r = pstmt.executeUpdate();
			System.out.println(r + "건 업데이트.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
}
