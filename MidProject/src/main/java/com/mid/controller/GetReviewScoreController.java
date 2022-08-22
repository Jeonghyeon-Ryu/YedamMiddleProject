package com.mid.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mid.common.Controller;
import com.mid.service.ReviewService;

public class GetReviewScoreController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String accId = req.getParameter("accId");
		
		ReviewService service = ReviewService.getInstance();
		int resultScore = service.getReviewScore(Integer.parseInt(accId));
		
		String retCode = "{\"retCode\":\"";
		resp.getWriter().print(retCode + resultScore + "\"}");
	}

}
