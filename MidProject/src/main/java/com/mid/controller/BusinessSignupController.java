package com.mid.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.mid.common.Controller;
import com.mid.common.Utils;
import com.mid.service.BusinessService;
import com.mid.service.MemberService;
import com.mid.vo.Business;

public class BusinessSignupController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int bmId = Integer.parseInt(req.getParameter("bmId"));
		String bmName = req.getParameter("bmName");
		String bmAdr = req.getParameter("bmAdr");
		HttpSession session = req.getSession();
		String id = (String) session.getAttribute("id");

		Business vo = new Business();
		vo.setBusinessAddress(bmAdr);
		vo.setBusinessId(bmId);
		vo.setBusinessName(bmName);
		vo.setMemberId(id);

		BusinessService service = BusinessService.getInstance();
		service.insert(vo);
		service.signUpBuisness(vo.getMemberId());
		MemberService mService = MemberService.getInstance();
		session.setAttribute("businessId", mService.getBusinessId(id));
		Utils.forward(req, resp, "main.do");
	}
}
