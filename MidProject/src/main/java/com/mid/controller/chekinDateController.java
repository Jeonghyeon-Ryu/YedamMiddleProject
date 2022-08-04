package com.mid.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mid.common.Controller;
import com.mid.service.MemberService;
import com.mid.vo.Member;

public class chekinDateController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/json;charset=utf-8");

		String inDate = req.getParameter("inDate");
		String outDate = req.getParameter("outDate");
		
		
	}

}
