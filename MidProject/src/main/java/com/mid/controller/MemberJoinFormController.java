package com.mid.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mid.common.Controller;
import com.mid.common.Utils;

public class MemberJoinFormController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Utils.forward(req, resp, "member/memberJoinForm.tiles");

	}

}
