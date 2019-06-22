package com.ys.p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestJDBC {
	
	
	public static void main(String[] args) {
		
		try {
			//配置数据源
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection
			("jdbc:mysql://localhost:3306/wh","root","123456");
			
			Statement stat = conn.createStatement();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
}
