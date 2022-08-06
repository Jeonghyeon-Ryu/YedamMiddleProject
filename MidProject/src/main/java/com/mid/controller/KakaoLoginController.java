package com.mid.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.mid.common.Controller;
import com.mid.common.Utils;
import com.mid.service.MemberService;
import com.mid.vo.KakaoToken;
import com.mid.vo.Member;

public class KakaoLoginController extends HttpServlet implements Controller {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Code 를 통해 Access Token 발급 받음.
		String code = req.getParameter("code");

		String endpoint = "https://kauth.kakao.com/oauth/token";
		String endpoint2 = "https://kapi.kakao.com/v2/user/me";
		URL url = new URL(endpoint);

		String bodyData = "grant_type=authorization_code&";
		bodyData += "client_id=858c8fa25fe1eb7607a39eb252e16d9a&";
		bodyData += "redirect_uri=http://localhost:8088/MidProject/kakaoLogin.do?cmd=callback&";
		bodyData += "code=" + code;

		// Stream 연결
		HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
		// http header 값 넣기
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
		conn.setDoOutput(true);
		// request 하기
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream(), "UTF-8"));
		bw.write(bodyData);
		bw.flush();

		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
		String input = "";
		StringBuilder sb = new StringBuilder();
		while ((input = br.readLine()) != null) {
			sb.append(input);
		}

		// Gson으로 파싱
		Gson gson = new Gson();

		KakaoToken oAuthToken = gson.fromJson(sb.toString(), KakaoToken.class);
		// Access Token 이용하여 User 정보 받아옴. - endpoint2
		url = new URL(endpoint2);
		conn = (HttpsURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Authorization", "Bearer " + oAuthToken.getAccess_token());
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
		conn.setDoOutput(true);
		bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream(), "UTF-8"));
		bw.flush();

		br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
		input = "";
		sb = new StringBuilder();
		while ((input = br.readLine()) != null) {
			sb.append(input);
		}
		String kakaoId = sb.toString().substring(sb.indexOf("\"email\":") + 9, sb.length() - 3);
		String profileImageUrl = sb.toString().substring(sb.indexOf("\"profile_image_url\":") + 21,
				sb.toString().indexOf("\"is_default_image\":") - 2); 
		// Kakao유저 정보 vs DB유저 정보 비교 
		// DB 이전 kakao 로그인 기록 있으면 : 로그인 성공 -> Session저장 -> 메인화면
		// DB 이전 kakao 로그인 기록 없으면 : 카카오 연동페이지 -> 회원가입 OR 로그인 -> 메인화면
		MemberService service = MemberService.getInstance();
		Member member = service.selectKakao(kakaoId);
		if(member!=null) {
			req.getSession().setAttribute("id", member.getId());
			resp.sendRedirect("main.do");
		} else {
			req.setAttribute("kakaoId", kakaoId);
			Utils.forward(req, resp,"member/kakaoLinkLoginForm.tiles");
		}
	}
}
