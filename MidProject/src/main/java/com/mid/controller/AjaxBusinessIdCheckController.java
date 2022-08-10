package com.mid.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mid.common.Controller;
import com.mid.service.BusinessService;
import com.mid.vo.Business;

public class AjaxBusinessIdCheckController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=utf-8");

		int bmId = Integer.parseInt(req.getParameter("bmId"));
	
		BusinessService bService = BusinessService.getInstance();
		Business findId =bService.selectOne(bmId);
		
		if (findId==null) {
			resp.getWriter().print(1);
		} else {
			resp.getWriter().print(0);
		}

	}

}
