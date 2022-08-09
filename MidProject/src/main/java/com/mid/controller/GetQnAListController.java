package com.mid.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mid.common.Controller;
import com.mid.service.QnaService;
import com.mid.vo.Qna;

public class GetQnAListController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/json; charset=utf-8");
		String category = req.getParameter("dategoryNm");
		int categoryNum = Integer.parseInt(category);
		QnaService service = QnaService.getInstance();
		List<Qna> qnaList = service.selectCategory(categoryNum);
		
		Gson gson = new GsonBuilder().create();
		
		try {
			resp.getWriter().print(gson.toJson(qnaList));	//json형태로 만들어줌
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
