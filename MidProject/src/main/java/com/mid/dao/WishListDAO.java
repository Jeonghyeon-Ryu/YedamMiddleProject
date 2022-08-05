package com.mid.dao;

import com.mid.vo.WishList;

public class WishListDAO extends DAO {

	// 단건조회
	public WishList getWishList(int accId) {
		connect();
		WishList list = null;
		String sql = "SELECT a.name, AVG(r.review_score), COUNT(r.review_id) FROM accommodation a, review r WHERE a.acc_id = r.acc_id and a.acc_id = ? GROUP BY a.name;";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, accId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				list = new WishList();
				list.setName(rs.getString("name"));
				list.setReviewScore(rs.getInt(2));
				list.setReview_id(rs.getInt(3));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
}
