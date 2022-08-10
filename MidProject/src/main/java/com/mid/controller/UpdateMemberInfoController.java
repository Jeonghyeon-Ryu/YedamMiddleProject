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

public class UpdateMemberInfoController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberService service = MemberService.getInstance();
		Member member = new Member();
		
		String job = req.getParameter("job");
		String id = req.getParameter("memberId");
		member = service.getMember(id);
		
		//이름,전화번호,비밀번호 수정 (로그인중)
		if(job.equals("infoUpdate")) {
			String pw = req.getParameter("memberPw");		//입력받은 현재 비번
			String NewPw = req.getParameter("new-memberPw");//입력받은 새 비번
			String presentPw = member.getPw();				//저장되어있는 현재 비번(암호화)
			String nm = req.getParameter("memberNm");
			String ph = req.getParameter("phone1");
			String ph2 = req.getParameter("phone2");
			String ph3 = req.getParameter("phone3");
			ph = ph+"-"+ph2+"-"+ph3;
			member.setPhone(ph);
			member.setName(nm);
			//비밀번호를 변경하는 경우
			if(!NewPw.equals("")) {
				pw = SHA256.encodeSha256(pw);
				NewPw = SHA256.encodeSha256(NewPw);
				//현재 비밀번호 체크
				if(!pw.equals(presentPw)) {
					req.setAttribute("msg", "현재 비밀번호가 옳지 않습니다.");
					Utils.forward(req, resp, "memberInfo.do");
				}
				else {
					member.setPw(NewPw);
					service.modifyMember(member);
					req.setAttribute("msg", "수정 완료되었습니다.");
					Utils.forward(req, resp, "memberInfo.do");
				}
			}else {
				service.modifyMember(member);
				req.setAttribute("msg", "수정 완료되었습니다.");
				Utils.forward(req, resp, "memberInfo.do");
			}
		}
		//비밀번호만 수정 (비밀번호 찾기시)
		else {
			String pw = req.getParameter("memberPw");
			pw = SHA256.encodeSha256(pw);
			member.setPw(pw);
			service.modifyMember(member);
			Utils.forward(req, resp, "main.do");
		}
	}

}
