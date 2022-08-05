package com.mid.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.mid.common.Controller;
import com.mid.common.Utils;
import com.mid.service.ChatService;
import com.mid.vo.Chat;

public class SendContentController implements Controller {
	JsonArray result = new JsonArray();
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=utf-8");
		String send = req.getParameter("msSend");
		String recevi = req.getParameter("msReceiv");
		String content = req.getParameter("msSendText");
		
		Chat chat= new Chat();
		chat.setContent(content);
		chat.setReceiver(recevi);
		chat.setSender(send);
		
		System.out.println(recevi);
		
		ChatService chatService =ChatService.getInstance();
		chatService.insert(chat);
		req.setAttribute("recevi", recevi);
		
		
		Utils.forward(req, resp, "message.do");
		
		Gson gson = new GsonBuilder().create();
		try {
			resp.getWriter().print(gson.toJson(chat));
		} catch (IOException e) {
			e.printStackTrace();
		}


	}

}
