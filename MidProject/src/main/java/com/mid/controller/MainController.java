package com.mid.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mid.common.Controller;

public class MainController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("mc");
		RequestDispatcher rd = req.getRequestDispatcher("main/main.tiles");
		rd.forward(req, resp);

	}

}
