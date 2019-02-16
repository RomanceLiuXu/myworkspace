package com.liuxu.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author LiuXu
 * @time2018年9月27日下午7:06:34
 **/
public class JdbcOracle {

	public static void main(String[] args) {
		// 步骤
		// 1.加载驱动
		// 2.获取连接
		// 3.获取预解析对象
		// 4.执行操作，返回结果
		// 5.操作结果
		// 6.关闭
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// 加载驱动
			Class.forName("oracle.jdbc.OracleDriver");
			// 获取连接
			con = DriverManager.getConnection("jdbc:oracle:thin@127.0.0.1:orcl", "system", "12345");
			ps = con.prepareStatement("select name from myemp");
			rs = ps.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				System.out.println(name);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
