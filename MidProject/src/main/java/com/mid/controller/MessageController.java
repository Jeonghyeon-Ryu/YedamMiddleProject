package com.mid.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mid.common.Controller;
import com.mid.common.Utils;
import com.mid.service.BusinessService;
import com.mid.service.ChatService;
import com.mid.service.ReservationService;
import com.mid.vo.Accommodation;
import com.mid.vo.Chat;
import com.mid.vo.Member;

public class MessageController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = (String) req.getSession().getAttribute("id");
		BusinessService bService = BusinessService.getInstance();
		String bmId = Integer.toString(bService.getBusinessId(id));

		ReservationService reService = ReservationService.getInstance();
		ChatService ctService = ChatService.getInstance();
		List<Chat> ctlist = ctService.selectAll();

		for (int i = 1; i < ctlist.size(); i++) {
			if (ctlist.get(i).getCurrentDay().substring(0, 10)
					.equals(ctlist.get(i - 1).getCurrentDay().substring(0, 10))) {
				ctlist.get(i).setNextDay(0);
				ctlist.get(i - 1).setCurrentDay(ctlist.get(i).getCurrentDay().substring(0, 10));
			}
		}
	
			List<Accommodation> acclist = reService.selectAccommodationLoginId(id);
			req.setAttribute("acclist", acclist);
		
		List<Member> mlist = reService.selectMemberAccommodation(bmId);
		req.setAttribute("mlist", mlist);
	
	
		req.setAttribute("ctlist", ctlist);
		Utils.forward(req, resp, "/message/message.tiles");
	}
}
