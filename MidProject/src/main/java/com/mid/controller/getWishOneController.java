package com.mid.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mid.common.Controller;
import com.mid.service.WishService;
import com.mid.vo.Wish;

public class getWishOneController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		String memberId = (String) req.getSession().getAttribute("id");
		String accId = req.getParameter("accId");
		Wish vo = new Wish();
		vo.setAccId(Integer.parseInt(accId));
		vo.setMemberId(memberId);
		
		WishService service = WishService.getInstance();
		boolean result = service.select(vo);
		String retCode = "{\"retCode\":\"";
		if(result) {
			resp.getWriter().print(retCode + "exist" + "\"}");
		} else {
			resp.getWriter().print(retCode + "notexist" + "\"}");
		}
	}

}
