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
import com.mid.vo.PageCard;

public class SelectAccListController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		String pageNum = req.getParameter("pageNum");
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
		PageCard resultData = new PageCard();
//		int endPageNo=0;
//		List<Accommodation> list = new ArrayList<>();
		
		if(city.equals("") && region.equals("")) {
			resultData.setEndPageNo(service.selectCount()/20);
			resultData.setList(service.select(Integer.parseInt(pageNum)));
		} else if(!city.equals("") && region.equals("")) {
			resultData.setEndPageNo(service.selectCount(city)/20);
			resultData.setList(service.select(Integer.parseInt(pageNum),city));
		} else {
			resultData.setEndPageNo(service.selectCount(city,region)/20);
			resultData.setList(service.select(Integer.parseInt(pageNum),city,region));
		}
		
		Gson gson = new GsonBuilder().create();
		resp.getWriter().print(gson.toJson(resultData));
	}
}
