package com.mid.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mid.common.Controller;
import com.mid.common.Utils;
import com.mid.service.AccommodationService;
import com.mid.service.MemberService;
import com.mid.service.ReservationService;
import com.mid.service.RoomService;
import com.mid.vo.Accommodation;
import com.mid.vo.Member;
import com.mid.vo.Room;

public class ReservationPageController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		String accId = req.getParameter("accId");
		String id = (String) req.getSession().getAttribute("id");
		String checkIn = req.getParameter("checkIn");
		String checkOut = req.getParameter("checkOut");

		int resultCheckOut = 0;
		if(!checkIn.equals("") && !checkOut.equals("")) {		
			Date resultCheckIn = Date.valueOf(checkIn.replace('.','-'));
			Date tempCheckOut = Date.valueOf(checkOut.replace('.','-'));
			resultCheckOut = (int) ((tempCheckOut.getTime()-resultCheckIn.getTime())/1000/60/60/24);
		}
		req.setAttribute("reservationDate", resultCheckOut);
		
		AccommodationService acService = AccommodationService.getInstance();
		RoomService rmService = RoomService.getInstance();
		MemberService mbService = MemberService.getInstance();
		ReservationService rvService = ReservationService.getInstance();

		Accommodation acc = acService.getCompDetail(Integer.parseInt(accId));
		System.out.println(Integer.parseInt(accId));
		Room room = rmService.selectOneAcc(Integer.parseInt(accId));
		Member member = mbService.getMember(id);

		String price = room.getPrice();
		String resultPrice ="";
		if(price.indexOf("원")>=0) {
			resultPrice = price.substring(0,price.indexOf("원"));
		}else {
			resultPrice = price;
		}
		resultPrice = resultPrice.replaceAll(",","");
		resultPrice = String.valueOf(Integer.parseInt(resultPrice)*resultCheckOut);
		room.setPrice(resultPrice);
		
		req.setAttribute("accId", acc.getAccId());
		req.setAttribute("accName", acc.getName());
		req.setAttribute("accAddress", acc.getAddress());
		req.setAttribute("accPhone", acc.getPhone().substring(4, acc.getPhone().length()));
		req.setAttribute("imgUrl", acc.getImgUrl());
		req.setAttribute("accPhone", acc.getPhone());
		
		req.setAttribute("roomId", room.getRoomId());
		req.setAttribute("roomName", room.getName());
		req.setAttribute("info", room.getInfo());
		req.setAttribute("isReservation", room.getIsReservation());
		req.setAttribute("price", room.getPrice());
			
		req.setAttribute("memberName", member.getName());
		req.setAttribute("memberPhone", member.getPhone());
		req.setAttribute("checkIn", checkIn);
		req.setAttribute("checkOut", checkOut);

		Utils.forward(req, resp, "eju/reservationPage.tiles");
	}
}
