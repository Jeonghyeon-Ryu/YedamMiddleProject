package com.mid.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mid.common.Controller;
import com.mid.common.Utils;

public class NaverSignupFormController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String naverId = req.getParameter("naverId");
		String name = req.getParameter("name");
		String gender = req.getParameter("gender");
		String phone = req.getParameter("phone");
		String year = req.getParameter("year");
		String birthday = req.getParameter("birthday");
		String profileImgUrl = req.getParameter("profileImgUrl");
		
		req.setAttribute("naverId", naverId);
		req.setAttribute("name", name);
		req.setAttribute("gender", gender);
		req.setAttribute("phone", phone);
		req.setAttribute("year", year);
		req.setAttribute("birthday", birthday);
		req.setAttribute("profileImgUrl", profileImgUrl);
		
		Utils.forward(req, resp, "member/naverSignupForm.tiles");
	}

}
