package com.mid.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mid.common.Controller;
import com.mid.common.Utils;
import com.mid.service.QnaService;
import com.mid.vo.Qna;

public class QnaDetailController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String qnaId = req.getParameter("qnaId");
		
		QnaService service = QnaService.getInstance();
		Qna qna = service.selectOne(Integer.parseInt(qnaId));
		
		req.setAttribute("qna",qna);
		Utils.forward(req, resp, "qna/qnaDetail.tiles");

	}

}
