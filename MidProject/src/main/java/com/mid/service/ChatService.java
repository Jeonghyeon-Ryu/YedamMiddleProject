package com.mid.service;

import java.util.List;

import com.mid.dao.ChatDAO;
import com.mid.vo.Chat;

public class ChatService {
	private static ChatService instance;

	private ChatService() {
	}

	public static ChatService getInstance() {
		if (instance == null) {
			instance = new ChatService();
		}
		return instance;
	}

	ChatDAO cDAO = new ChatDAO();

	public void insert(Chat chat) {
		cDAO.insert(chat);
	}
	
	public List<Chat> selectAll(){
		return cDAO.selectAll();
	}
}
