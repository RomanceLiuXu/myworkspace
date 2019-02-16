package com.liuxu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Demo4 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 登录成功界面，显示用户的信息
		// 设置编码格式
		res.setContentType("text/html;charset=utf-8");
		HttpSession session = req.getSession(true);
		PrintWriter pw = res.getWriter();
		String code = (String) session.getAttribute("code");
		String psw = (String) session.getAttribute("psw");
		pw.println("欢迎你，" + code);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);

	}

}