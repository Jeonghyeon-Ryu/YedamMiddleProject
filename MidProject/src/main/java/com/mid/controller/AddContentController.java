package com.mid.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mid.common.Controller;
import com.mid.service.ChatService;
import com.mid.vo.Chat;

public class AddContentController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ChatService ctService = ChatService.getInstance();
		List<Chat> ctlist=ctService.selectAll();
		JsonArray jsonArray = new JsonArray();
		for(Chat chat : ctlist) {
			JsonObject jsonObject =new JsonObject();
			jsonObject.addProperty("sender", chat.getSender());
			jsonObject.addProperty("receiver", chat.getReceiver());
			jsonObject.addProperty("content", chat.getContent());
			jsonArray.add(jsonObject);
		}
		try {
			resp.getWriter().print(jsonArray);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
