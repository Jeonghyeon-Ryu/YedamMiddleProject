package com.mid.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mid.vo.Chat;

public class ChatDAO extends DAO {
	// 전체 조회
		public List<Chat> selectAll() {
			connect();
			String sql = "select * from Chat order by 1";
			List<Chat> list = new ArrayList<>();
			try {
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					Chat vo = new Chat();
					vo.setContent(rs.getString("CONTENT"));
					vo.setReceiver(rs.getString("RECEIVER"));
					vo.setSender(rs.getString("SENDER"));
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
		public Chat selectOne(Chat chat) {
			String sql = "select * from Chat where SENDER =?";
			connect();
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, chat.getSender());
				rs = pstmt.executeQuery();
				if (rs.next()) {
					Chat vo = new Chat();
					vo.setContent(rs.getString("CONTENT"));
					vo.setReceiver(rs.getString("RECEIVER"));
					vo.setSender(rs.getString("SENDER"));
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
		public void delete(Chat chat) {
			String sql = "delete chat where SENDER=?";
			connect();
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, chat.getSender());
				int r = pstmt.executeUpdate();
				System.out.println(r + "건 업데이트.");
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				disconnect();
			}
		}
}
