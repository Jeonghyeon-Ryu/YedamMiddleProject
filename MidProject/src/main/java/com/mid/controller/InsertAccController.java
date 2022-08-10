package com.mid.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mid.common.Controller;
import com.mid.service.AccommodationService;
import com.mid.vo.Accommodation;

public class InsertAccController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String accName = req.getParameter("accName");
		String accPhone = req.getParameter("accPhone");
		String accAddress = req.getParameter("accAddress");
		String accImgUrl = req.getParameter("accImgUrl");
		String businessId = (String) req.getSession().getAttribute("businessId");
		
		Accommodation acc = new Accommodation();
		acc.setName(accName);
		acc.setPhone(accPhone);
		acc.setAddress(accAddress);
		acc.setImgUrl(accImgUrl);
		acc.setBusiness_id(Integer.parseInt(businessId));
		
		AccommodationService service = AccommodationService.getInstance();
		boolean result = service.insert(acc);
		String retCode = "{\"retCode\":\"";
		if(result) {
			resp.getWriter().print(retCode + "success" + "\"}");
		} else {
			resp.getWriter().print(retCode + "fail" + "\"}");
		}
	}
}
