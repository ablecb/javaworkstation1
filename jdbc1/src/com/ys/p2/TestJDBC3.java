package com.ys.p2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestJDBC3 {
	
	
	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection
				("jdbc:mysql://localhost:3306/my_data","root","123456");
			//创建一个数据操作对象
			Statement sta = conn.createStatement();
			//当执行execute方法有结果集返回时 它返回true 要不返回的就是false
			/*ResultSet rs = sta.executeQuery("SELECT * FROM m1");
			while(rs.next()){
				
				
				
			}*/
			
			int t = sta.executeUpdate("DELETE FROM m1");
			
			System.out.println(t);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
}
