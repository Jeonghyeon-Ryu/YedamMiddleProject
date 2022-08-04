package com.mid.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mid.common.Controller;
import com.mid.service.CompDetailService;
import com.mid.vo.CompDetail;


public class CompDetailController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String accId = req.getParameter("accId");
		
		CompDetailService service = CompDetailService.getInstance();
		CompDetail compInfo = service.compInfo(Integer.parseInt(accId));
		
		System.out.println(compInfo);
		
		Gson gson = new GsonBuilder().create();
		resp.getWriter().print(gson.toJson(compInfo));
		
//		// accommodation
//		req.setAttribute("compId", search.getAccId());
//		req.setAttribute("compNm", search.getName());
//		req.setAttribute("compAddr", search.getAddress());
//		req.setAttribute("comPhone", search.getPhone());
//
//		// review
//		req.setAttribute("memberId", review.getMemberId());
//		req.setAttribute("rvDate", review.getReviewDate());
//		req.setAttribute("rvContent", review.getReviewContent());
//
//		
//		// room
//		req.setAttribute("rmId", room.getRoomId());
//		req.setAttribute("rmName", room.getName());
//		req.setAttribute("rmInfo", room.getInfo());
//		req.setAttribute("rmIsReser", room.getIsReservation());
//		req.setAttribute("rmPrice", room.getPrice());
//		req.setAttribute("rmReserTime", room.getReservationTime());
//		
//		// 

//		Utils.forward(req, resp, "eju/compDetail.tiles");
		
	
	}

}
