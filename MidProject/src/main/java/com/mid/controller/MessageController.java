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
import com.mid.vo.Member;

public class MessageController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = req.getSession();
		String id = (String) session.getAttribute("id");
		ReservationService reService = ReservationService.getInstance();
		ChatService ctService = ChatService.getInstance();
		List<Chat> ctlist = ctService.selectAll();
		System.out.println(id);
		if (req.getAttribute("recevi") != null) {
			System.out.println(1);
			req.setAttribute("recevi", (String) req.getAttribute("recevi"));
		}

		
		int temp = (int)id.charAt(0);
		
		System.out.println(temp);
		if ((temp >= 47 && temp <= 58)) {
			System.out.println(id);
			List<Member> mlist = reService.selectMemberAccommodation(id);
			req.setAttribute("mlist", mlist);
			req.setAttribute("checkUser", 0);
			System.out.println(2);
		} else {
			System.out.println(id);
			List<Accommodation> acclist = reService.selectAccommodationLoginId(id);
			req.setAttribute("acclist", acclist);
			req.setAttribute("checkUser", 1);
			System.out.println(3);
		}
		req.setAttribute("ctlist", ctlist);
		Utils.forward(req, resp, "/WEB-INF/jsp/message/message.jsp");

	}

}
