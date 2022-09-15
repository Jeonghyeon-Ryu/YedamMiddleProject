package com.mid.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mid.common.Controller;
import com.mid.common.Utils;
import com.mid.service.ReviewService;
import com.mid.vo.Review;

public class ReviewOpenController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String accId = req.getParameter("accId");
		String roomId = req.getParameter("roomId");
		String memberId = (String) req.getSession().getAttribute("id");
		
		ReviewService service = ReviewService.getInstance();
		Review review = service.selectOneOfMember(Integer.parseInt(roomId), memberId);
		if(review!=null) {
			req.setAttribute("reviewContent", review.getReviewContent());
			req.setAttribute("reviewScore", review.getReviewScore());
		} 
		req.setAttribute("accId", accId);
		req.setAttribute("roomId", roomId);
		Utils.forward(req, resp, "WEB-INF/jsp/main/review.jsp");

	}

}
