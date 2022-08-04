package com.mid.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mid.common.Controller;
import com.mid.common.Utils;
import com.mid.service.AccommodationService;
import com.mid.service.ReviewService;
import com.mid.service.RoomService;
import com.mid.vo.Accommodation;
import com.mid.vo.Review;
import com.mid.vo.Room;


public class CompDetailController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ReviewService rvService = ReviewService.getInstance();
		RoomService rmService = RoomService.getInstance();
		AccommodationService accService = AccommodationService.getInstance();

		String accId = req.getParameter("accId");

		Accommodation search = accService.getCompDetail(Integer.parseInt(accId));
		Review review = (Review) rvService.getReviewAll();
		Room room = (Room) rmService.getRoomAll();

		
		// accommodation
		req.setAttribute("compId", search.getAccId());
		req.setAttribute("compNm", search.getName());
		req.setAttribute("compAddr", search.getAddress());
		req.setAttribute("comPhone", search.getPhone());

		// review
		req.setAttribute("memberId", review.getMemberId());
		req.setAttribute("rvDate", review.getReviewDate());
		req.setAttribute("rvContent", review.getReviewContent());

		
		// room
		req.setAttribute("rmId", room.getRoomId());
		req.setAttribute("rmName", room.getName());
		req.setAttribute("rmInfo", room.getInfo());
		req.setAttribute("rmIsReser", room.getIsReservation());
		req.setAttribute("rmPrice", room.getPrice());
		req.setAttribute("rmReserTime", room.getReservationTime());

		Utils.forward(req, resp, "eju/compDetail.tiles");
		
	
	}

}
