package com.mid.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mid.common.Controller;
import com.mid.service.AccommodationService;
import com.mid.vo.Accommodation;

public class UpdateAccController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String accId = req.getParameter("accId");
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		String address = req.getParameter("address");
		String imgUrl = req.getParameter("imgUrl");
		Accommodation acc = new Accommodation();
		acc.setAccId(Integer.parseInt(accId));
		acc.setName(name);
		acc.setPhone(phone);
		acc.setAddress(address);
		acc.setImgUrl(imgUrl);
		
		AccommodationService service = AccommodationService.getInstance();
		boolean result = service.update(acc);
		
		String retCode = "{\"retCode\":\"";
		if(result) {
			resp.getWriter().print(retCode + "success" + "\"}");
		} else {
			resp.getWriter().print(retCode + "fail" + "\"}");
		}
				

	}

}
