package com.lanou.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;



/**
 * mysql存储过程的使用
 * 
 * @author LiuXu
 * @time2018年9月27日下午7:47:39
 **/
public class MysqlPro {

	public static void main(String[] args) {
//		test1();
		test2();
	}

	private static void test1() {
		try {
			int n = 10;
			// 加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 获取连接
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/liuxudb2?useUnicode=true&characterEncoding=utf8", "root", "123456");
			if (con!=null) {
				 CallableStatement cs = con.prepareCall("{call method9("+n+")}");
				 boolean bo = cs.execute();
				 if (bo) {
					System.out.println("存储过程执行查询");
				}else{
					System.out.println("存储过程执行非查询");
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("存储过程执行失败");
		}
	}
	private static void test2() {
		try {
			int n = 10;
			// 加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 获取连接
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/liuxudb2?useUnicode=true&characterEncoding=utf8", "root", "123456");
			if (con!=null) {
				 CallableStatement cs = con.prepareCall("{call insert_ord(?,?,?)}");
				 cs.setInt(1, 23);
				 cs.setString(2, "ss");
				 cs.setInt(3, 1000000);
				 boolean bo = cs.execute();
				 if (bo) {
					System.out.println("存储过程执行查询");
				}else{
					System.out.println("存储过程执行非查询");
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("存储过程执行失败");
		}
	}

}
