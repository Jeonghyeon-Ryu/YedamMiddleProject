package com.mid.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mid.dao.AccommodationDAO;
import com.mid.vo.Accommodation;

public class InsertController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("data_title");
		String address = req.getParameter("user_address");
		String phone = req.getParameter("telno");
		String imgUrl = req.getParameter("fileurl1");
		Double pointX;
		Double pointY;
		try {
			pointX = Double.parseDouble(req.getParameter("lattitude"));
		} catch (Exception e) {
			pointX = 0.0;
		}
		
		try {
			pointY = Double.parseDouble(req.getParameter("logitude"));
		} catch (Exception e) {
			pointY = 0.0;
		}
		Accommodation acc = new Accommodation();
		acc.setName(name);
		acc.setAddress(address);
		acc.setPhone(phone);
		acc.setImgUrl(imgUrl);
		acc.setPointX(pointX);
		acc.setPointY(pointY);
		
		AccommodationDAO dao = new AccommodationDAO();
		dao.insert(acc);
		
	}

}
