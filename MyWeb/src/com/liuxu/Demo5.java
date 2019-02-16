package com.liuxu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo5 extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html;charset=utf-8");
		PrintWriter pw = res.getWriter();
		pw.println("<div>");
		pw.println("<form action='demo6' method='get'>");
		pw.println("<input type='checkbox' name='maths'  />数学");
		pw.println("<input type='checkbox' name='chinese'  />语文");
		pw.println("<input type='checkbox' name='english'  />英语");
		pw.println("<input type='submit' value='选择学科'/>");
		pw.println("</div>");
//		res.sendRedirect("demo6");
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	this.doGet(req, resp);
	}
}
