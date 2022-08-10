package com.mid.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mid.vo.Chat;

public class ChatDAO extends DAO {
	
	//대화 내용 최근 등록 조회
	public Chat selectLastContent(String myId, String youId) {
		connect();
		String sql = "select * from (select content,receiver,sender,checkemoji,currenttime,CHAT_SEQ,to_char(currenttime,'HH24:MI')ct from chat where ((sender = ? AND RECEIVER = ?) OR(sender = ? AND RECEIVER = ?)) ORDER BY CHAT_SEQ desc) where rownum = 1";
		Chat vo = new Chat();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,myId);
			pstmt.setString(2,youId);
			pstmt.setString(3,youId);
			pstmt.setString(4,myId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				vo.setContent(rs.getString("CONTENT"));
				vo.setReceiver(rs.getString("RECEIVER"));
				vo.setSender(rs.getString("SENDER"));
				vo.setCheckEmoji(rs.getInt("checkemoji"));
				vo.setCurrentTime(rs.getString("ct"));
				vo.setCurrentDay(rs.getString("currenttime"));
			}
			return vo;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}
	// 대화 내용 전체 조회
	public List<Chat> selectContent(String myId, String youId) {
		connect();
		String sql = "select content,receiver,sender,checkemoji,currenttime,to_char(currenttime,'HH24:MI')ct from chat where ((sender = ? AND RECEIVER = ?) OR(sender = ? AND RECEIVER = ?)) ORDER BY CHAT_SEQ";
		List<Chat> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,myId);
			pstmt.setString(2,youId);
			pstmt.setString(3,youId);
			pstmt.setString(4,myId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Chat vo = new Chat();
				vo.setContent(rs.getString("CONTENT"));
				vo.setReceiver(rs.getString("RECEIVER"));
				vo.setSender(rs.getString("SENDER"));
				vo.setCheckEmoji(rs.getInt("checkemoji"));
				vo.setCurrentTime(rs.getString("ct"));
				vo.setCurrentDay(rs.getString("currenttime"));
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
	
	// 전체 조회
		public List<Chat> selectAll() {
			connect();
			String sql = "select content,receiver,sender,checkemoji,currenttime,to_char(currenttime,'HH24:MI')ct from chat order by chat_seq";
			List<Chat> list = new ArrayList<>();
			try {
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					Chat vo = new Chat();
					vo.setContent(rs.getString("CONTENT"));
					vo.setReceiver(rs.getString("RECEIVER"));
					vo.setSender(rs.getString("SENDER"));
					vo.setCheckEmoji(rs.getInt("checkemoji"));
					vo.setCurrentTime(rs.getString("ct"));
					vo.setCurrentDay(rs.getString("currenttime"));
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
		
		// 대화 저장
		public void insert(Chat chat) {
			String sql = "insert into chat(sender,receiver,content,chat_seq,checkemoji,currenttime) values(?,?,?,chat_seq.nextval,?,sysdate)";
			connect();
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, chat.getSender());
				pstmt.setString(2, chat.getReceiver());
				pstmt.setString(3, chat.getContent());
				pstmt.setInt(4,chat.getCheckEmoji());
				int r = pstmt.executeUpdate();
				System.out.println(r + "건 업데이트.");
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				disconnect();
			}
		}
}
