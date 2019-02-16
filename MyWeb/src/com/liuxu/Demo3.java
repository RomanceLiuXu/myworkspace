package com.liuxu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Demo3 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// 判断登录
		String code = req.getParameter("code");
		String psw = req.getParameter("psw");
		if (code.equals("liuxu") && psw.equals("123456")) {
			//
			HttpSession session = req.getSession(true);
			session.setAttribute("code", code);
			session.setAttribute("psw", psw);
			// 跳转到登录成功的界面
			res.sendRedirect("demo4");
		} else {
			res.sendRedirect("liuxu");
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);

	}
}