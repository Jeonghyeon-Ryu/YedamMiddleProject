package com.mid.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mid.common.Controller;
import com.mid.service.ReviewService;
import com.mid.vo.Review;

public class ReviewInsertController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String memberId = (String) req.getSession().getAttribute("id");
		String accId = req.getParameter("accId");
		String roomId = req.getParameter("roomId");
		String star = req.getParameter("star");
		String reviewText = req.getParameter("reviewText");
		
		Review review = new Review();
		review.setMemberId(memberId);
		review.setAccId(Integer.parseInt(accId));
		review.setRoomId(Integer.parseInt(roomId));
		review.setReviewScore(Integer.parseInt(star));
		review.setReviewContent(reviewText);
		
		ReviewService service = ReviewService.getInstance();
		boolean result = service.insert(review);
		
		String retCode = "{\"retCode\":\"";
		if(result) {
			resp.getWriter().print(retCode + "success" + "\"}");
		} else {
			resp.getWriter().print(retCode + "fail" + "\"}");
		}
	}
}
