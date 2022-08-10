package com.mid.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mid.common.Controller;
import com.mid.service.RoomService;
import com.mid.vo.Room;

public class UpdateRoomController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String roomId = req.getParameter("roomId");
		String name = req.getParameter("name");
		String price = req.getParameter("price");
		String info = req.getParameter("info");
		Room room = new Room();
		room.setRoomId(Integer.parseInt(roomId));
		room.setName(name);
		room.setPrice(price);
		room.setInfo(info);
		
		RoomService service = RoomService.getInstance();
		boolean result = service.update(room);
		
		String retCode = "{\"retCode\":\"";
		if(result) {
			resp.getWriter().print(retCode + "success" + "\"}");
		} else {
			resp.getWriter().print(retCode + "fail" + "\"}");
		}

	}

}
