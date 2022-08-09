package com.mid.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mid.common.Controller;
import com.mid.service.ExTourListService;
import com.mid.vo.ExTourList;

public class ExTourListController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/json;charset=utf-8");
		ExTourListService service = ExTourListService.getInstance();
		String id = req.getParameter("id");
		
		List<ExTourList> tourList = service.getExTourList(id);
		
		Gson gson = new GsonBuilder().create();
		resp.getWriter().print(gson.toJson(tourList));
	}
}
