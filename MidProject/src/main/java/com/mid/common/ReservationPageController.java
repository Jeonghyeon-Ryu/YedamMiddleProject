package com.mid.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mid.service.AccommodationService;
import com.mid.service.ReservationService;
import com.mid.service.RoomService;
import com.mid.vo.Accommodation;
import com.mid.vo.Reservation;
import com.mid.vo.Room;

public class ReservationPageController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AccommodationService accService = AccommodationService.getInstance();
		RoomService rmService = RoomService.getInstance();
		ReservationService rsService = ReservationService.getInstance();

		String roomId = req.getParameter("roomId");
		String accId = req.getParameter("accId");

		Accommodation accommo = accService.getCompDetail(Integer.parseInt(accId));
		Room room = rmService.getRoomOne(Integer.parseInt(roomId));
		Reservation reserv = rsService.SelectOne(Integer.parseInt(roomId));

		// accommodation
		req.setAttribute("", accommo.getAccId());
		req.setAttribute("", accommo.getPhone());
		req.setAttribute("", accommo.getAddress());

		// reservation
		req.setAttribute("", reserv.getReservationTime());
		req.setAttribute("", reserv.getReservationDay());
		// req.setAttribute("", 예약번호);
		req.setAttribute("", reserv.getPaymentDate());

		// room
		req.setAttribute("rmInfo", room.getInfo());

		Utils.forward(req, resp, "eju/reservationPage.tiles");
	}
}
