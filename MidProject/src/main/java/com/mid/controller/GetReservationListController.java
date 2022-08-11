package com.mid.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mid.common.Controller;
import com.mid.service.AccommodationService;
import com.mid.service.ReservationService;
import com.mid.service.RoomService;
import com.mid.vo.Accommodation;
import com.mid.vo.Reservation;
import com.mid.vo.ReservationInfo;
import com.mid.vo.Room;

public class GetReservationListController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		String memberId = (String) req.getSession().getAttribute("id");
		
		ReservationService reserService = ReservationService.getInstance();
		RoomService roomService = RoomService.getInstance();
		AccommodationService accService = AccommodationService.getInstance();
		List<ReservationInfo> resultList = new ArrayList<>();
		
		List<Reservation> list = reserService.selectAll(memberId);
		list.forEach(x -> {
			Room room = roomService.getRoomOne(x.getRoomId());
			Accommodation acc = accService.getCompDetail(room.getAccId());
			ReservationInfo info = new ReservationInfo();
			info.setReservation(x);
			info.setAccommodation(acc);
			info.setRoom(room);
			resultList.add(info);
		});
		
		Gson gson = new GsonBuilder().create();
		resp.getWriter().print(gson.toJson(resultList));
		
	}
}
