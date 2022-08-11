package com.mid.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mid.common.Controller;
import com.mid.dao.MemberDAO;
import com.mid.service.MemberService;
import com.mid.vo.Member;

public class AjaxMemberIdCheck implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=utf-8");

		String idCheck = req.getParameter("joinId");
		MemberService service = MemberService.getInstance();
		Member findId = service.getMember(idCheck);
		System.out.println(idCheck+", 검색값 : "+findId);

		if (findId==null||findId.equals("")) {
			resp.getWriter().print(0);
		} else {
			resp.getWriter().print(1);
		}
	}

}
