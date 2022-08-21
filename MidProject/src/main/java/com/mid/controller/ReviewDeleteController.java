package com.mid.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mid.common.Controller;
import com.mid.service.ReviewService;

public class ReviewDeleteController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String memberId = (String) req.getSession().getAttribute("id");
		String accId = req.getParameter("accId");
		String roomId = req.getParameter("roomId");
		
		ReviewService service = ReviewService.getInstance();
		boolean result = service.delete(Integer.parseInt(roomId), memberId);
		
		String retCode = "{\"retCode\":\"";
		if(result) {
			resp.getWriter().print(retCode + "success" + "\"}");
		} else {
			resp.getWriter().print(retCode + "fail" + "\"}");
		}
	}

}
