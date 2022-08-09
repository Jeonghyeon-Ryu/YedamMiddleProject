package com.mid.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mid.common.Controller;
import com.mid.service.AccommodationService;
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
		String minPrice = req.getParameter("minPrice");
		String maxPrice = req.getParameter("maxPrice");
		
		if(city!=null) {
			city = "a.address LIKE '%"+ city + "%'";
		} else {
			city = "";
		}
		if(region!=null) {
			region = "a.address LIKE '%" + region + "%'";
		} else {
			region ="";
		}
		
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
			priceQuery += "to_number(replace(substr(r.price,1,instr(r.price,'원')-1),',','')) >= "+minPrice+" AND to_number(replace(substr(r.price,1,instr(r.price,'원')-1),',',''))<="+maxPrice;
		} else if(minPrice!=null && maxPrice==null) {
			priceQuery += "to_number(replace(substr(r.price,1,instr(r.price,'원')-1),',','')) >= "+minPrice;
		} else if(minPrice==null && maxPrice!=null) {
			priceQuery += "to_number(replace(substr(r.price,1,instr(r.price,'원')-1),',','')) <= "+maxPrice;
		}
		
		String resultQuery = "";		
		if(!filterQuery.equals("") && !priceQuery.equals("")) {
			resultQuery = filterQuery + " AND " + priceQuery;
		} else if (!filterQuery.equals("") && priceQuery.equals("")) {
			resultQuery = filterQuery;
		} else if (filterQuery.equals("") && !priceQuery.equals("")) {
			resultQuery = priceQuery;
		}
		
		AccommodationService service = AccommodationService.getInstance();
		PageCard resultData = new PageCard();
		
		if(city.equals("") && region.equals("")) {
			resultData.setEndPageNo(service.selectCount()/20);
			resultData.setList(service.select(Integer.parseInt(pageNum), resultQuery));
		} else if(!city.equals("") && region.equals("")) {
			resultData.setEndPageNo(service.selectCount(city)/20);
			resultData.setList(service.select(Integer.parseInt(pageNum),city, resultQuery));
		} else {
			resultData.setEndPageNo(service.selectCount(city,region)/20);
			resultData.setList(service.select(Integer.parseInt(pageNum),city,region, resultQuery));
		}
		
		Gson gson = new GsonBuilder().create();
		resp.getWriter().print(gson.toJson(resultData));
	}
}