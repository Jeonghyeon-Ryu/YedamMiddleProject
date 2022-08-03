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
import com.mid.vo.Accommodation;

public class SelectAccListController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		String city = req.getParameter("city");
		String region = req.getParameter("region");
		String reservationDay = req.getParameter("reservationDay");
		String reservationTime = req.getParameter("reservationTime");
		String f1 = req.getParameter("f1");
		String f2 = req.getParameter("f2");
		String f3 = req.getParameter("f3");
		String f4 = req.getParameter("f4");
		String f5 = req.getParameter("f5");
		String f6 = req.getParameter("f6");
		String f7 = req.getParameter("f7");
		String f8 = req.getParameter("f8");
		String f9 = req.getParameter("f9");
		
		AccommodationService service = AccommodationService.getInstance();
		List<Accommodation> list = new ArrayList<>();
		System.out.println(city + "AA" + region);
		if(city=="" && region=="") {
			list = service.select();
		} else if(city!="" && region=="") {
			list = service.select(city);
		} else {
			list = service.select(city,region);
		}
		
		Gson gson = new GsonBuilder().create();
		resp.getWriter().print(gson.toJson(list));
	}
}
