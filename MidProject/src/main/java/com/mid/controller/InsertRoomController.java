package com.mid.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mid.common.Controller;
import com.mid.service.RoomService;
import com.mid.vo.Room;

public class InsertRoomController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String accId = req.getParameter("accId");
		String roomName = req.getParameter("roomName");
		String roomPrice = req.getParameter("roomPrice");
		String roomInfo = req.getParameter("roomInfo");
		
		Room room = new Room();
		room.setAccId(Integer.parseInt(accId));
		room.setName(roomName);
		room.setPrice(roomPrice);
		room.setInfo(roomInfo);
		
		RoomService service = RoomService.getInstance();
		boolean result = service.insert(room);
		
		String retCode = "{\"retCode\":\"";
		if(result) {
			resp.getWriter().print(retCode + "success" + "\"}");
		} else {
			resp.getWriter().print(retCode + "fail" + "\"}");
		}
	}

}
