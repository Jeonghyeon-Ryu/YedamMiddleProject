package com.mid.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mid.common.Controller;
import com.mid.common.Utils;
import com.mid.service.MemberService;
import com.mid.vo.Member;

public class FindInfoController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		MemberService service = MemberService.getInstance();
		List<Member> list = new ArrayList<>();
		
		String job = req.getParameter("job");
		
		String ph= req.getParameter("memberPhone");
		String nm = req.getParameter("memberNm");
		if(job.equals("searchId")) {
			List<Member> getList=service.getMemberByNm(nm);
			for(Member member:getList) {
				if(member.getPhone()==ph) {
					list.add(member);
				}
			}
			req.setAttribute("list",list);
			req.setAttribute("error", "정보가 없습니다.");
			Utils.forward(req, resp, "/WEB-INF/jsp/member/findInfo.jsp");
		}else {
		String id = req.getParameter("memberId");
			
		}
	}

}
