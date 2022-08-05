package com.mid.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mid.common.Controller;
import com.mid.service.WishListService;
import com.mid.vo.WishList;

public class WishListController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		WishListService service = WishListService.getInstance();
		String id = req.getParameter("accId");
		
		
		WishList wishList = service.getWishList(Integer.parseInt(id));
		
		Gson gson = new GsonBuilder().create();
		resp.getWriter().print(gson.toJson(wishList));
		
	}
}
