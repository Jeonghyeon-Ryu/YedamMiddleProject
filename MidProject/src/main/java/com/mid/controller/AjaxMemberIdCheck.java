package com.mid.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mid.common.Controller;
import com.mid.dao.MemberDAO;
import com.mid.vo.Member;

public class AjaxMemberIdCheck implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String idCheck = req.getParameter("id");
		MemberDAO mdao = new MemberDAO();
		
		Member findId = mdao.searchMember(idCheck);
		
		PrintWriter out = resp.getWriter();
		if (idCheck.equals(findId.getId())) {
			out.print("1");
		} else {
			out.print("0");
		}
	}

}
