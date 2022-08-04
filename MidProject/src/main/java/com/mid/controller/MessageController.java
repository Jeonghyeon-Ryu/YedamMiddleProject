package com.mid.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mid.common.Controller;
import com.mid.common.Utils;
import com.mid.service.ReservationService;
import com.mid.vo.Accommodation;

public class MessageController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		HttpSession session= req.getSession();
		String id = (String)session.getAttribute("id");
		ReservationService service = ReservationService.getInstance();
		List<Accommodation> list = service.selectAccommodationLoginId(id);
		
	
	
		req.setAttribute("list",list);    
		Utils.forward(req, resp, "WEB-INF/jsp/message/message.jsp");

	}

}
