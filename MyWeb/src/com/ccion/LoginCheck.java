package com.ccion;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//登录验证--链接数据库
public class LoginCheck extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html;charset=utf-8");
		// 新建集合存放学生集合
		List<Student> students = new ArrayList<>();
		Connection con = null;
		PreparedStatement pre = null;
		ResultSet re = null;
		// 连接数据库
		// 获取驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// 获取连接
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/mydb1?useUnicode=true&characterEncoding=UTF-8&useSSL=false", "root",
					"123456");
			// 获取预解析对象
			pre = con.prepareStatement("select * from mystudent ");
			// 获取结果集
			re = pre.executeQuery();
			// 遍历
			while (re.next()) {
				int id = re.getInt("id");
				String name = re.getString("name");
				String psw = re.getString("password");
				// 实例化学生对象
				Student stu = new Student(id, name, psw);
				students.add(stu);
			}
			System.out.println(students.size());
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
			if (pre != null) {
				try {
					pre.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (re != null) {
				try {
					re.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		}

		PrintWriter pw = res.getWriter();

		// 获取输入框的内容
		String name = req.getParameter("code");
		String psw = req.getParameter("psw");
		System.out.println(name + "--" + psw);
		
		boolean is = false;
		// 遍历集合
		for (Student student : students) {
				if (student.getName().equals(name)) {
					if (student.getPsw().equals(psw)) {
						is = true;
						// 跳转登录成功界面
						res.sendRedirect("home?code=" + name);
						break;
					}else {
						is = true;
						pw.println("密码错误");
						break;
					}
					
				} 
		}
		if (!is) {
			pw.println("数据库中无此用户");   
		}
	    
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	};
	
//	判断用户是否存在的方法
	
}
