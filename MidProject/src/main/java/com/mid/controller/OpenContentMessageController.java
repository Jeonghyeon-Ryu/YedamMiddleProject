package com.mid.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mid.common.Controller;
import com.mid.service.ChatService;
import com.mid.vo.Chat;

public class OpenContentMessageController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=utf-8");
		HttpSession session = req.getSession();
		String myId = (String) session.getAttribute("id");
		String youId = req.getParameter("youId");
		ChatService chatService = ChatService.getInstance();
		List<Chat> list =chatService.selectContent(myId, youId);
		System.out.println(list.get(0).getChatSeq());
		Gson gson = new GsonBuilder().create();
		resp.getWriter().print(gson.toJson(list));
	}

}
