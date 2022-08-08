package com.mid.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.mid.common.Controller;
import com.mid.common.Utils;
import com.mid.service.MemberService;
import com.mid.vo.Member;

public class NaverLoginController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String clientId = "KBVX39Y4TiVNOKxAvsL2";// 애플리케이션 클라이언트 아이디값";
		String clientSecret = "03Ucu7jlHE";// 애플리케이션 클라이언트 시크릿값";
		String code = req.getParameter("code");
		String state = req.getParameter("state");
		String redirectURI = URLEncoder.encode("http://localhost:8088/MidProject/naverLogin.do", "UTF-8");
		String apiURL;
		apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&";
		apiURL += "client_id=" + clientId;
		apiURL += "&client_secret=" + clientSecret;
		apiURL += "&redirect_uri=" + redirectURI;
		apiURL += "&code=" + code;
		apiURL += "&state=" + state;
		URL url;
		HttpURLConnection con;
		//************************* 토큰 저장
		String access_token = "";
		String refresh_token = "";
		//************************* 사용자 정보 저장
		String id=null;
		String name=null;
		String gender=null;
		String phone=null;
		String year=null;
		String birthday=null;
		String profileImgUrl=null;
		
		try {
			url = new URL(apiURL);
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			int responseCode = con.getResponseCode();
			BufferedReader br;
			if (responseCode == 200) { // 정상 호출
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else { // 에러 발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
			StringBuffer res = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				res.append(inputLine);
			}
			br.close();
			if (responseCode == 200) {
				JSONParser parsing = new JSONParser();
				Object obj = parsing.parse(res.toString());
				JSONObject jsonObj = (JSONObject) obj;

				access_token = (String) jsonObj.get("access_token");
				refresh_token = (String) jsonObj.get("refresh_token");
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		//System.out.println(access_token);
		//System.out.println(refresh_token);

		// Naver Token 이용하여 User 정보 받아옴.
		apiURL = "https://openapi.naver.com/v1/nid/me";
		url = new URL(apiURL);

		con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("Authorization", "Bearer "+access_token);
		con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
		int responseCode = con.getResponseCode();
		BufferedReader br;
		if (responseCode == 200) { // 정상 호출
			br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		} else { // 에러 발생
			br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
		}
		String inputLine;
		StringBuffer res = new StringBuffer();
		while ((inputLine = br.readLine()) != null) {
			res.append(inputLine);
		}
		br.close();
		//System.out.println(res.toString());
		try {
			JSONParser parsing = new JSONParser();
			Object obj;
			obj = parsing.parse(res.toString());
			JSONObject jsonObj = (JSONObject)obj;
			JSONObject resObj = (JSONObject)jsonObj.get("response");
			id = (String)resObj.get("email");
			name = (String)resObj.get("name");
			gender = (String)resObj.get("gender");
			phone = (String)resObj.get("mobile");
			year = (String)resObj.get("birthyear");
			birthday = (String)resObj.get("birthday");
			profileImgUrl = (String)resObj.get("profile_image");
		} catch (ParseException e) {
			e.printStackTrace();
		}
//		System.out.println("ID : " + id);
//		System.out.println("name : " + name);
//		System.out.println("gender : " + gender);
//		System.out.println("phone : " + phone);
//		System.out.println("year : " + year);
//		System.out.println("birthday : " + birthday);
//		System.out.println("profileImgUrl : " + profileImgUrl);
		
		MemberService service = MemberService.getInstance();
		Member member = service.selectNaver(id);
		if(member!=null) {
			req.getSession().setAttribute("id", member.getId());
			resp.sendRedirect("main.do");
		} else {
			req.setAttribute("naverId", id);
			req.setAttribute("name", name);
			req.setAttribute("gender", gender);
			req.setAttribute("phone", phone);
			req.setAttribute("year", year);
			req.setAttribute("birthday", birthday);
			req.setAttribute("profileImgUrl", profileImgUrl);
			Utils.forward(req, resp,"member/socialLinkLoginForm.tiles");
		}
	}

}
