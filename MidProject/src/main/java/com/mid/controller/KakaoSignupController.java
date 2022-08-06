package com.mid.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mid.common.Controller;
import com.mid.common.Utils;

public class KakaoSignupController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String kakaoId = req.getParameter("kakaoId");
		System.out.println(kakaoId);
		req.setAttribute("kakaoId", kakaoId);
		Utils.forward(req, resp, "member/kakaoSignupForm.tiles");
	}

}
