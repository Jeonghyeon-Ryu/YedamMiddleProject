package com.mid.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mid.common.Controller;
import com.mid.service.QnaService;
import com.mid.vo.Qna;

public class GetQnaListController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/json; charset=utf-8");
		String category = req.getParameter("dategoryNm");
		
		QnaService service = QnaService.getInstance();
		List<Qna> qnaList = new ArrayList<>();
		
		if(category.equals("전체")||category==null) {
			qnaList = service.selectAll();
		}else {
			qnaList = service.selectCategory(category);
		}
		
		Gson gson = new GsonBuilder().create();
		resp.getWriter().print(gson.toJson(qnaList));	//json형태로 만들어줌
	}

}
