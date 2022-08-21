package com.mid.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.mid.common.Controller;
import com.mid.service.BusinessService;
import com.mid.service.ChatService;
import com.mid.vo.Chat;

public class SendContentController implements Controller {
	JsonArray result = new JsonArray();

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=utf-8");
		HttpSession session = req.getSession();
		String send = (String) session.getAttribute("id");
		BusinessService bService = BusinessService.getInstance();
		String recevi = req.getParameter("youId");
		String sendBmId = Integer.toString(bService.getBusinessId(send));
		String content = req.getParameter("msSendText");
		
		if (!(recevi.charAt(0) >= '0' && recevi.charAt(0) <= '9')) {
			send = sendBmId;}
		
		Chat chat = new Chat();
		ChatService chatService = ChatService.getInstance();
		System.out.println(send);
		System.out.println(recevi);
		System.out.println(content);

		req.setAttribute("recevi", recevi);
		

		chat.setContent(content);
		chat.setReceiver(recevi);
		chat.setSender(send);
		if (content.length() > 11) {
			if (content.substring(0, 10).equals("img/emoji_")) {
				chat.setCheckEmoji(1);
				chatService.insert(chat);
			} else {
				chat.setCheckEmoji(0);
				chatService.insert(chat);
			}
		} else {
			chat.setCheckEmoji(0);
			chatService.insert(chat);
		}

		Gson gson = new GsonBuilder().create();
		try {
			resp.getWriter().print(gson.toJson(chatService.selectLastContent(send, recevi)));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
