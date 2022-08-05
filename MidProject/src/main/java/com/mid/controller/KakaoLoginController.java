package com.mid.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.mid.common.Controller;
import com.mid.common.OAuthToken;

public class KakaoLoginController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String code = req.getParameter("code");

		//System.out.println("code :"+code);
		//Post요청, x-www-form-urlencoded
		
		String endpoint="https://kauth.kakao.com/oauth/token";
		URL url =new URL(endpoint);
		
		String bodyData="grant_type=authorization_code&";
		bodyData += "client_id={858c8fa25fe1eb7607a39eb252e16d9a}&";
		bodyData += "redirect_uri=http://localhost:8081/blog/oauth/kakao?";
		bodyData += "code="+code;
		
		//Stream 연결
		HttpsURLConnection conn=(HttpsURLConnection)url.openConnection();
		//http header 값 넣기
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
		conn.setDoOutput(true);
		//request 하기
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(conn.getOutputStream(),"UTF-8"));
		bw.write(bodyData);
		bw.flush();
			
		BufferedReader br = new BufferedReader(
				new InputStreamReader(conn.getInputStream(), "UTF-8")
				);
		String input="";
		StringBuilder sb=new StringBuilder();
		while((input=br.readLine())!=null){
			sb.append(input);
		}
		
		System.out.println(sb.toString());
				
		//Gson으로 파싱
		Gson gson=new Gson();
		OAuthToken oAuthToken=gson.fromJson(sb.toString(), OAuthToken.class);
	}
}
