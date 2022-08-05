package com.mid.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mid.common.Controller;
import com.mid.common.SHA256;
import com.mid.common.Utils;
import com.mid.service.MemberService;
import com.mid.vo.Member;

public class MemberJoinController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MemberService service = MemberService.getInstance();
		Member vo = new Member();

		String memId = req.getParameter("memberId");
		String nm = req.getParameter("memberNm");
		String id1 = req.getParameter("identi");
		String id2 = req.getParameter("identi2");
		String pw = req.getParameter("memberPw");
		String pn1 = req.getParameter("phone1");
		String pn2 = req.getParameter("phone2");
		String pn3 = req.getParameter("phone3");
		
		pw = SHA256.encodeSha256(pw);
		
		vo.setId(memId);
		vo.setName(nm);
		vo.setIdentification(id1+"-"+id2.substring(0,1));
		vo.setPw(pw);
		vo.setPhone(pn1+'-'+pn2+'-'+pn3);
		
		service.addMember(vo);
		
		Utils.forward(req, resp, "member/memberJoinSuccess.tiles");
		
	}

}
