package com.mid.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mid.common.Controller;
import com.mid.service.WishService;
import com.mid.vo.Wish;

public class setWishController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		String accId = req.getParameter("accId");
		String memberId = (String) req.getSession().getAttribute("id");

		Wish vo = new Wish();
		vo.setAccId(Integer.parseInt(accId));
		vo.setMemberId(memberId);
		
		WishService service = WishService.getInstance();
		boolean isList = service.select(vo);
		if(isList) {
			service.delete(vo);
			resp.getWriter().print("delete");
		} else {
			boolean result = service.insert(vo);
			if(result) {
				resp.getWriter().print("success");
			} else {
				resp.getWriter().print("fail");
			}
		}
	}
}
