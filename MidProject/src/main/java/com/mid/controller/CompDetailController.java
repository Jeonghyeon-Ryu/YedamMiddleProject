package com.mid.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mid.common.Controller;
import com.mid.common.Utils;
import com.mid.service.AccommodationService;
import com.mid.service.MemberService;
import com.mid.service.ReviewService;
import com.mid.service.RoomService;
import com.mid.vo.Accommodation;
import com.mid.vo.Member;
import com.mid.vo.Review;
import com.mid.vo.Room;

public class CompDetailController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		String accId = req.getParameter("accId");
		String id = req.getParameter("id");
		String checkIn =req.getParameter("checkIn");
		String checkOut =req.getParameter("checkOut");
		int resultCheckOut = 0;
		if(!checkIn.equals("") && !checkOut.equals("")) {		
			Date resultCheckIn = Date.valueOf(checkIn.replace('.','-'));
			Date tempCheckOut = Date.valueOf(checkOut.replace('.','-'));
			resultCheckOut = (int) ((tempCheckOut.getTime()-resultCheckIn.getTime())/1000/60/60/24);
		}
		AccommodationService acService = AccommodationService.getInstance();
		RoomService rmService = RoomService.getInstance();
		ReviewService rvService = ReviewService.getInstance();
		MemberService mbService = MemberService.getInstance();
		
		Accommodation acInfo = acService.getCompDetail(Integer.parseInt(accId));
		Room rmInfo = rmService.selectOneAcc(Integer.parseInt(accId));
		List<Review> rvInfo =  rvService.getReviewAllAcc(Integer.parseInt(accId));
		Member mbInfo = mbService.getMember(id);
		
		String price = rmInfo.getPrice();
		String resultPrice ="";
		if(price.indexOf("원")>=0) {
			resultPrice = price.substring(0,price.indexOf("원"));
		}else {
			resultPrice = price;
		}
		resultPrice = resultPrice.replaceAll(",","");
		if(resultCheckOut!=0) {
			resultPrice = String.valueOf(Integer.parseInt(resultPrice)*resultCheckOut);
		} else {
			resultPrice = String.valueOf(Integer.parseInt(resultPrice));
		}
		rmInfo.setPrice(resultPrice);
		
		req.setAttribute("reservationDate", resultCheckOut);
		
		req.setAttribute("checkIn", checkIn);
		req.setAttribute("checkOut", checkOut);
		req.setAttribute("accId", acInfo.getAccId());
		req.setAttribute("accName", acInfo.getName());
		req.setAttribute("accAddress", acInfo.getAddress());
		req.setAttribute("accPhone", acInfo.getPhone().substring(4, acInfo.getPhone().length()));
		req.setAttribute("imgUrl", acInfo.getImgUrl());
		if (rvInfo != null) {
			req.setAttribute("rvInfo", rvInfo);
			
		}
		if (rmInfo != null) {
			req.setAttribute("roomId", rmInfo.getRoomId());
			req.setAttribute("roomName", rmInfo.getName());
			req.setAttribute("info", rmInfo.getInfo());
			req.setAttribute("isReservation", rmInfo.getIsReservation());
			req.setAttribute("price", rmInfo.getPrice());
			req.setAttribute("reservationTime", rmInfo.getReservationTime());
		}
		Utils.forward(req, resp, "eju/companyDetail.tiles");
	}

}
