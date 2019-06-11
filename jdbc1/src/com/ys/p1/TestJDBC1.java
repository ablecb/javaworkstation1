package com.ys.p1;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC1 {
	
	public static void main(String[] args) {
		
		try {
			//注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			//建立数据库连接
			Connection conn = DriverManager.getConnection
			("jdbc:mysql://localhost:3306/my_data","root","123456");
			//url   user  pass
			System.out.println(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
}
