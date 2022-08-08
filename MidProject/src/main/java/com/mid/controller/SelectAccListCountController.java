package com.mid.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mid.common.Controller;
import com.mid.service.AccommodationService;

public class SelectAccListCountController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
		String minPrice = req.getParameter("minPrice");
		String maxPrice = req.getParameter("maxPrice");
		
		String filterQuery = "";
		if(f1!=null) 
			filterQuery += "r.info like '%"+ f1 +"%'";
		if(f2!=null) 
			filterQuery += " AND r.info like '%"+ f2 +"%'";
		if(f3!=null) 
			filterQuery += " AND r.info like '%"+ f3 +"%'";
		if(f4!=null) 
			filterQuery += " AND r.info like '%"+ f4 +"%'";
		if(f5!=null) 
			filterQuery += " AND r.info like '%"+ f5 +"%'";
		if(f6!=null) 
			filterQuery += " AND r.info like '%"+ f6 +"%'";
		if(f7!=null)
			filterQuery += " AND r.info like '%"+ f7 +"%'";
		if(f8!=null)
			filterQuery += " AND r.info like '%"+ f8 +"%'";
		if(f9!=null)
			filterQuery += " AND r.info like '%"+ f9 +"%'";
		
		String priceQuery = "";
		if(minPrice!=null && maxPrice!=null) {
			priceQuery += "r.price >= "+minPrice+" AND r.price<="+maxPrice;
		} else if(minPrice!=null && maxPrice==null) {
		}
		AccommodationService service = AccommodationService.getInstance();
		int countResult =0;
		if(!city.equals("") && region.equals("")) {
			countResult = service.selectCount(city);
		} else {
			countResult = service.selectCount(city,region);
		}
		
		resp.getWriter().print(countResult);
	}

}
