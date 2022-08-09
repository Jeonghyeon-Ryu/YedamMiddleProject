package com.mid.common;

import java.io.IOException;
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

public class ReservationPageController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		String accId = req.getParameter("accId");
		String id = req.getParameter("id");

		AccommodationService acService = AccommodationService.getInstance();
		RoomService rmService = RoomService.getInstance();
		MemberService mbService = MemberService.getInstance();

		Accommodation acInfo = acService.getCompDetail(Integer.parseInt(accId));
		System.out.println(acInfo);
		System.out.println(Integer.parseInt(accId));
		Room rmInfo = rmService.getRoomOne(Integer.parseInt(accId));
		Member mbInfo = mbService.getMember(id);

		req.setAttribute("accId", acInfo.getAccId());
		req.setAttribute("accName", acInfo.getName());
		req.setAttribute("accAddress", acInfo.getAddress());
		req.setAttribute("accPhone", acInfo.getPhone().substring(4, acInfo.getPhone().length()));
		req.setAttribute("imgUrl", acInfo.getImgUrl());
		if (rmInfo != null) {
			req.setAttribute("roomId", rmInfo.getRoomId());
			req.setAttribute("roomName", rmInfo.getName());
			req.setAttribute("info", rmInfo.getInfo());
			req.setAttribute("isReservation", rmInfo.getIsReservation());
			req.setAttribute("price", rmInfo.getPrice());
			req.setAttribute("checkIn", rmInfo.getReservationTime());
			req.setAttribute("checkOut", rmInfo.getReservationDay());
		}
		req.setAttribute("memberName", mbInfo.getName());
		req.setAttribute("phone", mbInfo.getPhone());

		Utils.forward(req, resp, "eju/reservationPage.tiles");

	}
}
