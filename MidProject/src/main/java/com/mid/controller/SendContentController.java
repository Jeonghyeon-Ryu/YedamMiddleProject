package com.mid.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mid.common.Controller;
import com.mid.common.Utils;

public class SendContentController implements Controller {
	JsonArray result = new JsonArray();
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String send = req.getParameter("send");
		String recevi = req.getParameter("recevi");
		String content = req.getParameter("inputContent");
		File file = new File("C:\\test.txt");
		FileWriter writer = new FileWriter(file);
		FileReader reader = new FileReader(file);

		BufferedReader br = new BufferedReader(reader);
		String readLine = null;
		while ((readLine = br.readLine()) != null) {
			System.out.println("SendContentController : " +readLine);
//			readLine = readLine.replace("}", "},");
//			writer.write(readLine);
//			writer.flush();
		}
		br.close();
		
		JsonObject message = new JsonObject();
		message.addProperty("sender", send);
		message.addProperty("receiver", recevi);
		message.addProperty("content", content);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		//String json = gson.toJson(message);
		result.add(message);
		String json = gson.toJson(result);
		System.out.println("SendContentController : " +result);

		writer.write(json);
		writer.flush();

		writer.close();

		Utils.forward(req, resp, "main.do");

	}

}
