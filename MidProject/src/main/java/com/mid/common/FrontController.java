package com.mid.common;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mid.controller.MainController;

public class FrontController extends HttpServlet {

	String charset = null;
	HashMap<String, Controller> mappings = null;

	@Override
	public void init(ServletConfig config) throws ServletException {

		charset = config.getInitParameter("charset");
		mappings = new HashMap<String, Controller>();
		System.out.println("fc");
		mappings.put("/main.do", new MainController());
		
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding(charset);

		String url = req.getRequestURI();
		String contextPath = req.getContextPath();
		String path = url.substring(contextPath.length());
		System.out.println(path);

		Controller subControl = mappings.get(path);
		subControl.execute(req, resp);

	}
}
