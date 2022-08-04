package com.mid.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mid.common.Controller;
import com.mid.common.Utils;
import com.mid.service.ChatService;
import com.mid.service.ReservationService;
import com.mid.vo.Accommodation;
import com.mid.vo.Chat;

public class MessageController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		HttpSession session= req.getSession();
		String id = (String)session.getAttribute("id");
		ReservationService reService = ReservationService.getInstance();
		List<Accommodation> acclist = reService.selectAccommodationLoginId(id);
		ChatService ctService = ChatService.getInstance();
		List<Chat> ctlist=ctService.selectAll();
		
		req.setAttribute("ctlist", ctlist);
		req.setAttribute("acclist",acclist);    
		Utils.forward(req, resp, "WEB-INF/jsp/message/message.jsp");

	}

}
