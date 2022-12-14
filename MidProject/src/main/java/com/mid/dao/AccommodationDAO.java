package com.mid.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mid.vo.Accommodation;

public class AccommodationDAO extends DAO {
	public boolean insert(Accommodation acc) {
		boolean result = false;
		try {
			connect();
			String sql = "INSERT INTO accommodation VALUES((select MAX(acc_id)+1 from accommodation),?,?,0,?,1,0,0,sysdate,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, acc.getName());
			pstmt.setString(2, acc.getAddress());
			pstmt.setString(3, acc.getPhone());
			pstmt.setString(4, acc.getImgUrl());
			pstmt.setInt(5, acc.getBusiness_id());
			result = (pstmt.executeUpdate()>0)?true:false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}
	public boolean update(Accommodation acc) {
		boolean result = false;
		try {
			connect();
			String sql="UPDATE accommodation SET name=?, address=?, phone=?, img_url=? WHERE acc_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, acc.getName());
			pstmt.setString(2, acc.getAddress());
			pstmt.setString(3, acc.getPhone());
			pstmt.setString(4, acc.getImgUrl());
			pstmt.setInt(5, acc.getAccId());
			result = (pstmt.executeUpdate()>0)?true:false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}
	public List<Accommodation> selectAllForBusiness(int businessId){
		List<Accommodation> list = new ArrayList<>();
		try {
			connect();
			String sql = "SELECT * FROM accommodation WHERE business_id = ? AND status != 0";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, businessId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
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
	// ?????? ??????
	public List<Accommodation> selectAll(int pageNum,String filterQuery) {
		List<Accommodation> list = new ArrayList<>();
		try {
			connect();
			String sql = "SELECT * FROM accommodation ORDER BY 1";
			String pagingSql="";
			if(filterQuery.equals("")) {
				pagingSql = "SELECT acc_id, name, address, phone, status, renewal_time, img_url FROM ( "
						+ "    SELECT seq, acc_id, name, address, phone, status, renewal_time, img_url "
						+ "        FROM (select rownum as seq, acc_id, name, address, phone, status, renewal_time, img_url "
						+ "    FROM (select * from accommodation WHERE status!=0 order by acc_id desc)) WHERE seq>=?)"
						+ "WHERE rownum <= 20";
			} else {
				pagingSql = "SELECT acc_id, name, address, phone, status, renewal_time, img_url FROM ( "
						+ "    SELECT seq, acc_id, name, address, phone, status, renewal_time, img_url, info "
						+ "        FROM (SELECT rownum as seq, acc_id, name, address, phone, status, renewal_time, img_url, info "
						+ "            FROM (SELECT a.acc_id, a.name, a.address, a.phone, a.status, a.renewal_time, a.img_url, r.info FROM accommodation a INNER JOIN room r ON a.acc_id=r.acc_id WHERE "
						+ filterQuery +" AND status!=0 ORDER BY a.acc_id DESC) ) "
						+ "    WHERE seq>=?) WHERE rownum <= 20";
			}
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

	// ?????? ?????? ?????? ??????
	public int selectCount() {
		int countResult = 0;
		try {
			connect();
			String sql = "SELECT count(*) FROM accommodation WHERE status!=0";
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
	public int selectCount(String resultQuery) {
		int countResult = 0;
		try {
			connect();
			String sql ="";
			if(resultQuery.equals("")) {
				sql = "SELECT count(*) FROM accommodation a JOIN room r ON a.acc_id=r.acc_id";
			} else {
				sql = "SELECT count(*) FROM accommodation a JOIN room r ON a.acc_id=r.acc_id WHERE " + resultQuery;
			}
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
	public int selectCount(String city, String resultQuery) {
		int countResult = 0;
		try {
			connect();
			String sql = "";
			if(resultQuery.equals("")) {
				sql = "SELECT count(*) FROM accommodation a JOIN room r ON a.acc_id=r.acc_id WHERE " + city;
			} else {
				sql = "SELECT count(*) FROM accommodation a JOIN room r ON a.acc_id=r.acc_id WHERE " + city + " AND "+ resultQuery;
			}
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

	public int selectCount(String city, String region, String resultQuery) {
		int countResult = 0;
		try {
			connect();
			String sql = "";
			if(city.equals("")) {
				if(resultQuery.equals("")) {
					sql = "SELECT count(*) FROM accommodation a JOIN room r ON a.acc_id=r.acc_id WHERE a.status != 0";
				} else {
					sql = "SELECT count(*) FROM accommodation a JOIN room r ON a.acc_id=r.acc_id WHERE " + resultQuery +" AND a.status != 0";
				}
			} else if (!city.equals("") && region.equals("")) {
				if(resultQuery.equals("")) {
					sql = "SELECT count(*) FROM accommodation a JOIN room r ON a.acc_id=r.acc_id WHERE " + city +" AND a.status != 0";
				} else {
					sql = "SELECT count(*) FROM accommodation a JOIN room r ON a.acc_id=r.acc_id WHERE " + city + " AND "+ resultQuery +" AND a.status != 0";
				}
			} else if (!city.equals("") && !region.equals("")) {
				if(resultQuery.equals("")) {
					sql = "SELECT count(*) FROM accommodation a JOIN room r ON a.acc_id=r.acc_id WHERE " + city + " AND " + region +" AND a.status != 0";
				} else {
					sql = "SELECT count(*) FROM accommodation a JOIN room r ON a.acc_id=r.acc_id WHERE " + city + " AND " + region + " AND "+ resultQuery +" AND a.status != 0";
				}
			}
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

	// ?????? ?????? ?????? - ADDRESS
	public List<Accommodation> selectList(int pageNum, String city, String filterQuery) {
		List<Accommodation> list = new ArrayList<>();
		try {
			connect();
			String sql = "SELECT * FROM accommodation WHERE address LIKE '%" + city + "%'";
			String pagingSql="";
			if(filterQuery.equals("")) {
				pagingSql = "SELECT acc_id, name, address, phone, status, renewal_time, img_url FROM ( "
						+ "    SELECT seq, acc_id, name, address, phone, status, renewal_time, img_url, info "
						+ "        FROM (SELECT rownum as seq, acc_id, name, address, phone, status, renewal_time, img_url, info "
						+ "            FROM (SELECT a.acc_id, a.name, a.address, a.phone, a.status, a.renewal_time, a.img_url, r.info FROM accommodation a INNER JOIN room r ON a.acc_id=r.acc_id WHERE "
						+ city + " AND a.status != 0 ORDER BY a.acc_id DESC) ) "
						+ "    WHERE seq>=?) WHERE rownum <= 20";
			} else {
				pagingSql = "SELECT acc_id, name, address, phone, status, renewal_time, img_url FROM ( "
						+ "    SELECT seq, acc_id, name, address, phone, status, renewal_time, img_url, info "
						+ "        FROM (SELECT rownum as seq, acc_id, name, address, phone, status, renewal_time, img_url, info "
						+ "            FROM (SELECT a.acc_id, a.name, a.address, a.phone, a.status, a.renewal_time, a.img_url, r.info FROM accommodation a INNER JOIN room r ON a.acc_id=r.acc_id WHERE "
						+ city + " AND "+ filterQuery +" AND a.status != 0 ORDER BY a.acc_id DESC) ) "
						+ "    WHERE seq>=?) WHERE rownum <= 20";
			}
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
		return list;
	}

	public List<Accommodation> selectList(int pageNum, String city, String region, String filterQuery) {
		List<Accommodation> list = new ArrayList<>();
		try {
			connect();
			String sql = "SELECT * FROM accommodation WHERE address LIKE '%" + city + "%' AND address LIKE '%" + region
					+ "%'";
			String pagingSql = "";
			if(filterQuery.equals("")) {
				pagingSql = "SELECT acc_id, name, address, phone, status, renewal_time, img_url FROM ( "
						+ "    SELECT seq, acc_id, name, address, phone, status, renewal_time, img_url, info "
						+ "        FROM (SELECT rownum as seq, acc_id, name, address, phone, status, renewal_time, img_url, info "
						+ "            FROM (SELECT a.acc_id, a.name, a.address, a.phone, a.status, a.renewal_time, a.img_url, r.info FROM accommodation a INNER JOIN room r ON a.acc_id=r.acc_id WHERE "
						+ city + " AND " + region + " AND a.status != 0 AND r.status != 0 ORDER BY a.acc_id DESC) " + "            ) "
						+ "    WHERE seq>=?) " + "WHERE rownum <= 20";
			} else {
				pagingSql = "SELECT acc_id, name, address, phone, status, renewal_time, img_url FROM ( "
						+ "    SELECT seq, acc_id, name, address, phone, status, renewal_time, img_url, info "
						+ "        FROM (SELECT rownum as seq, acc_id, name, address, phone, status, renewal_time, img_url, info "
						+ "            FROM (SELECT a.acc_id, a.name, a.address, a.phone, a.status, a.renewal_time, a.img_url, r.info FROM accommodation a INNER JOIN room r ON a.acc_id=r.acc_id WHERE "
						+ city + " AND " + region + " AND "+ filterQuery +" AND a.status != 0 AND r.status != 0 ORDER BY a.acc_id DESC) " + "            ) "
						+ "    WHERE seq>=?) " + "WHERE rownum <= 20";
			}
			System.out.println("pagingSQL : "+ pagingSql);
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
		return list;
	}

	// ?????? ?????? - ACC_ID
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

	// ?????? - QNA_ID
	public void delete(int accId) {
		String sql = "DELETE FROM accommodation WHERE ACC_ID=?";
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, accId);
			int r = pstmt.executeUpdate();
			System.out.println(r + "??? ????????????.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	public boolean deleteForBusiness(int accId) {
		boolean result = false;
		try {
			connect();
			String sql = "UPDATE accommodation SET status=0 WHERE ACC_ID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, accId);
			result = (pstmt.executeUpdate()>0)?true:false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}
}
