package com.mid.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mid.common.Controller;
import com.mid.service.ReservationService;
import com.mid.vo.Reservation;

public class InsertReservationController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String roomId = req.getParameter("roomId");
		String memberId = (String) req.getSession().getAttribute("id");
		String checkIn = req.getParameter("checkIn");
		String checkOut = req.getParameter("checkOut");
		String price = req.getParameter("price");
		Date resultCheckIn = Date.valueOf(checkIn.replace('.','-'));
		Date tempCheckOut = Date.valueOf(checkOut.replace('.','-'));
		int resultCheckOut = (int) ((tempCheckOut.getTime()-resultCheckIn.getTime())/1000/60/60/24);
		String resultPrice = price.substring(0,price.indexOf("원"));
		resultPrice = resultPrice.replaceAll(",","");
		resultPrice = String.valueOf(Integer.parseInt(resultPrice)*resultCheckOut);
		Reservation vo = new Reservation();
		vo.setRoomId(Integer.parseInt(roomId));
		vo.setMemberId(memberId);
		vo.setReservationTime(resultCheckIn);
		vo.setReservationDay(resultCheckOut);
		vo.setPaymentCose(resultPrice);
		
		ReservationService service = ReservationService.getInstance();
		boolean result = service.insert(vo);
		
		String retCode = "{\"retCode\":\"";
		if(result) {
			resp.getWriter().print(retCode + "success" + "\"}");
		} else {
			resp.getWriter().print(retCode + "fail" + "\"}");
		}
	}
}
