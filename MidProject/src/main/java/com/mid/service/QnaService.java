package com.mid.service;

import java.util.List;

import com.mid.dao.QnaDAO;
import com.mid.vo.Qna;

public class QnaService {
	private static QnaService instance;

	private QnaService() {
	}

	public static QnaService getInstance() {
		if (instance == null) {
			instance = new QnaService();
		}
		return instance;
	}

	QnaDAO qDAO = new QnaDAO();
	
	public List<Qna> selectAll(){
		return qDAO.selectAll();
	}
	public List<Qna> selectCategory(String category){
		return qDAO.selectCategory(category);
	}
}
